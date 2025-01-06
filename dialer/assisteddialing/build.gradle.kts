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
    namespace = "com.android.dialer.assisteddialing"
    compileSdk = 35

    defaultConfig {
        minSdk = 35
    }
}

dependencies {
}
