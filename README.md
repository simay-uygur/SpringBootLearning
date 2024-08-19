# SpringBootLearning
This is a project focusing how spring boot works and learning the elements for a project.

# Coding
- Java 17 
- Spring Boot 
- Spring MVC
- Spring Data 
- Spring REST (http status) 404,403-client 
- Spring Security

## System Login
> Register 
> Login(username+password)
> Authorization(Jwt)

## Lesson Steps
> Spring Framework
> Spring Boot
> Spring MVC
> Spring Data(Jpa Hibernate)
> Spring Rest(Restful ==> Jersey)
> Spring Security 



### Reference Documentation
* [Github](https://github.com/simay-uygur/SpringBootLearning)

```sh 
docker
```

* [H2 console](http://localhost:8080/h2-console/l)
* [Swagger](http://localhost:8080/swagger-ui.html)

## Docker Deployment
```sh
1. STEP 
$   ./mnvw clean package -DskipTests

2. STEP
$   docker compose up  
$   docker ps


########POSTMAN#########
3. STEP
POSTMAN

//adding
http://localhost:8080/docker/v1/create/product

//list
http://localhost:8080/docker/v1/list/product

//find
http://localhost:8080/docker/v1/find/product

//delete 
http://localhost:8080/docker/v1/delete/product

4. STEP
$   docker exec -it spring_docker_postgresqldb_1 psql -U postgres studentdb

5. STEP
$   studentdb=# \dt => showing the tables
$   studentdb=# select * from product
$   studentdb=# \q => for quit

 
     

```