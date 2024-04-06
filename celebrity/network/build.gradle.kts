@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("kotlin-kapt")
}

android {
    namespace = "dev.ivan_belyaev.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":celebrity:core"))
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation ("com.google.dagger:dagger-android:2.47")
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.47")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.47")
    implementation ("com.google.dagger:dagger-android-support:2.47")
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.javax.inject)
    implementation(libs.retrofit2.converter.gson2)
    implementation(libs.retrofit)
}