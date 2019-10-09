pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
                "com.android.library" -> useModule("com.android.tools.build:gradle:${requested.version}")
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
rootProject.name = "log-kotlin"


enableFeaturePreview("GRADLE_METADATA")
