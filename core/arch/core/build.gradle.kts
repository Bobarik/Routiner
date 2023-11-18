plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.coroutines)

    implementation(libs.decompose)

    implementation(libs.bundles.mvikotlin)
}
