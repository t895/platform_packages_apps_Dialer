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
    namespace = "com.google.android.libraries.backup"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets.getByName("main") {
        java.srcDirs("libbackup/src")
        java.exclude("**/shadow/**")
    }
}

dependencies {
    compileOnly("com.android.support:support-annotations:28.0.0")
}
