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
    namespace = "com.android.dialer.blocking"
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

    implementation(project(":contacts-common"))

    implementation(project(":dialer:common"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:database:calllogqueryhandler"))
    implementation(project(":dialer:strictmode"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:theme:common"))
    implementation(project(":dialer:database"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:function"))
    implementation(project(":dialer:location"))
    implementation(project(":dialer:notification"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:voicemailstatus:visualvoicemailenabledchecker"))
    implementation(project(":dialer:util"))

    implementation(project(":quantum"))

    implementation(project(":proto"))
}
