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
    namespace = "com.android.incallui.incall"
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
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:strictmode"))
    implementation(project(":dialer:widget"))
    implementation(project(":dialer:multimedia"))
    implementation(project(":dialer:preferredsim:suggestion"))
    implementation(project(":dialer:assisteddialing"))

    implementation(project(":incallui:audioroute"))
    implementation(project(":incallui:contactgrid"))
    implementation(project(":incallui:call"))
    implementation(project(":incallui:videotech"))
}
