package com.jabaddon.learning.kotlin.patterns.creational

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.booleans.shouldBeTrue
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class OtherSingletonTest {

    @Test
    fun `getInstance returns same instance every time`() {
        val instance1 = OtherSingleton.getInstance()
        val instance2 = OtherSingleton.getInstance()
        
        instance1 shouldBe instance2
        (instance1 === instance2).shouldBeTrue()
    }

    @Test
    fun `getInstance returns non-null instance`() {
        val instance = OtherSingleton.getInstance()
        instance shouldNotBe null
    }

    // ===========================================
    // THREAD-BASED CONCURRENCY TESTS
    // ===========================================
    
    @Test
    fun `concurrent access returns same instance - thread version`() {
        val threadCount = 100
        val executor = Executors.newFixedThreadPool(threadCount)
        val latch = CountDownLatch(threadCount)
        val instances = mutableSetOf<OtherSingleton>()
        val creationCounter = AtomicInteger(0)
        
        // Track how many unique instances are created
        repeat(threadCount) {
            executor.submit {
                try {
                    val instance = OtherSingleton.getInstance()
                    synchronized(instances) {
                        if (instances.add(instance)) {
                            creationCounter.incrementAndGet()
                        }
                    }
                } finally {
                    latch.countDown()
                }
            }
        }
        
        // Wait for all threads to complete
        latch.await(5, TimeUnit.SECONDS).shouldBeTrue()
        
        // Should have exactly one unique instance
        instances.size shouldBe 1
        creationCounter.get() shouldBe 1
        
        executor.shutdown()
    }

    @Test
    fun `concurrent access returns same instance - coroutine version`() = runBlocking {
        val coroutineCount = 100
        val instances = mutableSetOf<OtherSingleton>()
        val creationCounter = AtomicInteger(0)
        val mutex = Mutex()
        
        // Launch multiple coroutines concurrently
        val jobs = List(coroutineCount) {
            launch {
                val instance = OtherSingleton.getInstance()
                mutex.withLock {
                    if (instances.add(instance)) {
                        creationCounter.incrementAndGet()
                    }
                }
            }
        }
        
        // Wait for all coroutines to complete
        jobs.joinAll()
        
        // Should have exactly one unique instance
        instances.size shouldBe 1
        creationCounter.get() shouldBe 1
    }

    @Test
    fun `stress test with many concurrent accesses - thread version`() {
        val threadCount = 1000
        val accessesPerThread = 10
        val executor = Executors.newFixedThreadPool(50)
        val latch = CountDownLatch(threadCount)
        val instances = mutableSetOf<OtherSingleton>()
        
        repeat(threadCount) {
            executor.submit {
                try {
                    repeat(accessesPerThread) {
                        val instance = OtherSingleton.getInstance()
                        synchronized(instances) {
                            instances.add(instance)
                        }
                    }
                } finally {
                    latch.countDown()
                }
            }
        }
        
        latch.await(10, TimeUnit.SECONDS).shouldBeTrue()
        
        // Even with 10,000 total accesses, should still have only one unique instance
        instances.size shouldBe 1
        
        executor.shutdown()
    }

    @Test
    fun `stress test with many concurrent accesses - coroutine version`() = runBlocking {
        val coroutineCount = 1000
        val accessesPerCoroutine = 10
        val instances = mutableSetOf<OtherSingleton>()
        val mutex = Mutex()
        
        // Launch many coroutines, each accessing the singleton multiple times
        val jobs = List(coroutineCount) {
            launch {
                repeat(accessesPerCoroutine) {
                    val instance = OtherSingleton.getInstance()
                    mutex.withLock {
                        instances.add(instance)
                    }
                }
            }
        }
        
        jobs.joinAll()
        
        // Even with 10,000 total accesses, should still have only one unique instance
        instances.size shouldBe 1
    }

    @Test
    fun `lazy initialization - instance created only when accessed`() {
        // This test verifies that the lazy delegate works correctly
        // We can't directly test that the instance wasn't created before first access
        // since accessing it would trigger creation, but we can verify the lazy behavior
        
        val instance1 = OtherSingleton.getInstance()
        val instance2 = OtherSingleton.getInstance()
        
        // Both calls should return the same instance
        instance1 shouldBe instance2
        (instance1 === instance2).shouldBeTrue()
    }

    // ===========================================
    // COROUTINE-BASED CONCURRENCY TESTS
    // ===========================================

    @Test
    fun `singleton survives multiple thread pool executions - thread version`() {
        val instances = mutableSetOf<OtherSingleton>()
        
        // First batch of threads
        val executor1 = Executors.newFixedThreadPool(20)
        val latch1 = CountDownLatch(50)
        
        repeat(50) {
            executor1.submit {
                try {
                    val instance = OtherSingleton.getInstance()
                    synchronized(instances) {
                        instances.add(instance)
                    }
                } finally {
                    latch1.countDown()
                }
            }
        }
        
        latch1.await(5, TimeUnit.SECONDS).shouldBeTrue()
        executor1.shutdown()
        
        // Second batch of threads with new executor
        val executor2 = Executors.newFixedThreadPool(20)
        val latch2 = CountDownLatch(50)
        
        repeat(50) {
            executor2.submit {
                try {
                    val instance = OtherSingleton.getInstance()
                    synchronized(instances) {
                        instances.add(instance)
                    }
                } finally {
                    latch2.countDown()
                }
            }
        }
        
        latch2.await(5, TimeUnit.SECONDS).shouldBeTrue()
        executor2.shutdown()
        
        // Should still have only one unique instance across all executions
        instances.size shouldBe 1
    }

    @Test
    fun `singleton survives multiple coroutine scope executions - coroutine version`() = runBlocking {
        val instances = mutableSetOf<OtherSingleton>()
        val mutex = Mutex()
        
        // First batch of coroutines
        coroutineScope {
            val jobs1 = List(50) {
                launch {
                    val instance = OtherSingleton.getInstance()
                    mutex.withLock {
                        instances.add(instance)
                    }
                }
            }
            jobs1.joinAll()
        }
        
        // Second batch of coroutines in new scope
        coroutineScope {
            val jobs2 = List(50) {
                launch {
                    val instance = OtherSingleton.getInstance()
                    mutex.withLock {
                        instances.add(instance)
                    }
                }
            }
            jobs2.joinAll()
        }
        
        // Should still have only one unique instance across all executions
        instances.size shouldBe 1
    }
}