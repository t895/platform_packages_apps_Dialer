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
    namespace = "com.android.dialer.inject"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets.getByName("main") {
        java.exclude("**/demo/**")
    }
}

dependencies {
    implementation(libs.support.v4)

    implementation(libs.dagger)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)
}
