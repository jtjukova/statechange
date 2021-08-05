#Employee DEMO
Demo of Simple CRUD application for editing Employees

Build the application first!!
mvn clean install

# Run the application
* mvn package && java -jar target/statechange-0.0.1-SNAPSHOT.jar
* Open http://localhost:9000

##Run application with docker
* Build docker image locally: docker build -t state-demo .
* Run container: docker run -p 9000:9000 state-demo

##Run application with docker-compose
* Run docker-compose up
* Open http://localhost:9000

#H2 Database console
Access H2:
URL: http://localhost:9000/console

#CRUD employee
##Create an employee

POST http://localhost:9000/employee 
'{
"name": "Name",
"surname": "Surname",
"email": "test@test.de"
}'

##Edit an employee
PATCH http://localhost:9000/employee/1
'{
"state": "IN_CHECK"
}'

##List all employees
GET http://localhost:9000/employee

##Delete an employee
DELETE http://localhost:9000/employee/1









