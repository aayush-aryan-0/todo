@echo off
:: This silences the native access warnings and runs the app
java --enable-native-access=ALL-UNNAMED -jar target/demo-1.0-SNAPSHOT.jar
pause