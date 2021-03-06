# Objective for Revolut Backend Test

Design and implement a RESTful API (including data model and the backing implementation) for
money transfers between accounts.

### Technologies
- JAX-RS API
- H2 in memory database
- Log4j
- Jetty Container
- Apache HTTP Client


### How to run
```sh

mvn exec:java
```

Application starts a jetty server on localhost port 8080 An H2 in memory database initialized with some sample user and account data To view

- http://localhost:8080/account/1
- http://localhost:8080/account/2
- http://localhost:8080/account/3
- http://localhost:8080/account/4
- http://localhost:8080/account/5
- http://localhost:8080/account/6

- http://localhost:8080/user/pasha
- http://localhost:8080/user/nissan
- http://localhost:8080/user/puertorico 

### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server 
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition
