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
    namespace = "com.android.dialer.preferredsim"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.dagger)

    implementation(libs.guava)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(project(":contacts-common"))

    implementation(project(":dialer:common"))
    implementation(project(":dialer:configprovider"))
    implementation(project(":dialer:inject"))
    implementation(project(":dialer:preferredsim:impl"))
    implementation(project(":dialer:preferredsim:suggestion"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:constants"))

    implementation(project(":proto"))
}
