# Mutebi Isaac AI – The House (Android starter)

Owner: Mutebi Isaac  
Package: `com.mutebi.isaacai`

This is a cleaned native Android/Kotlin + Jetpack Compose starter based on the code supplied in the chat.

## What currently works in this starter
- Black-and-gold Compose interface with the top workspace, chat panel and living-room panel.
- Text input and Android speech-recognition intent (English Uganda locale requested; actual recognition depends on the phone's speech service).
- Android Text-to-Speech using the device's selected English voice.
- Lists launchable apps visible to Android and launches a selected real app in its own Android activity.
- Opens Android Settings and the camera using Android intents.
- Basic animated floating emoji character (not a 3D model).

## What is NOT implemented yet
- No connected online AI brain in the Android app yet.
- No persistent long-term memory or database.
- No true 3D character, facial animation or speech lip-sync.
- No accessibility UI automation service.
- No screen capture / screen reading.
- No WhatsApp message sending.
- No MT5 market-data or order connection. No demo or live trading.
- No autonomous background task engine.

Do not treat this starter as a completed autonomous assistant or a trading system. It cannot place trades.

## Build
Use JDK 17 and Android SDK Platform 35. Open this folder in Android Studio and let Gradle sync, then run:
`gradle assembleDebug`

APK output:
`app/build/outputs/apk/debug/app-debug.apk`

If using a cloud CI service, connect this repository and configure the Android build command as `gradle assembleDebug`, with artifact path `app/build/outputs/apk/debug/app-debug.apk`. A CI provider may require a Gradle wrapper; if so, generate/commit the wrapper from Android Studio (`gradle wrapper`) before running the cloud build.

## Before publishing
- Add a proper launcher icon and privacy policy.
- Add runtime permission handling and user-facing explanations for microphone/camera features.
- Test on the actual target phone.
- Do not put an OpenAI API key in the Android app. Keep it on a secure HTTPS backend.
