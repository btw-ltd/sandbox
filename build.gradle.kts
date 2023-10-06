val ktor_version = "2.3.4"
val logback_version = "1.4.11"
val koin_version = "3.5.0"
val koin_ktor_version = "3.5.1"
val exposedVersion = "0.44.0"
val h2_version = "2.1.214"
val kotlinxSerializationVersion = "1.6.0"

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.10"
    id("io.ktor.plugin") version "2.3.4"
    `maven-publish`
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
    implementation("io.ktor:ktor-server-call-logging:$ktor_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")

    implementation("com.h2database:h2:$h2_version")
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/btw-ltd/sandbox")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
            pom {
                name = "Ktor demo app"
                description = "A concise description of my library"
            }
        }
    }
}