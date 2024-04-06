plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("kotlin-kapt")
}

android {
    namespace = "dev.ivan_belyaev.core_implementation"
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

    implementation(libs.javax.inject)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson2)
    implementation(libs.logging.interceptor)
    implementation(libs.dagger)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    kapt(libs.dagger.compiler)
    kapt("com.google.dagger:dagger-android-processor:2.47")
    implementation(libs.androidx.core.ktx)

}