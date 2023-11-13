plugins {
    id("routiner.android.feature")
}
android.namespace = "com.vlaskorobogatov.routiner.sample"

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.arch.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)
}
