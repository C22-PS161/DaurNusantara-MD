# DaurNusantara-MD

## Plugin
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'com.google.gms.google-services'
    id 'kotlin-parcelize'
    id 'kotlin-kapt'
    
## Dependencies
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.4.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.4.2'
    implementation 'com.google.firebase:firebase-auth-ktx:21.0.5'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.github.bumptech.glide:glide:4.13.1'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"
    implementation 'com.google.firebase:firebase-auth'
    implementation platform('com.google.firebase:firebase-bom:30.1.0')
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"
    implementation 'androidx.datastore:datastore-preferences:1.0.0'
    
## Permission
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-feature android:name="android.hardware.camera" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="18" />
    
## Status
Project is : in progress
