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

