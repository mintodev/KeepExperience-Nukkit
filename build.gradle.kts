import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    application
}

group = "com.mintod.keepexperience"
version = "1.2.0"

repositories {
    mavenCentral()

    maven() {
        url = uri("https://repo.opencollab.dev/maven-snapshots/")
    }
}

dependencies {
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.mintod.keepexperience.Main")
}