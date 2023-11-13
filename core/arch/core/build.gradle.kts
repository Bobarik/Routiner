plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.coroutines)

    api(libs.decompose)

    api(libs.bundles.mvikotlin)
}
