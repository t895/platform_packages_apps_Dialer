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
    namespace = "com.android.dialer.app"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.core.ui)
    implementation(libs.design)

    implementation(libs.geocoder)

    implementation(project(":dialer:common"))
    implementation(project(":contacts-common"))
    implementation(project(":dialer:blocking"))
    implementation(project(":dialer:calldetails"))
    implementation(project(":dialer:calllogutils"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:theme:common"))
}
