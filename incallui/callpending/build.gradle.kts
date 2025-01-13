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
    namespace = "com.android.incallui.callpending"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:enrichedcall"))
    implementation(project(":dialer:multimedia"))

    implementation(project(":incallui:audiomode"))
    implementation(project(":incallui:call"))
    implementation(project(":incallui:incall"))
}
