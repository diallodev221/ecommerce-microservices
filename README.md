## E-Commerce Microservices with Spring Boot

This project provides an example of an e-commerce system built using microservices architecture. The system consists of three services: product service, order service, and inventory service. Each service is built using Spring Boot and communicates with other services using REST API.

## Technologies

The following technologies are used in this project:

- Spring Boot
- Spring Data JPA
- Spring Cloud Netflix Eureka for service discovery
- Spring Cloud Gateway for API Gateway
- Spring Cloud Config for external configuration
- Spring Cloud Sleuth for distributed tracing
- Spring Cloud Zipkin for distributed tracing
- MySQL for data storage

## Dependencies

This project uses the following additional dependencies:

### Jib

[Jib](https://github.com/GoogleContainerTools/jib) is a container image builder for Java applications. It allows you to build container images for your application without needing to write Dockerfiles. Jib can be used to build images for deployment to Kubernetes, Docker, or any other container platform.

### Grafana

[Grafana](https://grafana.com/) is an open-source platform for monitoring and observability. It provides a powerful dashboarding engine and supports a wide range of data sources, including Prometheus.

### Prometheus

[Prometheus](https://prometheus.io/) is an open-source monitoring system and time-series database. It is designed for monitoring and alerting and provides a powerful query language for analyzing time-series data.

### Testcontainers

[Testcontainers](https://www.testcontainers.org/) is a Java library that provides lightweight, throwaway instances of common databases, Selenium web browsers, or anything else that can run in a Docker container. Testcontainers makes it easy to write integration tests that use real instances of these components.

## Monitoring and Observability

To enable monitoring and observability in the system, the following components are used:

### Spring Boot Actuator

Spring Boot Actuator is a set of APIs that provide operational information about the application. It includes metrics, health checks, and other useful information.

### Micrometer

[Micrometer](https://micrometer.io/) is a metrics collection library that supports multiple monitoring systems. It provides a simple API for collecting and reporting metrics.

### Prometheus Metrics

The Spring Boot Actuator and Micrometer provide support for exposing metrics in a format that can be scraped by Prometheus.

### Grafana Dashboards

Grafana provides a powerful dashboarding engine that can be used to create custom dashboards for monitoring and observability. The project includes sample dashboards for monitoring the system.

## Services

### Product Service

The product service is responsible for managing product information. It provides APIs to create, update, and retrieve product information. The service also provides APIs to search for products based on different criteria such as name, category, and price.

### Order Service

The order service is responsible for managing order information. It provides APIs to create, update, and retrieve order information. The service also provides APIs to search for orders based on different criteria such as customer name, order date, and order status.

### Inventory Service

The inventory service is responsible for managing inventory information. It provides APIs to update inventory levels when an order is placed or when new products are added to the system. The service also provides APIs to retrieve inventory information for a given product.

### API Gateway

The API Gateway is responsible for routing requests to the appropriate service. It also provides cross-cutting concerns such as authentication and rate limiting.

## Conclusion

This project demonstrates how to build an e-commerce system using microservices architecture. Each service is built using Spring Boot and communicates with other services using REST API. The system is highly scalable, fault-tolerant, and easy to maintain.