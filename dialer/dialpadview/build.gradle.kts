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
    namespace = "com.android.dialer.dialpadview"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)
    implementation(libs.design)

    implementation(libs.guava)

    implementation(libs.protobuf.java)

    implementation(libs.zxing.core)

    implementation(project(":contacts-common"))

    implementation(project(":dialer:animation"))
    implementation(project(":dialer:callintent"))
    implementation(project(":dialer:location"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:oem"))
    implementation(project(":dialer:performancereport"))
    implementation(project(":dialer:phonenumberutil"))
    implementation(project(":dialer:precall"))
    implementation(project(":dialer:proguard"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:common"))
    implementation(project(":dialer:i18n"))
    implementation(project(":dialer:widget"))
    implementation(project(":dialer:dialpadview:theme"))
    implementation(project(":dialer:compat"))

    implementation(project(":proto"))

    implementation(project(":lib:platform_frameworks_ex:common"))
}
