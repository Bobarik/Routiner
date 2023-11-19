plugins {
    id("routiner.android.feature")
}
android.namespace = "com.vlaskorobogatov.routiner.onboardingui"

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.arch.compose)
    implementation(projects.feature.onboarding.onboardingapi)
}
