package plugins

import Config
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.vlaskorobogatov.routiner.configureKotlinAndroid
import com.vlaskorobogatov.routiner.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.android.application.get().pluginId)
            apply(libs.plugins.kotlin.android.get().pluginId)
        }

        extensions.configure<BaseAppModuleExtension> {
            configureKotlinAndroid(this)

            namespace = Config.ApplicationId

            @Suppress("UnstableApiUsage")
            androidResources {
                generateLocaleConfig = true
            }

            defaultConfig {
                applicationId = Config.ApplicationId
                targetSdk = libs.versions.android.targetSdk.get().toInt()
                versionCode = Config.VersionCode
                versionName = Config.VersionName

                testInstrumentationRunner = Config.TestRunner

                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )

                buildTypes {
                    release {
                        isMinifyEnabled = Config.ReleaseMinifyEnabled
                        isShrinkResources = Config.ReleaseMinifyEnabled
                        isDebuggable = Config.ReleaseDebuggable

                        signingConfig = signingConfigs.getByName("debug")
                    }
                    debug {
                        isMinifyEnabled = Config.DebugMinifyEnabled
                        isShrinkResources = Config.DebugMinifyEnabled
                        isDebuggable = Config.DebugDebuggable
                    }
                }
                packagingOptions.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}
