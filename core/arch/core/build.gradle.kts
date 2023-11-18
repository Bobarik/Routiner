plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    api(libs.kotlinx.coroutines)

    api(libs.decompose)

    api(libs.bundles.mvikotlin)
}
