package plugins

import Config
import com.android.build.gradle.LibraryExtension
import com.vlaskorobogatov.routiner.configureKotlinAndroid
import com.vlaskorobogatov.routiner.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.kotlin.android.get().pluginId)
        }

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)

            defaultConfig {
                buildTypes {
                    release {
                        isMinifyEnabled = Config.ReleaseMinifyEnabled
                        proguardFiles("proguard-rules.pro")
                    }
                }
            }
        }
    }
}
