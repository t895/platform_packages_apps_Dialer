import com.google.protobuf.gradle.proto

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.protobuf)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

android {
    namespace = "com.android.dialer.enrichedcall"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets.getByName("main") {
        proto { srcDir("./src/main/java") }
    }
}

protobuf {
    protoc {
        artifact = libs.versions.protoc.artifact.get()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.support.annotations)

    implementation(libs.protobuf.java)

    implementation(libs.dagger)

    compileOnly(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:inject"))
    implementation(project(":dialer:multimedia"))

    implementation(project(":incallui:videotech"))

    implementation(project(":proto"))
}
