plugins {
    `kotlin-dsl`
}

group = "com.vlaskorobogatov.routiner.buildlogic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "routiner.android.application"
            implementationClass = "plugins.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "routiner.android.application.compose"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "routiner.android.library"
            implementationClass = "plugins.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "routiner.android.library.compose"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "routiner.android.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }
        register("androidFeatureApi") {
            id = "routiner.android.feature.api"
            implementationClass = "plugins.AndroidFeatureApiConventionPlugin"
        }
        register("androidLint") {
            id = "routiner.android.lint"
            implementationClass = "plugins.AndroidLintConventionPlugin"
        }
        register("detekt") {
            id = "routiner.detekt"
            implementationClass = "plugins.DetektConventionPlugin"
        }
    }
}
