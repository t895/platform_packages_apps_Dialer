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
    namespace = "com.android.dialer.callcomposer"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.v4)
    implementation(libs.appcompat.v7)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(libs.glide)

    implementation(libs.protobuf.java)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:callcomposer:cameraui"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:theme:base"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:constants"))
    implementation(project(":dialer:callintent"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:contactphoto"))
    implementation(project(":dialer:dialercontact"))
    implementation(project(":dialer:enrichedcall"))
    implementation(project(":dialer:multimedia"))
    implementation(project(":dialer:precall"))
    implementation(project(":dialer:protos"))
    implementation(project(":dialer:storage"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:widget"))

    implementation(project(":incallui:callpending"))
}
