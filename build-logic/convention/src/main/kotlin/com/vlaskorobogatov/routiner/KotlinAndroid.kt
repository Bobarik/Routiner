package com.vlaskorobogatov.routiner

import Config
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) =
    with(commonExtension) {
        compileSdk = libs.versions.android.compileSdk.get().toInt()

        defaultConfig {
            minSdk = libs.versions.android.minSdk.get().toInt()
            testInstrumentationRunner = Config.TestRunner
        }

        compileOptions {
            sourceCompatibility = Config.JavaVersion
            targetCompatibility = Config.JavaVersion
            isCoreLibraryDesugaringEnabled = true
        }

        kotlinOptions {
            jvmTarget = Config.JvmTarget
        }

        dependencies {
            "coreLibraryDesugaring"(libs.desugar.jdk.libs.nio)
        }
    }

private fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) =
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
