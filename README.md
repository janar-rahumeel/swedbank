### 1.a Application Setup (database is H2) ###

Run Spring Boot application inside IntelliJ (or inside preferable IDE)

### 1.b Application Setup (database is Postgresql) ###

Deploy PostgreSQL container

> make deploy-postgres

a) Run Spring Boot application with "postgres" profile inside IntelliJ (or inside preferable IDE)

or

b) Build an image and run as container
>make build-jar
> 
>make build-image
> 
>make deploy-swedbank