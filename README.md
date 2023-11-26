TP TAA sur JaxRS fait par Alexandre CHAPLAIS et Tilio EBOR

## JaxRS + openAPI

## How to install and Use it
1. Import this project in your IDE, 
2. Start the database [run-hsqldb-server.sh](run-hsqldb-server.sh)
3. Start the database viewer [show-hsqldb.sh](show-hsqldb.sh) (optionnal to access to the tables and request throw hsqldb)
Change the type by HSQL DATABASE Engine Server.
4. Start the backend. [RestServer.java] 

The api description is available at [http://localhost:8080/openapi.json]

You can send request through postman by creating a collection,
add a request and choose between put, post, get according to available requests
with the corresponding request and can need a body structure in raw with the right json.

## To change the api

The api is created with the structure of users who are professionnels or clients,
and can create a RDV usually for the client to see the professionnels. (Made for Doctors but can be use for other field)

Entity represents the data model of the application.
DAO provides methods to interact with the database and perform CRUD operations on entities.
DTO is used to transfer data between the client and server, and mappers help in converting data between entities and DTOs.
Resource REST is the endpoint in the API that clients interact with. It handles HTTP requests and often utilizes DAOs and DTOs in the process.

It is possible that the Data folder need to be deleted if there are table changes 
Or that it is needed a Maven build manually
And after that to run the API with the step 2 and 4. 3 if you want.

### Integrate Swagger UI.

The server can access to http://localhost:8080/api/, a swagger ui instance that should provide documentation on the api but is empty at the moment. 

This guide show how to specialise the documentation through annotations:

https://github.com/swagger-api/swagger-samples/blob/2.0/java/java-resteasy-appclasses/src/main/java/io/swagger/sample/resource/PetResource.java
