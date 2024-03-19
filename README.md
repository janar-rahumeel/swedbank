## Application Setup (default database is H2) ##

Deploy PostgreSQL container

> make deploy-postgres

a) Run Spring Boot application with "postgres" profile inside IntelliJ

or

b) Build an image and run as container
>make build-jar
> 
>make build-image
> 
>make deploy-swedbank