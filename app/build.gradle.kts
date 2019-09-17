plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.0"
    defaultConfig {
        applicationId = "com.purnaprasanth.recipes"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.41")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.2")

    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")

    implementation("com.squareup.moshi:moshi:1.8.0")
    implementation("com.facebook.stetho:stetho-okhttp3:1.5.1")

    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("android.arch.paging:runtime:1.0.1")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
