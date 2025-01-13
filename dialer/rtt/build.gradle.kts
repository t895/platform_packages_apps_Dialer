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
    namespace = "com.android.dialer.rtt"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)
    implementation(libs.recyclerview.v7)

    implementation(libs.guava)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:widget"))
    implementation(project(":dialer:preferredsim:impl"))
    implementation(project(":dialer:configprovider"))

    implementation(project(":proto"))
}
