pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
            if (requested.id.id == "com.android.library") {
                useModule("com.android.tools.build:gradle:3.4.0")
            }
        }
    }
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "log-kotlin-mpp"


enableFeaturePreview("GRADLE_METADATA")
