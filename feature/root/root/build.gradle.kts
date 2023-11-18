plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.arch.core)
    implementation(projects.feature.root.rootapi)
    implementation(projects.feature.splash.splashapi)

    implementation(libs.kotlinx.serialization)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}