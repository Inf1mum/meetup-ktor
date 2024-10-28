import io.ktor.plugin.features.*
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

application {
    mainClass.set("ru.tbank.ApplicationKt")
}

tasks.withType<KotlinCompile> {
    val projectJvmTarget: String by project
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

ktor {
    docker {
        jreVersion = JavaVersion.VERSION_21
        portMappings.set(listOf(
            DockerPortMapping(8080, 8080, DockerPortMappingProtocol.TCP)
        ))
    }
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.mongo)
    implementation(libs.bundles.kafka)
    ksp(libs.koin.ksp)
}
