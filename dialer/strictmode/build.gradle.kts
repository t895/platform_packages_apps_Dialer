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
    namespace = "com.android.dialer.strictmode"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.dagger)

    implementation(libs.support.annotations)
    implementation(libs.support.v4)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(project(":dialer:inject"))
    implementation(project(":dialer:common"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:buildtype"))
    implementation(project(":dialer:function"))
}
