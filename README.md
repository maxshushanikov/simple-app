# Каталог приложений

Учебное Android-приложение на Jetpack Compose, которое показывает подборку популярных приложений в виде прокручиваемого каталога. Для каждой позиции отображаются иконка, название, краткое описание и категория.

## Возможности

- список из восьми приложений с локально заданными данными;
- карточки с иконками, описаниями и категориями;
- интерфейс на Jetpack Compose и Material 3;
- светлая и тёмная темы с автоматическим выбором по системным настройкам;
- адаптация списка к прокрутке и отображение количества приложений.

## Технологии

- Kotlin 2.2.10
- Jetpack Compose и Material 3
- Android Gradle Plugin 9.4.1
- Gradle 9.6.0 через Gradle Wrapper
- `minSdk`: 24
- `compileSdk` и `targetSdk`: 37

## Запуск

1. Установите Android Studio и Android SDK Platform 37.
2. Откройте корневую папку проекта в Android Studio и дождитесь завершения синхронизации Gradle.
3. Выберите конфигурацию запуска `app`, подключите Android-устройство или запустите эмулятор и нажмите **Run**.

Для сборки и запуска локальных unit-тестов из PowerShell используйте Gradle Wrapper:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:testDebugUnitTest
```

Для запуска инструментальных тестов на подключённом устройстве или эмуляторе:

```powershell
.\gradlew.bat :app:connectedDebugAndroidTest
```

## Структура проекта

```text
app/src/main/
├── java/org/simpleapp/
│   ├── MainActivity.kt
│   ├── data/
│   │   └── AppCatalogRepository.kt
│   ├── model/
│   │   └── AppInfo.kt
│   └── ui/
│       ├── AppCatalogScreen.kt
│       ├── components/
│       └── theme/
└── res/
    ├── drawable/
    └── values/
```

- `data/AppCatalogRepository.kt` содержит элементы каталога.
- `model/AppInfo.kt` определяет модель приложения и ссылки на ресурсы.
- `ui/` содержит экран каталога, его компоненты и тему оформления.
- `res/` содержит строки, цвета, размеры и изображения.

## Тесты

Unit-тесты находятся в `app/src/test`, инструментальные — в `app/src/androidTest`. Для проверки локальных тестов выполните `.\gradlew.bat :app:testDebugUnitTest`.
