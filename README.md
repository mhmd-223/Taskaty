# Taskaty App

Taskaty is a task management application designed to help you stay organized, manage your tasks, and make the most of your time. This README file provides instructions on how to run the Taskaty app on your system.

## Prerequisites

Before running the Taskaty app, please ensure that you have the following prerequisites installed on your system:

- Java JDK 17 or higher
- MySQL server installed

## Setup

To set up the Taskaty app, follow these steps:

1. Create a database called 'taskaty' using the provided schema file 'schema.sql'. You can import this file into your MySQL server to create the necessary database structure.

2. Edit the 'application.properties' file located in the app's installation directory. Update the `username` and `password` fields with the appropriate credentials for your MySQL server.

## Running the App

To run the Taskaty app, you have two options:

1. Run the Taskaty.exe file: Double-click on the Taskaty.exe file to launch the application. This executable file is provided for convenience and should automatically start the app.

2. Run the Taskaty.jar file using the terminal: If you encounter any issues running the Taskaty.exe file, you can run the Taskaty.jar file directly from the terminal. Open a terminal or command prompt, navigate to the directory containing the Taskaty.jar file, and run the following command:
   ```
   java -jar path/to/Taskaty.jar
   ```
   Replace `path/to/Taskaty.jar` with the actual path to the Taskaty.jar file on your system.
