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
    namespace = "com.android.dialer.smartdial"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.guava)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:dialpadview"))
    implementation(project(":dialer:i18n"))
    implementation(project(":dialer:database"))
    implementation(project(":dialer:util"))
}
