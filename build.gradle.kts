plugins {
    kotlin("jvm") version "1.8.0"
    application
    kotlin("plugin.serialization") version "1.8.0"
    id("org.jetbrains.dokka") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

dependencies {
    implementation("junit:junit:4.13.2")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation ("com.charleskorn.kaml:kaml:0.51.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
    implementation("io.mockk:mockk:1.13.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
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

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest.attributes.apply {
        put("Main-Class", "MainKt")
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}