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
    namespace = "com.android.dialer.phonenumberutil"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.guava)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:compat"))
    implementation(project(":dialer:i18n"))
    implementation(project(":dialer:oem"))
    implementation(project(":dialer:phonenumbergeoutil"))
    implementation(project(":dialer:telecom"))
}
