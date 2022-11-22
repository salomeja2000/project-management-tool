# Project management tool

This project management tool can be used to track ongoing projects. Each project can have a set or tasks, each of which can be individually assigned to a user. In addition, it includes user information for easier communication in the company.

## Requirements
- An IDE of your choice
- H2
- NPM
- Node.JS

## Opening the web application
In order to open the web application, clone this repository to your IDE application.

If you use custom H2 database username and passwordm make sure to change it in the application properties file: `src/main/resources/application.properties`

Then, run it as a Java application from the main server application class:
`src/main/java/com/salomeja2000/projectmanagementtool/ProjectManagementToolApplication.java`

When the server application is running, you can open the Front-end application by navigating to the `src/main/js/projects-frontend/src` folder and run the following command: `src/main/js/projects-frontend/src`

Once the web application is loaded, it will be opened on http://localhost:3000/
