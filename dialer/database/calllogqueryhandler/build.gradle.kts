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
    namespace = "com.android.dialer.database"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(project(":contacts-common"))

    implementation(project(":dialer:common"))
    implementation(project(":dialer:phonenumbercache"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:voicemailstatus"))

    implementation(project(":voicemail"))
}
