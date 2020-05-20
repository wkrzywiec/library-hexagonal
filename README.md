# Library 
> written in *Hexagonal (Ports & Adapters) Architecture*

![Master Branch](https://github.com/wkrzywiec/library-hexagonal/workflows/Master%20Branch/badge.svg?branch=master) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=wkrzywiec_library-hexagonal&metric=alert_status)](https://sonarcloud.io/dashboard?id=wkrzywiec_library-hexagonal) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=wkrzywiec_library-hexagonal&metric=coverage)](https://sonarcloud.io/dashboard?id=wkrzywiec_library-hexagonal) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a small application that provides basic REST endpoints for managing library (add new book, reserve, borrow it, etc.). 

The technology behind it: 
* Java 11
* Postgres
* Spring Boot 

## Installing / Getting started

#### Using `docker-compose`

In the terminal run the following command:
```console
$ docker-compose up
``` 

#### Using Maven

First make sure that you adjust the configuration file - `src/main/resources/application.yml` with connection details to your database.  

Then, in the terminal run the following command:
```console
$ mvn clean package
$ mvn spring-boot:run
```

#### Inside IntelliJ (with H2 or Postgres database)

First configure how you run the `LibraryHexagonalApplication.java` by adding `--spring.profiles.active=h2` (for H2 database) or `--spring.profiles.active=postgres` (for Postgres database) as a **Program argument**.

Then just run the `LibraryHexagonalApplication.java` class so it will use H2 database (you don't need to have postgres database up and running).

