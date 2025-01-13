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
    namespace = "com.android.contacts.common"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets.getByName("main") {
        proto { srcDir("./src") }
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
    implementation(libs.support.v4)

    implementation(libs.guava)

    implementation(libs.protobuf.java)

    implementation(libs.geocoder)

    implementation(project(":dialer:common"))
    implementation(project(":dialer:util"))
    implementation(project(":dialer:phonenumberutil"))
    implementation(project(":dialer:telecom"))
    implementation(project(":dialer:location"))
    implementation(project(":dialer:protos"))
    implementation(project(":dialer:contacts:resources"))
    implementation(project(":dialer:callintent"))
    implementation(project(":dialer:contactphoto"))
    implementation(project(":dialer:lettertile"))
    implementation(project(":dialer:animation"))
    implementation(project(":dialer:precall"))
}
