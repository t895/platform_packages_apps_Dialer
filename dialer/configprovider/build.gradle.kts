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
    namespace = "com.android.dialer.configprovider"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.dagger)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:strictmode"))
    implementation(project(":dialer:inject"))
    implementation(project(":dialer:function"))
}
