# Smart Nutrition Scanner App

Smart Nutrition Scanner App is a sample Android application that scans product barcodes and shows nutrition information.

## Overview

The app is built with Kotlin and Jetpack Compose and uses CameraX + ML Kit to read barcodes. It follows Clean Architecture (MVVM), uses Hilt for DI, Retrofit/OkHttp for networking, Room (KSP) for local persistence, and Kotlin Coroutines + StateFlow for state management.

## Key Features

- CameraX + ML Kit barcode scanning
- Fetch nutrition data via Retrofit + OkHttp
- Local history with Room (KSP)
- Hilt dependency injection
- Jetpack Compose (Material 3) UI
- Clean Architecture (domain, data, presentation)

## Tech Stack

- Kotlin
- Jetpack Compose (Material 3)
- Hilt (DI)
- Retrofit + OkHttp
- Room (KSP)
- CameraX + ML Kit Barcode Scanning
- Coroutines + StateFlow

## Project ID

- ApplicationId / Namespace: `com.example.smartnutritionscannerapp`

## Quickstart (Developers)

Prerequisites:

- Android Studio (recommended) or Gradle
- JDK 17+
- Android SDK matching `compileSdk` (see `app/build.gradle.kts`)

Open in Android Studio:

1. Open the project directory in Android Studio.
2. Let Gradle sync and download dependencies.
3. Run on an emulator or device (grant camera permission when prompted).

Command-line build (using Gradle wrapper):

```bash
./gradlew assembleDebug
# On Windows
gradlew.bat assembleDebug
```

Install on connected device:

```bash
./gradlew installDebug
```

## Permissions

The app requires:

- `android.permission.CAMERA` — for barcode scanning
- `android.permission.INTERNET` — to fetch nutrition data

These are declared in `app/src/main/AndroidManifest.xml`.

## Project Structure (high level)

- `app/` — Android application module
  - `src/main/` — app sources, manifests, resources
- `build.gradle.kts`, `settings.gradle.kts` — Gradle build files
- `plan.md` — original architecture & requirements notes

This project follows the Clean Architecture recommendations laid out in `plan.md` (domain, data, presentation, DI, common layers).

## How To Contribute

1. Fork the repository.
2. Create a feature branch: `git checkout -b feat/your-feature`.
3. Make changes and add tests where appropriate.
4. Open a pull request describing the change.

## License

Add a license file (e.g., `LICENSE`) to this repository. If you want, I can add an `MIT` license for you.

---

If you'd like, I can now initialize git, create a GitHub repo for you and push this project. Tell me whether you want me to create the remote repo or if you already have one.
