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
    namespace = "com.android.dialer.theme.base"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.design)
    implementation(libs.support.annotations)

    implementation(libs.dagger)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:inject"))
    implementation(project(":dialer:theme:hidden"))
}
