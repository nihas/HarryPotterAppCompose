[![kotlin](https://img.shields.io/github/languages/top/bikcodeh/ToDoApp.svg?style=for-the-badge&color=blueviolet)](https://kotlinlang.org/) [![Android API](https://img.shields.io/badge/api-24%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=23) [![Build status](https://build.appcenter.ms/v0.1/apps/86493375-a9cd-491f-a2b3-43176506e6d2/branches/main/badge)](https://appcenter.ms)

# HarryPotterApp
An Android app built with Jetpack Compose and the latest android libraries.
This app uses Clean Code architecture, Dagger Hilt for dependency injection, and Retrofit to fetch datas from the [HarryPotter API](https://hp-api.onrender.com/).

### Requirements to install the app
- Having an internet connection
- Using phones with Android Api 24+

## Features

- **Clean Code Architecture:** Ensures separation of concerns and makes the codebase more maintainable.
- **Kotlin:** Leverages the modern language features to write concise and expressive code.
- **Jetpack Components:** Uses components like Flow, ViewModel.
- **Dependency Injection:** Utilizes Dagger Hilt to manage dependencies.
- **Retrofit:** Simplifies HTTP requests to the HarryPotter API.

##### This application was developed using Kotlin and uses the following components:
- Jetpack compose
- Coroutines
- Clean architecture (Domain, Data, UI)
- MVVM
- Repository pattern
- StateFlow
- Navigation component by compose
- Dagger Hilt (Dependency injection)
- Retrofit

## :dart: Architecture

The application is built using Clean Architeture pattern based on [Architecture Components](https://developer.android.com/jetpack/guide#recommended-app-arch) on Android. The application is divided into three layers:

![Clean Arquitecture](https://devexperto.com/wp-content/uploads/2018/10/clean-architecture-own-layers.png)

- Domain: This layer contains the business logic of the application, here we define the data models and the use cases.
- Data: This layer contains the data layer of the application. It contains the database, network and the repository implementation.
- UI: This layer contains the presentation layer of the application like fragment, activity, viewmodel etc.


**Nihas Nizar**