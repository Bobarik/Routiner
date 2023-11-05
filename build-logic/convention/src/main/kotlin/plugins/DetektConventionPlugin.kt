package plugins

import com.vlaskorobogatov.routiner.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class DetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.plugins.detekt.get().pluginId)

        extensions.configure<DetektExtension> {
            toolVersion = libs.versions.detekt.get()
            source.setFrom(files(rootDir))
            config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
            buildUponDefaultConfig = true
            parallel = true
        }

        dependencies {
            "detektPlugins"(libs.detekt.formatting)
        }

        tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
            exclude("**/build/**")
            exclude("config/**")
        }
    }
}
