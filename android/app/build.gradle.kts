// This block applies the plugins required for the application module.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Apply the Google Services plugin for Firebase
}

android {
    namespace = "com.example.yourapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yourapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Specifies the instrumentation runner for Android tests.
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // Enables or disables code shrinking, obfuscation, and optimization for the release build.
            isMinifyEnabled = false
            // Specifies the ProGuard rule files.
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Configures Java and Kotlin compiler options.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // Enables build features. ViewBinding is a common one to enable for easier view access.
    buildFeatures {
        viewBinding = true
    }
}

// The dependencies block is where you declare all the libraries your app needs.
dependencies {
    // Core Android libraries
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Firebase - It's recommended to use the Bill of Materials (BoM)
    // The BoM ensures that all your Firebase library versions are compatible.
    val firebaseBomVersion = "33.1.0"
    implementation(platform("com.google.firebase:firebase-bom:$firebaseBomVersion"))

    // Add the dependency for the Firebase SDK for Google Analytics
    // No version number is needed here because of the BoM.
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Add other Firebase dependencies as needed, e.g., auth, firestore, etc.
    // implementation("com.google.firebase:firebase-auth-ktx")
    // implementation("com.google.firebase:firebase-firestore-ktx")

    // Dependencies for local unit tests
    testImplementation("junit:junit:4.13.2")

    // Dependencies for instrumented tests (run on an Android device)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
