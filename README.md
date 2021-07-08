# Simple Paging

[![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Gradle Version](https://img.shields.io/badge/gradle-6.7.1-green.svg)](https://docs.gradle.org/current/release-notes)

📰 A Sample Paging App implement with movie API written in Kotlin using Android Architecture Components, MVVM, etc.

# Instruction

## Gradle

### Project Gradle
```
buildscript {
    ext{
        kotlin_version = "1.5.10"
        core_version = "1.5.0"
        appcompact_version = "1.3.0"
        material_version = "1.3.0"
        constraint_version = "2.0.4"
        retrofit_version = "2.9.0"
        glide_version = "4.12.0"
        lifecycle_extensions_version = "2.2.0"
        activity_version = "1.2.3"
        ktx_version = "2.4.0-alpha02"
        paging_version = "3.1.0-alpha02"
        junit_version = "4.+"
        ext_junit_version = "1.1.3"
        espresso_version = "3.4.0"
        hilt_version = "2.35"
        dagger_version = "2.37"
        nav_version = '2.3.5'
        gson_version = '2.8.7'
        legacy_version = '1.0.0'
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.2.2"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { url 'https://www.jitpack.io' }
    }
}
```

### Module Gradle
```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-parcelize' //change from kotlin-android-extensions
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
    id 'androidx.navigation.safeargs.kotlin'
}

android {
    buildFeatures {
        viewBinding true
    }
}

..........

dependencies {

    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "androidx.core:core-ktx:$core_version"
    implementation "androidx.appcompat:appcompat:$appcompact_version"
    implementation "com.google.android.material:material:$material_version"
    implementation "androidx.legacy:legacy-support-v4:$legacy_version"
    implementation "androidx.constraintlayout:constraintlayout:$constraint_version"

    // Activity KTX
    implementation("androidx.activity:activity-ktx:$activity_version")

    //retrofit and converter gson
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

    //Gson
    implementation "com.google.code.gson:gson:$gson_version"

    //glide
    implementation "com.github.bumptech.glide:glide:$glide_version"

    //Viewmodel
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_extensions_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$ktx_version"

    //paging 3
    implementation "androidx.paging:paging-runtime:$paging_version"

    //Navigation component Kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    //hilt
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

    //dagger
    implementation "com.google.dagger:dagger:$dagger_version"
    kapt "com.google.dagger:dagger-compiler:$dagger_version"

    testImplementation "junit:junit:$junit_version"
    androidTestImplementation "androidx.test.ext:junit:$ext_junit_version"
    androidTestImplementation "androidx.test.espresso:espresso-core:$espresso_version"
}
```

## Notes

### Features
---
- Movie list with paging 3.
- Movie detail.

### Application Architecture
---
- IDE: Android Studio
- Arthitecture: MVVM
- Programming Language: Kotlin
- Third Party Libraries: Paging 3 , Hilt, Dagger, Navigation Component, Glide, Gson, etc...

# Demo App

<table style="width:100%">
  <tr>
    <th>Example 1</th>
    <th>Example 2</th>
  </tr>
  <tr>
    <td><img src="screenshot/home.jpg"/></td>
    <td><img src="screenshot/detail.jpg"/></td>
  </tr>
</table>

# License

```
    Copyright (C) Dino Priyano

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
