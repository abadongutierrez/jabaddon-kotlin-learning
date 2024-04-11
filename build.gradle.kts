plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.jabaddon.learning.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.michael-bull.kotlin-result:kotlin-result:1.1.16")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}