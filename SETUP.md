# Simple setup guide (phone-friendly)

## 1. Upload the project
1. Extract `MutebiIsaacAI-Android-Project.zip`.
2. Keep the folder and file structure unchanged.
3. Upload the folder contents to a private GitHub repository named `MutebiIsaacAI`.

## 2. Build the Android app
The source is a native Kotlin/Jetpack Compose Android project, not an HTML website.
Use Android Studio or a cloud Android Gradle build service.
Build command: `gradle assembleDebug`
Expected APK: `app/build/outputs/apk/debug/app-debug.apk`

If the build service specifically requires `./gradlew`, create a Gradle wrapper using Android Studio or a local Gradle installation and commit `gradlew`, `gradlew.bat`, and `gradle/wrapper/` files.

## 3. Test
Install the debug APK on your Android phone. Test opening Settings, Camera, and a few installed apps. Voice recognition depends on an installed speech recognition service and internet/device language support.

## 4. Important limitations
This is a corrected first build foundation, not the full product described in the specification. The AI server, secure memory, real 3D character, accessibility service, MT5 integration and task automation are separate development phases. Real trading must not be enabled until the broker integration and independent risk controls have been tested thoroughly.
