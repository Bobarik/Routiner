plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(projects.core.arch.core)
    implementation(projects.feature.splash.splashapi)
}
