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

## ⚙️ Prerequisites

Before running the project, install:

- Java (a version compatible with the project's `pom.xml`)
- MySQL Server
- Maven, if not using the included Maven Wrapper
- An IDE such as Spring Tool Suite (STS) or IntelliJ IDEA

## 🚀 Installation and Setup

### 1. Clone the repository

```bash
git clone https://github.com/aaryashende03/ai-powered-gym-management-system.git
```

### 2. Open the project

Open the cloned folder in Spring Tool Suite or your preferred Java IDE as an existing Maven project.

### 3. Create the MySQL database

Run the following SQL command in MySQL:

```sql
CREATE DATABASE gym_management2;
```

### 4. Configure database credentials

Configure your local database connection in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gym_management2
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

Set `DB_USERNAME` and `DB_PASSWORD` to your local MySQL credentials before starting the application. Keep real credentials out of GitHub.

### 5. Run the application

From the project directory on Windows, run:

```cmd
mvnw.cmd spring-boot:run
```

Alternatively, run the main Spring Boot application class from your IDE.

### 6. Open the dashboard

Visit:

```text
http://localhost:8080/
```

The application should display the gym dashboard when the database connection and application startup are successful.

## 🔗 REST API Endpoints

The following endpoint groups are implemented in the project:

| Module | Base Endpoint | Operations |
|---|---|---|
| Members | `/members` | Create, read, update, delete |
| Trainers | `/trainers` | Manage trainer records |
| Memberships | `/memberships` | Manage membership records |
| Attendance | `/attendance` | Manage attendance records |

Use a REST client such as Postman to test the endpoints. The exact HTTP methods and request fields depend on each controller implementation.

## 🤖 Chatbot

The integrated rule-based chatbot supports gym-related queries, including common questions and supported membership or attendance information. Its responses are generated using Java application logic rather than an external generative AI API.

## 🎯 Learning Outcomes

- Developed REST APIs using Java and Spring Boot.
- Implemented CRUD operations for multiple modules.
- Integrated MySQL using Spring Data JPA and Hibernate.
- Used DTOs to structure API requests and responses.
- Built a server-rendered dashboard using Thymeleaf, HTML, and CSS.
- Implemented rule-based chatbot functionality.
- Practiced Git and GitHub version control.

## 🔮 Future Enhancements

- Role-based authentication and authorization.
- Improved chatbot natural-language understanding.
- Dashboard charts and attendance analytics.
- Membership expiry notifications.
- Automated testing and deployment.

## 👩‍💻 Author

**Aarya Shende**

- GitHub: [@aaryashende03](https://github.com/aaryashende03)

## 📄 License

This project is available for educational and portfolio purposes. Add a license file if you intend to distribute it under a specific open-source license.
