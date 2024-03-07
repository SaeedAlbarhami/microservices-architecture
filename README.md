# Microservices Architecture
Microservice architecture using spring boot, eureka, external config server

## Overview

This repository showcases a robust implementation of microservices architecture using Spring Boot, Eureka, and an external config server. It serves as a comprehensive reference for developers eager to dive into the development and deployment of microservices, featuring a variety of services such as an API gateway, booking service, car rental app, and more, complemented by Kubernetes deployment scripts.

## Why Microservices?

Adopting a microservices architecture facilitates:

- **Scalability**: Independent scalability of components for better load adaptation.
- **Flexibility**: Utilization of diverse technologies and languages tailored to each service.
- **Resilience**: Enhanced system stability through isolated service failures.
- **Faster Deployments**: Accelerated development cycle via smaller, independently deployable codebases.
- **Focused Teams**: Increased productivity through teams focused on specific services.

## Features

- **Service Discovery**: Leverages Eureka for dynamic discovery, enhancing fault tolerance and load balancing.
- **Config Management**: Utilizes an external config server for centralized configuration management.
- **API Gateway**: Provides a unified entry point for client requests, routing them to the appropriate microservice.
- **Microservices**: Includes booking, car rental, customer, and car services among others.
- **Monitoring**: Incorporates comprehensive monitoring for health and performance.
- **Deployment**: Offers Kubernetes configurations for efficient cloud deployment.

## The 12-Factor App Methodology

This repository adheres to the [12-Factor App](https://12factor.net/), a set of practices for building applications that are optimized for modern cloud platforms. These principles facilitate:

- **Declarative Setup**: Using declarative formats for setup automation to ease the onboarding of new developers.
- **Clean Contract with the OS**: Ensuring maximum portability between execution environments.
- **Suitability for Cloud Deployment**: Designed for modern cloud platforms, eliminating the need for traditional servers and systems administration.
- **Continuous Deployment**: Minimizing divergence between development and production for agility.
- **Scalability**: Allowing applications to scale up seamlessly without significant changes to tooling, architecture, or practices.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Docker
- Kubernetes

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/SaeedAlbarhami/microservices-architecture.git
   ```
2. Build the project:
   ```
   mvn clean install
   ```
3. For local setup, run Docker Compose:
   ```
   docker-compose up
   ```

### Deployment

Refer to the `k8s` directory for detailed Kubernetes deployment steps.

## Usage

Illustrative examples on utilizing the deployed services and interacting with the API gateway will be provided here, detailing relevant endpoints and operations.

## Contributing

Your contributions make our community vibrant. For major changes, please initiate a discussion via an issue. Ensure that your pull requests adhere to our guidelines.

## License

This project is distributed under the MIT License. For more details, see the `LICENSE` file.

