plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.arch.core)
    implementation(projects.feature.onboarding.onboardingapi)

    implementation(libs.kotlinx.serialization)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}
