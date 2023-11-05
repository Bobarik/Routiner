package plugins

import com.vlaskorobogatov.routiner.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureApiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("routiner.android.library")
            }

            dependencies {
                "implementation"(libs.decompose)
            }
        }
    }
}
