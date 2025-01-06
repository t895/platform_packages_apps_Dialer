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
    namespace = "com.android.dialer.searchfragment.directories"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.recyclerview.v7)
    implementation(project(":dialer:common"))
    implementation(project(":dialer:contactphoto"))
    implementation(project(":dialer:lettertile"))
    implementation(project(":dialer:searchfragment:common"))
}
