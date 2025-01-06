plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

android {
    namespace = "com.android.dialer.util"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.appcompat.v7)

    implementation(libs.guava)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:phonenumberutil"))
}
