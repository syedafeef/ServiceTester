# Service Test

Description
This project provides a set of utilities for:

- Validating URL links
- Testing browser speed and stop after 20MB
- Sending SMS and showing its state
- Making calls using Android Intent

## Features
- Send SMS and Show Its State
- Displays the status of the sent SMS (e.g., sent, delivered, failed).

- Browser Speed Test using YouTube as the default site, with the maximum data allowed being 20 MB.

- URL Link Validation
- Validates whether a given URL is properly formatted and reachable.

- Call Using Android Intent
- Opens the default phone dialer with the specified phone number.

This Android application demonstrates how to use Retrofit and Hilt for Dependency Injection to check the reachability of a list of URLs. The application 4 functions Send SMS, Data usage/Speed Test and URL validation(displays a list of URLs, and upon clicking the "Verify URLs" button, it shows a check mark (✔) or a cross mark (✘) in front of each URL based on its reachability.)


## Pending items
- making the app the default dialer, it's not possible without getting the application signed from different OEM's due to the requirement of signature|privileged permissions such as [BIND_TELECOM_CONNECTION_SERVICE](https://developer.android.com/reference/android/Manifest.permission#BIND_TELECOM_CONNECTION_SERVICE) and [ANSWER_PHONE_CALLS](https://developer.android.com/reference/android/Manifest.permission#ANSWER_PHONE_CALLS)


## Technologies Used

- **Kotlin**: Programming language used for the Android application.
- **Retrofit**: A type-safe HTTP client for Android and Java.
- **Hilt**: Dependency Injection library for Android.
- **RecyclerView**: To display the list of URLs.
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.

## Getting Started

### Prerequisites

- Android Studio installed on your machine.
- Basic knowledge of Android development and Kotlin.
