plugins {
  id("com.google.devtools.ksp") version "2.1.0-1.0.29"
//  kotlin("jvm")
  
  alias(libs.plugins.android.application)
//  alias(libs.plugins.jetbrains.kotlin.android)
  id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
  id("org.jetbrains.kotlin.android") version "2.1.0" apply false

//  id("com.android.library") version "8.8.0" apply false
}

android {
  namespace = "com.example.room_database_template"
  compileSdk = 35
  
  defaultConfig {
    applicationId = "com.example.room_database_template"
    minSdk = 33
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
//  kotlinOptions {
//    jvmTarget = "1.8"
//  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  //ksp
  implementation(kotlin("stdlib-jdk8"))
  implementation(libs.dagger.compiler)
  ksp(libs.dagger.compiler)
  // room
  implementation(libs.androidx.room.runtime)
  annotationProcessor(libs.androidx.room.compiler)
  // nav
  implementation(libs.androidx.navigation.fragment.ktx.v277)
  implementation(libs.androidx.navigation.ui.ktx.v277)
  implementation(libs.androidx.navigation.compose.v277)
  
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
}