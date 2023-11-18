plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.coroutines)

    api(libs.decompose)

    implementation(libs.bundles.mvikotlin)
}
