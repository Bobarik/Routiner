plugins {
    id("routiner.android.feature")
}
android.namespace = "com.vlaskorobogatov.routiner.rootui"

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.arch.compose)
    implementation(projects.feature.splash.splashui)
    implementation(projects.feature.splash.splashapi)
    implementation(projects.feature.root.rootapi)
}
