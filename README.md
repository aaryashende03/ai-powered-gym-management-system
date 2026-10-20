# 🏋️ AI-Powered Gym Management System

A web-based Gym Management System built using **Java, Spring Boot, MySQL, Thymeleaf, HTML, and CSS** to simplify gym operations, manage members, track attendance, and handle memberships through a centralized dashboard.

## 📌 Project Overview

The AI-Powered Gym Management System helps gym administrators manage daily activities efficiently. It provides REST APIs for core gym operations, a dashboard for viewing gym statistics, and an integrated rule-based chatbot that responds to common gym-related queries.

## ✨ Features

- **Dashboard:** View gym statistics, including total members, trainers, memberships, and attendance.
- **Member Management:** Perform CRUD operations to add, view, update, and delete member records.
- **Trainer Management:** Manage trainer information and records.
- **Membership Management:** Maintain membership details, plans, dates, and status.
- **Attendance Tracking:** Record and manage member attendance.
- **Interactive Chatbot:** Answer common gym-related questions and provide supported membership and attendance information.
- **REST APIs:** Enable structured communication with backend services.
- **Database Integration:** Persist application data using MySQL.
- **Responsive Styling:** Organize the dashboard using HTML and CSS.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Application development |
| Spring Data JPA / Hibernate | Database access and ORM |
| MySQL | Relational database |
| Thymeleaf | Server-side HTML rendering |
| HTML5 | Page structure |
| CSS3 | Styling and layout |
| Maven | Dependency management and build |
| REST APIs | Backend operations |

## 🏗️ Project Architecture

The project follows a layered architecture:

- **Controller Layer:** Handles HTTP requests and REST endpoints.
- **Service Layer:** Contains business logic.
- **Repository Layer:** Communicates with the database.
- **Entity Layer:** Represents database entities.
- **DTO Layer:** Structures request and response data.
- **View Layer:** Displays the dashboard and chatbot interface using Thymeleaf, HTML, and CSS.

## 📂 Project Structure

```text
ai-powered-gym-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/gym_management/
│   │   │   ├── chatbot/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── static/css/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Pr
