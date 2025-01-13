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
    namespace = "com.android.incallui.incall.protocol"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:multimedia"))
    implementation(project(":dialer:assisteddialing"))
    implementation(project(":dialer:preferredsim:suggestion"))

    implementation(project(":incallui:call"))
    implementation(project(":incallui:videotech"))
}
