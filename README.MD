# IOTBAY web application - Group 15

## Table of contents:
- [Description](#Description)
- [Requirements](#Requirements)
- [Deployment](#Deployment)

## Description:
This web application is based on Model-View-Controller architecture. It uses java server pages, servlets and Derby database.

## Requirements:
- Netbeans IDE
- Java EE 8
- Glassfish server
- Derby database

## Deployment & database:
- Clone the repository from https://github.com/IshaYokh/IoTBay
- Import the project into Netbeans IDE
- Within netbeans, Main side menu navigate to Services -> Databases -> Right-click on Java-DB -> Create Database. The following credentials **must** be used to run the database:
    - **Database name:** iotbay
    - **User name:** iotbay
    - **Password:** iotbay

- To configure the database Within netbeans, go to main side menu -> Files -> src -> sql -> open **DatabaseCreationScript.sql** and run it
- Go to main side menu -> Files -> src -> sql -> open **DatabaseInsertionScript.sql** and run it
- Finally, clean build and run the project


**Note:** If you encounter issues with NetBeans while opening the project, such as **Project Problems. One or more project resources could not be found.......Resolve Project Problems to find the missing resources.** You can resolve this issue by following the below instructions:

- Download the Java Servlet API from this link: https://repo1.maven.org/maven2/javax/servlet/javax.servlet-api/4.0.1/javax.servlet-api-4.0.1.jar
- Move the file to *lib* folder in the project directory
- Within NetBeans, Right-Click on the project in the *Projects* section in the side menu, click on **Resolve Reference Problems** -> **Resolve** and choose the Java Servlet API JAR file that you moved to the **lib** folder

**Note** to avoid issues with running the web app within NetBeans, you must select the web browsers that are not in the With Netbeans Connector section. **Don't choose any of the web browsers in the With Netbeans Connector section**. It will cause issues, and the project won't run.