# microservices

## Proyecto Microservicios

# Base de datos
- Instalar Mysql y Mysql WorkBench
- Importar bases de datos en workbench, greeting_service.sql y user_service.sql
    - workbench -> server -> data import -> import from self-cotained file
- Las tablas ya tienen almacenados algunos datos de prueba

# Spring Boot
- importar en Spring Tool Suite los 2 microservicios, greeting_service y user_service
    File -> open project from file system -> buscar proyectos en directorio
- modificar el archivo application.properties
    - spring.datasource.username= nombre-usuario-mysql
    - spring.datasource.password= contraseña-servidor-mysql

El microservicio greeting_service tiene el puerto 8081
El microservicio user_service tiene el puerto 8080

# Postman 
  - importar en postman -> file -> import microservice.postman_collection.json

