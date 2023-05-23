## E-Commerce Microservices with Spring Boot

This project provides an example of an e-commerce system built using microservices architecture. The system consists of three services: product service, order service, and inventory service. Each service is built using Spring Boot and communicates with other services using REST API.

## Technologies

The following technologies are used in this project:
- [x] Spring Boot
- [x] Spring Data JPA
- [x] Spring Data MongoDB
- [x] Spring Security
- [x] Spring Cloud Gateway for API Gateway
- [x] Spring Cloud Sleuth for distributed tracing
- [x] Spring Cloud Config for external configuration
- [x] Spring Cloud Zipkin for distributed tracing
- [x] MySQL for data storage
- [x] MongoDB
- [x] PostgreSQL

- [x] [Jib](https://github.com/GoogleContainerTools/jib) for building container images for your application without needing to write Dockerfiles.

## Monitoring and Observability
- [x] Spring Boot Actuator
- [x] [Grafana](https://grafana.com/) for monitoring and observability.
- [x] [Prometheus](https://prometheus.io/) for monitoring system and time-series database.
- [x] [Micrometer](https://micrometer.io/) for collecting and reporting metrics.

## Integrating Tests
- [x] [Testcontainers](https://www.testcontainers.org/) to write integration tests that use real instances of these components.


## Services

### Product Service

The product service is responsible for managing product information. It provides APIs to create, update, and retrieve product information.

### Order Service

The order service is responsible for managing order information. It provides APIs to create, update, and retrieve order information.

### Inventory Service

The inventory service is responsible for managing inventory information. It provides APIs to update inventory levels when an order is placed or when new products are added to the system. The service also provides APIs to retrieve inventory information for a given product.

### API Gateway

The API Gateway is responsible for routing requests to the appropriate service. It also provides cross-cutting concerns such as authentication and rate limiting.

## Conclusion

This project demonstrates how to build an e-commerce system using microservices architecture. Each service is built using Spring Boot and communicates with other services using REST API. The system is highly scalable, fault-tolerant, and easy to maintain.
