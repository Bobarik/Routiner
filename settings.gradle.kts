pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Routiner"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

fun includeFeature(feature: File) = feature.listFiles()?.forEach { file -> includeModule(file) }

fun includeModule(file: File) = include(file.path.replace(File.separatorChar, ':'))

File("feature").listFiles()?.forEach { file ->
    includeFeature(file)
}

include(":app")
include(":core:arch:core")
include(":core:arch:compose")
include(":core:design-system")
