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
    namespace = "com.android.incallui.contactgrid"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.protobuf.java)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:glidephotomanager"))
    implementation(project(":dialer:lettertile"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:widget"))

    implementation(project(":incallui:incall:protocol"))
}
