# Expense Tracker App

A full-stack web application to track and manage daily expenses. Built using **Spring Boot (Java)** on the backend with **REST APIs**, and a simple **HTML/JavaScript frontend** for submitting and viewing expenses in real-time.

## Features

- Add and view expenses with category, amount, and date.
- Dynamic table to display all submitted expenses.
- Expense summary by period: daily, weekly, monthly.
- Alerts for overspending based on category thresholds.
- "Clear All" button to delete all stored expenses.
- Lightweight H2 in-memory database for quick testing.

## Tech Stack

- **Backend**: Java 17, Spring Boot, Spring Data JPA, REST API
- **Database**: H2 (in-memory)
- **Frontend**: HTML, CSS, JavaScript (vanilla)
- **Build Tool**: Maven

## Deployment

To run locally with hot reload and testing:

```bash
# Build and start the app
mvn clean install
mvn spring-boot:run
