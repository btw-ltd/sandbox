val ktor_version = "2.3.4"
val logback_version = "1.4.11"
val koin_version = "3.5.0"
val koin_ktor_version = "3.5.1"

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.10"
    id("io.ktor.plugin") version "2.3.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-server-netty:$ktor_version")

    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.insert-koin:koin-logger-slf4j:$koin_ktor_version")

    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-server-resources:$ktor_version")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("ApplicationKt")
}