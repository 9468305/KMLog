buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.1")
        classpath(kotlin("gradle-plugin", "1.3.31"))
    }
}

plugins {
    kotlin("multiplatform") version("1.3.31")
    id("com.android.library")
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
    testOptions {
        unitTests.setIncludeAndroidResources(true)
    }
}

kotlin {
    jvm()
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
        named("jvmMain") {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        named("jvmTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        named("androidMain") {
            dependencies {
                implementation(kotlin("stdlib-jdk7"))
            }
        }
        named("androidTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation("org.robolectric:robolectric:4.2")
                /*
                implementation("androidx.test:core:1.1.0")
                implementation("androidx.test.ext:junit:1.1.0")
                implementation("androidx.test:runner:1.1.1")
                implementation("androidx.test:rules:1.1.1")*/

            }
        }
        named("iosMain") {
        }
        named("iosTest") {
        }
    }
}

tasks.register("iosTest") {
    mustRunAfter("linkTestDebugExecutableIos")
    //kotlin.targets["ios"].let { it as KotlinNativeTarget }.binaries.getExecutable("test", "DEBUG").outputFile
    group = JavaBasePlugin.VERIFICATION_GROUP
    description = "Run tests for target iOS on simulator"
    val ios = kotlin.iosX64("ios")
    doLast {
        val binary = ios.binaries.getExecutable("test", "Debug").outputFile
        exec {
            commandLine("xcrun", "simctl", "spawn", "iPhone 8", binary.absolutePath)
        }
    }
}

tasks.named("check") {
    dependsOn("iosTest")
    //finalizedBy("iosTest")
}

configurations.create("compileClasspath")
