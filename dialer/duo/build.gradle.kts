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
    namespace = "com.android.dialer.duo"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.dagger)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(libs.guava)

    implementation(project(":dialer:inject"))
    implementation(project(":dialer:common"))
}
