import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ktlint)
  alias(libs.plugins.kotlinxSerialization)
}

android {
  namespace = "com.example.post_parser"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.post_parser"
    minSdk = 29
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
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
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation(libs.androidx.lifecycle.runtime)
  implementation(libs.androidx.lifecycle.viewmodel)

  implementation(libs.android.core)
  implementation(libs.androidx.activity.compose)
  debugImplementation(libs.androidx.ui.tooling)
  implementation(libs.androidx.material3)

  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.decompose.core)
  implementation(libs.decompose.extension.compose)

  implementation(libs.ktor.client.core)
  implementation(libs.ktor.client.okhttp)
  implementation(libs.ktor.client.content.negotiation)
  implementation(libs.ktor.serialization)
}

ktlint {
  version = "1.1.1"
  verbose.set(true)
  debug.set(true)
  outputToConsole.set(true)
  reporters {
    reporter(ReporterType.HTML)
    reporter(ReporterType.JSON)
  }
}
