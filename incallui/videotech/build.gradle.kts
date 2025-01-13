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
    namespace = "com.android.dialer.videotech"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.guava)

    implementation(libs.protobuf.java)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:duo"))
    implementation(project(":dialer:configprovider"))

    implementation(project(":incallui:video:protocol"))
}
