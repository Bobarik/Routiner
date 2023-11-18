plugins {
    id("routiner.android.feature")
}
android.namespace = "com.vlaskorobogatov.routiner.root"

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.arch.compose)
    implementation(projects.feature.splash)
}