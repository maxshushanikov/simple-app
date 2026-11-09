# Каталог приложений

Учебное Android-приложение на Jetpack Compose, которое показывает подборку популярных приложений в виде прокручиваемого каталога. Для каждой позиции отображаются иконка, название, краткое описание и категория.

## Возможности

- список из девяти приложений с данными, вынесенными в локальный источник данных;
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

1. Установить Android Studio и Android SDK Platform 37.
2. Открыть корневую папку проекта в Android Studio и дождаться завершения синхронизации Gradle.
3. Выбрать конфигурацию запуска `app`, подключить Android-устройство или запустите эмулятор и нажмите **Run**.

Для сборки и запуска локальных unit-тестов из PowerShell использовать Gradle Wrapper:

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
│   ├── AppContainer.kt
│   ├── data/
│   │   ├── mapper/
│   │   ├── model/
│   │   ├── repository/
│   │   └── source/
│   ├── domain/
│   │   ├── model/
│   │   └── repository/
│   └── presentation/
│       ├── AppCatalogScreen.kt
│       ├── catalog/
│       ├── appdetails/
│       ├── components/
│       ├── resources/
│       └── theme/
└── res/
    ├── drawable/
    └── values/
```

- `data/source/` содержит локальные DTO с данными каталога, а `data/mapper/` преобразует их в Domain-модели.
- `data/repository/` реализует контракт репозитория из `domain/repository/`.
- `domain/model/` содержит модели приложения и ключи иконок без зависимости от Android.
- `presentation/` содержит Compose-экраны, ViewModel, компоненты и отображение ресурсов.
- `res/` содержит строки, цвета, размеры и изображения.

## Тесты

Unit-тесты находятся в `app/src/test`, инструментальные — в `app/src/androidTest`. Для проверки локальных тестов выполнить `.\gradlew.bat :app:testDebugUnitTest`.