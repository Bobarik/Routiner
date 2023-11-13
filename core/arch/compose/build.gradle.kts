plugins {
    id("routiner.android.library")
    id("routiner.android.library.compose")
}

android.namespace = "com.vlaskorobogatov.routiner.arch.compose"

dependencies {
    api(projects.core.arch.core)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    // Lifecycle
    implementation(libs.lifecycle.runtime.compose)

    // Decompose
    implementation(libs.decompose)

    // MVI
    implementation(libs.bundles.mvikotlin)
}
