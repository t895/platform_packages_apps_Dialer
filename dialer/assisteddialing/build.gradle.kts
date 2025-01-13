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
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.geocoder)

    implementation(libs.protobuf.java)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:common"))
    implementation(project(":dialer:strictmode"))
    implementation(project(":dialer:function"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:phonenumberutil"))
}
