plugins {
    id("routiner.android.library")
    id("routiner.android.library.compose")
}

android.namespace = "com.vlaskorobogatov.routiner.designsystem"

dependencies {

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)
}
