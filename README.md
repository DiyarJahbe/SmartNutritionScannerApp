# 🥗 Smart Nutrition Scanner App

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green?style=for-the-badge&logo=android"/>
  <img src="https://img.shields.io/badge/Kotlin-100%25-purple?style=for-the-badge&logo=kotlin"/>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Architecture-Clean%20Architecture-orange?style=for-the-badge"/>
</p>

<p align="center">
  📱 Smart Android application that scans food product barcodes and displays detailed nutrition information in real-time.
</p>

---

# ✨ Features

✅ Barcode scanning using CameraX + ML Kit  
✅ Real-time nutrition information retrieval  
✅ Modern Material 3 UI with Jetpack Compose  
✅ Local scan history using Room Database  
✅ MVVM + Clean Architecture  
✅ Dependency Injection with Hilt  
✅ REST API integration using Retrofit & OkHttp  
✅ Reactive state management with Coroutines + StateFlow

---

# 📸 Screenshots

> Add your screenshots here later

| Home Screen | Scanner | Nutrition Details |
| ----------- | ------- | ----------------- |
| 📷          | 📷      | 📷                |

---

# 🛠 Tech Stack

## 🔹 Language

- Kotlin

## 🔹 UI

- Jetpack Compose
- Material 3

## 🔹 Architecture

- MVVM (Model-View-ViewModel)
- Clean Architecture

## 🔹 Dependency Injection

- Hilt

## 🔹 Networking

- Retrofit
- OkHttp

## 🔹 Database

- Room Database (KSP)

## 🔹 Barcode Scanning

- CameraX
- Google ML Kit

## 🔹 Asynchronous Programming

- Kotlin Coroutines
- StateFlow

---

# 📂 Project Structure

```bash
SmartNutritionScannerApp/
│
├── app/
│   ├── data/
│   ├── domain/
│   ├── presentation/
│   ├── di/
│   └── ui/
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

# 🚀 Getting Started

## Prerequisites

Make sure you have:

- Android Studio Hedgehog or newer
- JDK 17+
- Android SDK installed
- Gradle installed (optional)

---

# ⚙️ Installation

## 1️⃣ Clone Repository

```bash
git clone https://github.com/DiyarJahbe/SmartNutritionScannerApp.git
```

## 2️⃣ Open Project

Open the project in Android Studio.

## 3️⃣ Sync Gradle

Let Android Studio download all required dependencies.

## 4️⃣ Run Application

Run the app on:

- Android Emulator
- Physical Android Device

---

# 🔐 Required Permissions

The app uses:

```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.INTERNET"/>
```

---

# 🧪 Build APK

## Debug Build

```bash
./gradlew assembleDebug
```

Windows:

```bash
gradlew.bat assembleDebug
```

---

# 📦 Install Debug APK

```bash
./gradlew installDebug
```

---

# 🧠 Architecture Overview

The application follows **Clean Architecture** principles:

- **Presentation Layer** → UI & ViewModels
- **Domain Layer** → Business Logic
- **Data Layer** → APIs, Database, Repositories

This improves:

- Scalability
- Maintainability
- Testability
- Code organization

---

# 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch

```bash
git checkout -b feature/YourFeature
```

3. Commit your changes

```bash
git commit -m "Add new feature"
```

4. Push branch

```bash
git push origin feature/YourFeature
```

5. Open Pull Request

---

# 📌 Future Improvements

- AI-based food recommendations
- Dark mode support
- Offline nutrition cache
- User authentication
- Firebase analytics
- Multi-language support

---

# 👨‍💻 Developer

**Diyar Jahbe**

- Android Developer
- Kotlin & Jetpack Compose Enthusiast

GitHub:
https://github.com/DiyarJahbe

---

# ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub!

---
