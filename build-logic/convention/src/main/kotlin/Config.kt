import org.gradle.api.JavaVersion.VERSION_17

object Config {

    const val ApplicationId = "com.vlaskorobogatov.routiner"

    const val VersionCode = 1
    const val VersionName = "0.0.1"

    val JavaVersion = VERSION_17
    val JvmTarget = JavaVersion.toString()

    const val TestRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val ReleaseMinifyEnabled = true
    const val ReleaseDebuggable = true

    const val DebugMinifyEnabled = false
    const val DebugDebuggable = false
}
