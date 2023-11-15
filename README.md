# Pizza Order Management System
## Description
This monorepo contains the complete codebase for the Pizza Order Management System, an end-to-end solution for managing pizza orders. The backend is implemented in Java using Spring Boot, adhering to hexagonal architecture principles for clean and maintainable code. The frontend is built with Next.js and React, leveraging component-based architecture for effective alignment with React and Next.js frameworks. Both parts of the application are fully dockerized, with images hosted on Docker Hub, and deployed on AWS EC2 for robust and scalable performance.
## Features
- Hexagonal Architecture in Backend: Ensures a clean separation of concerns and easy maintainability.
- Component-Based Frontend: Aligns with React and Next.js best practices for scalable and efficient frontend development.
- Dockerization: Both frontend and backend are containerized, ensuring consistent environments across development and production.
- AWS EC2 Deployment: Reliable and scalable hosting of both frontend and backend and the DB on RDS.
- End-to-End Functionality: From order creation to finalization, including email notifications to customers.
## Structure
- backend/  - Contains the Spring Boot application with hexagonal architecture.
- frontend/ - Contains the Next.js and React application.
- Dockerfiles - For building Docker images of both frontend and backend.
- DB - MySQL on RDS AWS
## Getting Started
### Prerequisites
- Docker
- Maven
- Java
- Node
- MySQL

# Accessing Deployed Application
## - Backend API (Swagger Documentation): http://ec2-54-165-43-104.compute-1.amazonaws.com:8080/swagger-ui.html#
## - Frontend Application: http://ec2-54-165-43-104.compute-1.amazonaws.com:3000/

## Docker Hub Repositories
- Backend Image: https://hub.docker.com/repository/docker/felipepineda1997/hays_order_ms/general
- Frontend Image: https://hub.docker.com/repository/docker/felipepineda1997/hays_order_wa/general
