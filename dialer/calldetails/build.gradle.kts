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
    namespace = "com.android.dialer.calldetails"
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
    implementation(libs.appcompat.v7)
    implementation(libs.recyclerview.v7)

    implementation(libs.protobuf.java)

    implementation(libs.geocoder)

    implementation(libs.guava)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:clipboard"))
    implementation(project(":dialer:callintent"))
    implementation(project(":dialer:postcall"))
    implementation(project(":dialer:precall"))
    implementation(project(":dialer:theme:base"))
    implementation(project(":dialer:logging"))
    implementation(project(":dialer:performancereport"))
    implementation(project(":dialer:glidephotomanager"))
    implementation(project(":dialer:oem"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:enrichedcall"))
    implementation(project(":dialer:calllogutils"))
    implementation(project(":dialer:glidephotomanager"))
    implementation(project(":dialer:enrichedcall:historyquery"))

    implementation(project(":proto"))
}
