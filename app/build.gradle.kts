plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.pokedex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokedex"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.compose.material:material-icons-core:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material-icons-extended:${rootProject.extra["compose_version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04")
    implementation("androidx.navigation:navigation-compose:1.0.0-alpha09")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha05")

    // Retrofit
    //noinspection UseTomlInstead
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_version"]}")
    //noinspection UseTomlInstead
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofit_version"]}")
    //noinspection UseTomlInstead
    implementation("com.squareup.okhttp3:okhttp:${rootProject.extra["retrofit_okhttp3_version"]}")
    //noinspection UseTomlInstead
    implementation("com.squareup.okhttp3:logging-interceptor:${rootProject.extra["retrofit_okhttp3_version"]}")

    // Timber
    //noinspection UseTomlInstead
    implementation("com.jakewharton.timber:timber:4.7.1")

//    // Coroutines
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["coroutines_version"]}")
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${rootProject.extra["coroutines_version"]}")
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra["lifecycle_version"]}")
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycle_version"]}")

    // Coil
    //noinspection UseTomlInstead
    implementation("io.coil-kt:coil:1.1.1")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-coil:0.7.0")

    //Dagger - Hilt
    //noinspection UseTomlInstead
    implementation("com.google.dagger:hilt-android:${rootProject.extra["di_hilt"]}")
    kapt("com.google.dagger:hilt-compiler:${rootProject.extra["di_hilt"]}")
    //noinspection UseTomlInstead
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["di_hilt"]}")

    //noinspection UseTomlInstead
//    implementation("com.android.support:palette-v7:28.0.0")
}