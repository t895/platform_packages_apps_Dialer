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
    namespace = "com.android.dialer.phonenumbercache"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.protobuf.java)

    implementation(project(":contacts-common"))

    implementation(project(":dialer:common"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:oem"))
    implementation(project(":dialer:phonenumberutil"))
    implementation(project(":dialer:telecom"))

    implementation(project(":proto"))
}
