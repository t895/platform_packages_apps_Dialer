import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.protobuf)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

android {
    namespace = "com.android.dialer"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.android.dialer"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 2900000 + 1
        versionName = "23.0.1"
    }

    buildFeatures {
        aidl = true
        buildConfig = true
    }

    packaging {
        resources.excludes.add("META-INF/DEPENDENCIES")
    }

    sourceSets.getByName("main") {
//        proto { srcDir("../java") }
//        aidl { srcDir("../java") }
        manifest.srcFile("../AndroidManifest.xml")
    }

    val keystorePropertiesFile = rootProject.file("keystore.properties")
    val useKeystoreProperties = keystorePropertiesFile.canRead()
    val keystoreProperties = Properties()
    if (useKeystoreProperties) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    if (useKeystoreProperties) {
        signingConfigs {
            create("release") {
                storeFile = rootProject.file(keystoreProperties["storeFile"]!!)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                enableV4Signing = true
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
//                "../proguard.flags",
//                "../java/com/android/dialer/proguard/proguard_base.flags",
//                "../java/com/android/dialer/proguard/proguard.flags",
//                "../java/com/android/dialer/proguard/proguard_release.flags"
            )
            signingConfig = if (useKeystoreProperties) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")
            }
            applicationIdSuffix = ".preview"
            resValue("string", "applicationLabel", "Preview Phone")
        }

        debug {
            applicationIdSuffix = ".debug"
            resValue("string", "applicationLabel", "Phone d")
        }
    }

    lint {
        abortOnError = false
    }
}

protobuf {
    protoc {
        artifact = libs.versions.protoc.artifact.get()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.support.core.ui)
    implementation(libs.design)
    implementation(libs.support.v13)
    implementation(libs.support.v4)
    implementation(libs.appcompat.v7)
    implementation(libs.cardview.v7)
    implementation(libs.recyclerview.v7)
    implementation(libs.support.annotations)

    implementation(libs.geocoder)

    implementation(libs.guava)

    implementation(libs.dagger)
    annotationProcessor(libs.dagger.compiler)

    implementation(libs.protobuf.java)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    compileOnly(libs.auto.service.annotations)
    annotationProcessor(libs.auto.service)

    compileOnly(libs.auto.common)
    implementation(libs.zxing.core)
    implementation(libs.javapoet)

    // Using an old version because they migrated to androidx in 4.10.0 which breaks building with
    // the android support libraries
    // TODO: Migrate to Androidx and update Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    implementation(libs.volley)

    implementation(libs.shortcutbadger)

    implementation(libs.apache.mime4j.core)
    implementation(libs.apache.mime4j.dom)

    implementation(libs.grpc.stub)
    implementation(libs.grpc.protobuf)
    implementation(libs.grpc.okhttp)

    implementation(project(":libbackup"))
    implementation(project(":lib:platform_frameworks_ex:common"))

    implementation(libs.commons.io)

    implementation(libs.javax.annotation.api)

    implementation(project(":dialer:app"))
}
