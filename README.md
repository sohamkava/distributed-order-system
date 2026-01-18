Distributed Order Management System (Spring Boot + Docker)

A microservices-based distributed system built using Spring Boot, REST APIs, H2 database, and Docker, demonstrating real-world service-to-service communication between Order Service and Inventory Service

🚀 Project Overview

This project simulates a real e-commerce backend where:
An Order Service places orders
An Inventory Service manages stock
Orders are confirmed only if sufficient inventory is available
Services communicate over HTTP
Entire system runs using Docker Compose

🏗 Architecture

Client
  |
  v
Order Service (8081)  --->  Inventory Service (8083)
       |                         |
     H2 DB                    H2 DB

🧠 Key Features

✅ Microservices architecture

✅ RESTful APIs using Spring Boot

✅ Inter-service communication (WebClient)

✅ Custom exception handling

✅ In-memory H2 databases

✅ Docker & Docker Compose support

✅ Clean layered architecture (Controller, Service, Repository)

✅ Production-style logging & configuration

🛠 Tech Stack

Java 17

Spring Boot 3.5

Spring Data JPA

Spring Web

H2 Database

Docker & Docker Compose

Maven

IntelliJ IDEA

⚙️ How It Works

1️⃣ Inventory Service

Manages product stock

Exposes endpoint to check availability


2️⃣ Order Service

Receives order requests

Calls Inventory Service

Confirms or rejects orders based on stock


🔌 API Endpoints

📦 Inventory Service (8083)

Method	Endpoint	Description

GET	/inventory/check	Check if product is in stock

Example:

GET /inventory/check?productId=P101&quantity=2


🛒 Order Service (8081)

Method	Endpoint	Description

POST	/api/orders	Create an order

GET	/api/orders/{id}	Get order by ID

Example:

POST /api/orders?productId=P101&quantity=2


🐳 Running with Docker (Recommended)

Step 1: Build & Run

docker compose up --build


Step 2: Access Services

Order Service → http://localhost:8081

Inventory Service → http://localhost:8083


🗄 H2 Database Console

Note: H2 is internal to containers.

Inventory DB:

jdbc:h2:mem:inventorydb


Order DB:

jdbc:h2:mem:ordersdb


❗ Error Handling

Custom OutOfStockException

Global exception handler

Clean JSON error responses


Example:


{
  "timestamp": "2026-01-18T12:27:40",
  "error": "Product out of stock"
}

📈 What This Project Demonstrates

Real microservice communication

Dockerized Spring Boot services

Clean code structure

🧑‍💻 Author

Soham Kava

Backend / Java Developer

⭐ Future Enhancements

Swagger API documentation

MySQL / PostgreSQL integration

Service discovery (Eureka)

API Gateway

Circuit breaker (Resilience4j)


Authentication (JWT)
