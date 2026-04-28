# 🛒 E-Commerce Microservices Backend

## 📌 Overview
This project is a microservices-based backend system built using Spring Boot. It demonstrates secure, scalable service-to-service communication using JWT authentication, service discovery, and Docker-based deployment.
---

## 🏗️ Architecture
Client → Order Service → (optional) User Service
        ↓
     Service Discovery (Eureka)
* Each service is independently deployed and registered with Eureka.
* Services communicate using logical service names instead of hardcoded URLs.
---
## ⚙️ Tech Stack
* Java 17
* Spring Boot
* Spring Security (JWT)
* Service Discovery: Netflix Eureka
* REST APIs (RestTemplate with Load Balancing)
* MySQL
* Docker & Docker Compose
---

## 🔐 Authentication Flow
1. User registers or logs in via User Service
2. JWT token is generated and returned to client
3. Client sends JWT in Authorization header:
   Authorization: Bearer <token>
4. Each service validates JWT independently using a security filter
5. User identity is extracted from token and used for processing
---

## 📦 Services

### 👤 User Service
* Register user
* Login and generate JWT
* Provide user data (if required by other services)

### 📦 Order Service
* Create and manage orders
* Secured using JWT
* Extracts user identity from token
* Calls User Service only when additional user data is needed
---

## 🔁 Service Communication
* Uses service discovery via Netflix Eureka
* No hardcoded URLs
* Example:
  http://USER-SERVICE/api/...
* Load-balanced RestTemplate is used for inter-service calls
---
## 🐳 Docker Setup
All services are containerized and orchestrated using Docker Compose.
### Run the application:

```bash
mvn clean package
docker-compose up --build
```

### Services:
* Eureka Server → http://localhost:8761
* User Service → http://localhost:9001
* Order Service → http://localhost:9002
---

## 🔍 Key Features
* Stateless authentication using JWT
* Role-based authorization (if implemented)
* Service discovery using Eureka
* Inter-service communication without hardcoded endpoints
* Containerized microservices architecture
---

## 🎯 Learning Outcomes
* Implemented secure authentication across microservices
* Understood service discovery and dynamic routing
* Built and deployed containerized backend system
* Designed scalable and loosely coupled architecture
---

## 📌 How to Test
1. Register/Login → get JWT
2. Use token to call Order APIs
3. Verify secure access and order creation
---

## 👨‍💻 Author
Raviteja Tinga
