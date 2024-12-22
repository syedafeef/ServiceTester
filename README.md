# Service Test

Description
This project provides a set of utilities for:

- Validating URL links
- Testing browser speed
- Sending SMS and showing its state
- Making calls using Android Intent

## Features
- URL Link Validation
- Validates whether a given URL is properly formatted and reachable.
- Checks for common URL issues such as invalid syntax or unreachable domains.
- Browser Speed Test
- Send SMS and Show Its State
- Displays the status of the sent SMS (e.g., sent, delivered, failed).
- Call Using Android Intent
-Opens the default phone dialer with the specified phone number.

This Android application demonstrates how to use Retrofit and Hilt for Dependency Injection to check the reachability of a list of URLs. The application displays a list of URLs, and upon clicking the "Verify URLs" button, it shows a check mark (✔) or a cross mark (✘) in front of each URL based on its reachability.

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
