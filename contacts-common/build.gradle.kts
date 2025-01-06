import com.google.protobuf.gradle.proto

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.protobuf")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

android {
    namespace = "com.android.contacts.common"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets.getByName("main") {
        proto { srcDir("./src") }
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.guava)

    implementation(project(":dialer:util"))
    implementation(project(":dialer:phonenumberutil"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:location"))
    implementation(project(":dialer:protos"))
    implementation(project(":dialer:contacts:resources"))
}
