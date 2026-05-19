You are a senior Android engineer.

Generate a complete Android project structure for a “Smart Nutrition Scanner App” using:

- Kotlin
- Jetpack Compose (Material 3)
- MVVM architecture
- Clean Architecture (strict separation)
- StateFlow (NO LiveData)
- Hilt for dependency injection
- Retrofit + OkHttp for networking
- Room database with KSP
- CameraX + ML Kit Barcode Scanning
- Coroutines for async operations

---

## 🧠 Architecture Rules (VERY IMPORTANT)

Follow Clean Architecture strictly:

### 1. DATA LAYER
- remote/
  - api/
  - dto/
- local/
  - db/
  - dao/
  - entity/
- mapper/
- repository implementation

### 2. DOMAIN LAYER
- model/
- repository (interfaces only)
- usecase/ (one class per action)

### 3. PRESENTATION LAYER (FEATURE-BASED)
Organize by feature (NOT by generic MVVM folders):

presentation/
  screen/
    scanner/
      ScannerScreen.kt
      ScannerViewModel.kt
      ScannerState.kt
      ScannerEvent.kt

    product/
      ProductScreen.kt
      ProductViewModel.kt
      ProductState.kt
      ProductEvent.kt

  components/
  navigation/
  theme/

---

### 4. DI LAYER
- Hilt modules:
  - NetworkModule
  - DatabaseModule
  - RepositoryModule

---

### 5. COMMON LAYER
Add reusable utilities:
- Resource sealed class (Loading, Success, Error)
- Constants
- Extensions
- Dispatchers provider

---

## 🧪 STATE MANAGEMENT RULES

- Use StateFlow ONLY
- No LiveData allowed
- UI state must be immutable data class
- Events handled via sealed class (UI Events pattern)

Example:
- ScannerState
- ScannerEvent

---

## 📷 FEATURE REQUIREMENTS

### Scanner Feature:
- Use CameraX
- Scan barcode using ML Kit
- Return barcode value
- Pass to ViewModel
- Fetch nutrition data from API
- Show loading / success / error UI states

---

## 🌐 NETWORK REQUIREMENTS

- Retrofit API service
- OkHttp logging interceptor
- DTO → Domain mapping layer

---

## 🗄 DATABASE REQUIREMENTS

- Room database
- Store scanned products history
- Use DAO + Entity separation

---

## 🎯 OUTPUT FORMAT

Generate:

1. Full folder structure tree
2. Key Kotlin files with:
   - ViewModel (StateFlow)
   - State + Event classes
   - Repository pattern
   - UseCase example
3. Hilt setup modules
4. Minimal example of Scanner screen UI (Compose)

---

## ⚠️ IMPORTANT RULES

- No shortcuts
- No pseudo architecture
- Must follow Clean Architecture strictly
- Must be production-level structure
- Must be scalable for real app