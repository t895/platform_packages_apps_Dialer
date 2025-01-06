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
    namespace = "com.android.dialer.main.impl"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(project(":dialer:blockreportspam"))
    implementation(project(":dialer:calllog:config"))
    implementation(project(":dialer:common"))
    implementation(project(":dialer:interactions"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:main:impl:bottomnav"))
}
