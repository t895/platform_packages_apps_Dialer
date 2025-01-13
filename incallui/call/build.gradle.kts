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
    namespace = "com.android.incallui.call"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.guava)

    implementation(project(":contacts-common"))

    implementation(project(":dialer:assisteddialing"))
    implementation(project(":dialer:blocking"))
    implementation(project(":dialer:callintent"))
    implementation(project(":dialer:common"))
    implementation(project(":dialer:compat"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:duo"))
    implementation(project(":dialer:enrichedcall"))
    implementation(project(":dialer:location"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:preferredsim"))
    implementation(project(":dialer:rtt"))
    implementation(project(":dialer:spam"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:theme:common"))
    implementation(project(":dialer:time"))
    implementation(project(":dialer:util"))

    implementation(project(":incallui:audiomode"))
    implementation(project(":incallui:latencyreport"))
    implementation(project(":incallui:rtt:protocol"))
    implementation(project(":incallui:videotech"))

    implementation(project(":proto"))
}
