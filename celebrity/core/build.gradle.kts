plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("kotlin-kapt")
    id("org.jetbrains.kotlinx.kover") version "0.7.6" apply true
}

android {
    namespace = "dev.ivan_belyaev.core"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.navigation.fragment.ktx)
    kapt(libs.dagger.compiler)
    implementation(libs.retrofit2.converter.gson2)
    implementation(libs.retrofit)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.dagger)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.dagger.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}