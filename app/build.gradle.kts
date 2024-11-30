plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //    kapt
    id("kotlin-kapt")
//    hilt
    alias(libs.plugins.hilt)
//    id("androidx.navigator.sefeargs.kotlin")
//    kotlin("kapt")
}

android {
    namespace = "com.example.androidthemovedb"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.androidthemovedb"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
//    implementation(libs.hilt.navigation.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // retrofit
    implementation(libs.retrofit)
//    implementation(libs.adapter.rxjava2)
    implementation(libs.converter.gson)

////    // rxandroid
////    implementation(libs.loggin.interceptor)

    //OkHTTP
    implementation(libs.logging.interceptor)

    // navigation components
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // glide
    implementation (libs.glide)

    kapt(libs.compiler)

}