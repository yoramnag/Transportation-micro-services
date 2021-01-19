# Transportation-micro-services

this project is using Spring Boot, Spring Data JPA, devtools and MySQL.
ths project simulate transportation company , that have , drivers, vehicles, events and trainings.
driver can have many vehicles and trainings , vehicle can have many events.

to run this project you need:
1. Java IDE 
2. MySQL 
3. postman

steps to run the project:
1. you need to import the project to your workbacnch and click maven -> update project 
2. run MySQL and copy Transportation_company.sql to sql tab and run the script, this will crate all the tables that you need for the project.
3. run postman , import the transportationCompany-Spring-data-REST2.postman_collection.json, this will to run rest calls to the microserver.
