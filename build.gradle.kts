plugins {
    kotlin("multiplatform") version "1.8.0"
    // id("com.android.application")
}

group = "org.example"
version = "0.1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    // val hostOs = System.getProperty("os.name")
    // val isMingwX64 = hostOs.startsWith("Windows")
    // val nativeTarget = when {
    //     hostOs == "Mac OS X" -> macosX64("native")
    //     hostOs == "Linux" -> linuxX64("native")
    //     isMingwX64 -> mingwX64("native")
    //     else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    // }

    
    // android()
    // iosArm64 {
    //     binaries {
    //         framework {
    //             baseName = "library"
    //         }
    //     }
    // }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.bitcoindevkit:bdk-jvm:0.26.0")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.bitcoindevkit:bdk-jvm:0.26.0")
            }
        }
        // val nativeMain by getting
        // val nativeTest by getting
        // val androidMain by getting {
        //     dependencies {
        //         implementation("com.google.android.material:material:1.5.0")
        //     }
        // }
        // val androidTest by getting {
        //     dependencies {
        //         implementation("junit:junit:4.13.2")
        //     }
        // }
        // val iosArm64Main by getting
        // val iosArm64Test by getting
    }
}

// android {
//     compileSdkVersion(31)
//     sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//     defaultConfig {
//         applicationId = "org.example.library"
//         minSdkVersion(24)
//         targetSdkVersion(31)
//     }
//     compileOptions {
//         sourceCompatibility = JavaVersion.VERSION_1_8
//         targetCompatibility = JavaVersion.VERSION_1_8
//     }
// }