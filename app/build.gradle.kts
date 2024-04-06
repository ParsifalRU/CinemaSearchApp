plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    id("kotlin-kapt")
    id("org.jetbrains.kotlinx.kover") version "0.7.6" apply true
}

android {
    namespace = "dev.ivan_belyaev.cinemasearchapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.ivan_belyaev.cinemasearchapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":celebrity:core"))
    implementation(project(":celebrity:core_impl"))
    implementation(project(":celebrity:core_factory"))

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson2)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.dagger)
    implementation(libs.javax.inject)
    kapt(libs.dagger.compiler)
    kapt("com.google.dagger:dagger-android-processor:2.47")
}