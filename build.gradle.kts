buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.1")
        classpath(kotlin("gradle-plugin", "1.3.50"))
    }
}

plugins {
    kotlin("multiplatform") version("1.3.50")
    id("com.android.library") version("3.5.1")
    id("maven-publish")
}

repositories {
    google()
    jcenter()
    mavenCentral()
}
group = "app.chenqi"
version = "0.1.0"

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
    androidNativeArm32() {
        binaries {
            sharedLib {
                baseName = "log"
            }
        }
    }
    iosArm64("ios")
    iosX64()
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
        val iosMain by getting {
        }

        val iosTest by getting {
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Test by getting {
            dependsOn(iosTest)
        }
        named("androidNativeArm32Main") {
        }
        named("androidNativeArm32Test") {
        }
    }
}
/*
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

tasks.register("androidNativeArm32Test") {
    //TODO: test executable file is not executable, but a so file.
    mustRunAfter("linkTestDebugExecutableAndroidNativeArm32")
    group = JavaBasePlugin.VERIFICATION_GROUP
    description = "Run tests for target Android Native on simulator/device"
    val an = kotlin.androidNativeArm32()
    doLast {
        val binary = an.binaries.getExecutable("test", "Debug").outputFile
        val adb = android.adbExecutable
        exec {
            commandLine(adb.absolutePath, "push", binary.absolutePath, "/data/local/tmp/${binary.name}")
            commandLine(adb.absolutePath, "shell", "/data/local/tmp/${binary.name}")
        }
    }
}

tasks.named("check") {
    dependsOn("iosTest")
    //dependsOn("androidNativeArm32Test")
}
*/
configurations.create("compileClasspath")
