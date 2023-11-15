# Hays Order Management System
## Description
This project is an advanced Order Management System developed for Hays as a part of a technical evaluation. It's built using Spring Boot and follows a hexagonal architecture, ensuring clean separation of concerns and making it easily scalable and maintainable. The application is designed to be state-of-the-art, leveraging the latest in Java development practices.

## Features
- Hexagonal Architecture: Ensures flexibility and portability by separating the core logic from external concerns.
- Spring Boot Framework: Simplifies the bootstrapping and development of new Spring applications. 
- Scalability: Easily scalable to handle increased loads and demands. 
- Docker Integration: Containerized for easy deployment and consistent runtime environments.

## Prerequisites
- Java 17 
- Maven 
- Docker (for containerization)
- RDS in AWS

## Getting Started
### Local Setup
1. Clone the repository
2. Build the project using Maven: `mvn clean install`
3. Run the application: `java -jar target/hays_order_ms-0.0.1-SNAPSHOT.jar`

### Running with Docker
1. Build the Docker image: `docker build -t felipepineds1997/hays_order_ms .`
2. Run the Docker container: `docker run -d -p 8080:8080 --restart always felipepineds1997/hays_order_ms`

### Docker Hub
The application's Docker image is also available on Docker Hub. You can pull and run the image.

### Usage
After starting the application, you can access the REST API endpoints at ``http://{host}:8080`` and doc in ``http://{host}:8080/swagger-ui.html#/``.
