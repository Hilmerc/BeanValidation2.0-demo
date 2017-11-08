# BeanValidation2.0-demo - https://MedellinJUG.org

## validation-demo

This is a demo project used for the talk [EE4J: Bean Validation 2.0](http://www.asuoc.org.co/odt-tour-2017.html) presented at in Oracle Developer Tout Latinoamerica 2017  - Medellin Colombia . It shows how to use Bean Validation 2.0 with Java Server Faces.


### Building the project

Execute the following command to build the project:

    mvn clean package

### Running the application on an embed application server

Execute the following command to run the application through cargo plugin and Apache Tomcat:

    mvn cargo:run
    
### Accessing the application    

Go to the following URL to access the application

    http://127.0.0.1:8080/validation-demo/