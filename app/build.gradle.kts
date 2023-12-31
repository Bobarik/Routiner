plugins {
    id("routiner.android.application")
    id("routiner.android.application.compose")
    id("routiner.android.lint")
}

dependencies {

    implementation(projects.core.designSystem)
    implementation(projects.feature.root.root)
    implementation(projects.feature.root.rootapi)
    implementation(projects.feature.root.rootui)
    implementation(projects.feature.splash.splash)
    implementation(projects.feature.start.start)
    implementation(projects.feature.onboarding.onboarding)

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.mvikotlin)
    implementation(libs.mvikotlin.main)

    implementation(libs.decompose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
