buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath(kotlin("gradle-plugin", version = "1.3.30"))
    }
}
plugins {
    kotlin("multiplatform") version("1.3.30")
    id("com.android.library")
    //id("kotlin-android")
}
repositories {
    google()
    jcenter()
    mavenCentral()
}
group = "app.chenqi"
version = "0.1.0"

apply {
    plugin("maven-publish")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        //applicationId = "app.chenqi.log"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "0.1.0"
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

kotlin {
    android()
    // This is for iPhone emulator
    // Switch here to iosArm64 (or iosArm32) to build library for iPhone device
    iosX64("ios") {
        binaries {
            framework()
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        named("androidMain") {
            dependencies {
                implementation(kotlin("stdlib-jdk7"))
            }
        }
        named("androidTest") {
            dependencies {
                //implementation(kotlin("stdlib-jdk7"))
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                //implementation("junit:junit:4.12")
            }
        }
        named("iosMain") {
        }
        named("iosTest") {
        }
    }
}

/*
task iosTest {
    def device = project.findProperty("iosDevice")?.toString() ?: "iPhone 8"
    dependsOn kotlin.targets.ios.binaries.getExecutable('test', 'DEBUG').linkTaskName
    group = JavaBasePlugin.VERIFICATION_GROUP
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        def binary = kotlin.targets.ios.binaries.getExecutable('test', 'DEBUG').outputFile
        exec {
            commandLine 'xcrun', 'simctl', 'spawn', device, binary.absolutePath
        }
    }
}

*/
configurations.create("compileClasspath")