# Java Weather REST API Client

A simple Java application that consumes a public REST API and displays weather data in a structured format.

## Features
- Sends HTTP GET requests
- Consumes REST API
- Parses JSON response using Gson
- Displays weather information

## Technologies Used
- Java
- HttpClient
- Gson
- Open-Meteo API

## API Used
https://open-meteo.com/

## How to Run

Compile:
javac -cp ".;gson-2.10.1.jar" WeatherApp.java

Run:
java -cp ".;gson-2.10.1.jar" WeatherApp
