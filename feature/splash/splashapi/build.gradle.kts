plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(projects.core.arch.core)
    api(projects.feature.start.startapi)
}
