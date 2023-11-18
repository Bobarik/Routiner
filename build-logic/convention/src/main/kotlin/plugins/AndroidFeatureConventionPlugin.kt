package plugins

import com.vlaskorobogatov.routiner.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply("routiner.android.library")
            apply("routiner.android.library.compose")
        }

        dependencies {
            // UI
            "implementation"(platform(libs.compose.bom))
            "implementation"(libs.bundles.compose)
            "debugImplementation"(libs.bundles.compose.debug)

            // Lifecycle
            "implementation"(libs.lifecycle.runtime.compose)

            // DI
            "implementation"(platform(libs.koin.bom))
            "implementation"(libs.koin.compose)

            // Decompose
            "implementation"(libs.decompose)
            "implementation"(libs.decompose.compose)
        }
    }
}
