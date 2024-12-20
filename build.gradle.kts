plugins {
    kotlin("jvm") version "1.9.23"
    application
}

group = "com.jabaddon.learning.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testImplementation(kotlin("test"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.3")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
    implementation("com.michael-bull.kotlin-result:kotlin-result:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("MainKt")
}