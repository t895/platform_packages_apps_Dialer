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
    namespace = "com.android.dialer.spam"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)
    implementation(libs.design)
    implementation(libs.support.v4)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(libs.guava)

    implementation(libs.dagger)

    implementation(libs.protobuf.java)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:inject"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:notification"))
    implementation(project(":dialer:theme:base"))
    implementation(project(":dialer:theme:common"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:phonenumberproto"))
    implementation(project(":dialer:logging"))

    implementation(project(":quantum"))
}
