import java.io.FileInputStream
import java.util.Properties
import com.android.build.api.variant.BuildConfigField

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
}

val apikeyPropertiesFile = rootProject.file("apikey.properties")
val apikeyProperties = Properties()
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))


android {
    namespace = "com.example.movie"
    compileSdk = 35

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.movie"
        minSdk = 21
        this.targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    androidComponents {
        onVariants {
            it.buildConfigFields.put("API_KEY", BuildConfigField("String",  "\"" + apikeyProperties["API_KEY"] + "\"", "build api key"))

            it.buildConfigFields.put("BASE_URL", BuildConfigField(
                "String", "\"" + apikeyProperties["BASE_URL"] + "\"", "build base url"
            ))

            it.buildConfigFields.put("BASE_URL_IMAGE", BuildConfigField(
                "String", "\"" + apikeyProperties["BASE_URL_IMAGE"] + "\"", "build base url image"
            ))
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
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Coil
    implementation(libs.coil.compose)

    //Timber
    implementation(libs.timber)

    //DataStore
    implementation(libs.datastore.preferences)

    // Splashscreen
    implementation(libs.splashscreen)

    //Gson
    implementation(libs.gson)

    // Others - Compose dependencies
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.material.icons.extended)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.navigation.compose)

    // Paging3
    implementation(libs.paging.runtime.ktx)
    implementation(libs.paging.compose)

    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // Coroutine Lifecycle Scopes
    implementation(libs.lifecycle.viewmodel.ktx)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

}

