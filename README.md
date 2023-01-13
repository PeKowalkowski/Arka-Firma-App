ArkaFirmaApp
===
This is an application to help my friend at work,
Who is the manager of a metalworking company.
The application is a service for managing employees and projects.
Each registered employee gets a role depending to the position at work.
The role authorizes an employee to add details
of the project so that the admin can keep up to date
with the progress of the work.

Database properties (MySql Workbench) : 

spring.datasource.url= database path

spring.datasource.username= database username

spring.datasource.password= database password

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG

logging.level.org.hibernate.type=TRACE

spring.main.allow-circular-references=true

server.error.whitelabel.enabled=false

## Entities :
1. Registration

2. Users

3. MainProject

4. Logistican

5. Technologist

6. Supplier

7. Production

## Endpoints :
### 1. http://localhost:8080/ 
#### The start page of the application, with login bar for registered users. Below that is a button redirecting to the registration page.
![logowanie](https://user-images.githubusercontent.com/61734661/212404433-addcb37e-1f9e-4199-9002-801d4303cc98.png)
### 2. http://localhost:8080/registration
#### User registration page. Enter your first name and last name, as well as a login and password, which will used as login data. The login is unique for each user.
![rejestracja](https://user-images.githubusercontent.com/61734661/212404477-aa57e1ec-bfde-42fd-8246-12ed7d6e03a1.png)
### 3. http://localhost:8080/ (ONLY FOR LOGGED USERS) 
#### The main page of the application containing a table with employee data and sub-pages of projects. Access to sub-pages depends on the role of the user. Admin has access to each of them.
![Strona główna](https://user-images.githubusercontent.com/61734661/212404523-a7ed4251-e111-442b-a564-32aec39b84a2.png)
### 4. http://localhost:8080/user/userId
#### A page with employee details and a field for deleting and editing an employee. This page is accessed by going to the "Details" tab.
![Szczegóły pracownika](https://user-images.githubusercontent.com/61734661/212404551-5fb2c1d5-e3b8-4f88-b924-089a6d779117.png)
### 5. http://localhost:8080/showFormForUpdate/userId
#### Page for editing employee data. Only a user with the Admin role has access to this page.
![Edytuj pracownika](https://user-images.githubusercontent.com/61734661/212404605-2fe50899-11fd-494c-80d2-97b9380225f8.png)
### 6. http://localhost:8080/showLogisticanProjectIndex
#### A page with a table of projects, which can be accessed by admin and users with the logistics role. The page has a field for adding, editing and deleting a project.
![logistyk](https://user-images.githubusercontent.com/61734661/212404638-7d14dbad-1f5d-4b97-a4e3-299883f8ebfc.png)
### 7. http://localhost:8080/showNewLogisticanProjectForm
#### The page for adding a new project. The button for this page is located in the middle at the top of the project table page.
![nowy projekt logistyka](https://user-images.githubusercontent.com/61734661/212404670-65dc4da1-2b0a-461f-91f3-462df25c1f1a.png)
### 8. http://localhost:8080/showFormForUpdateLogisticanProject/projectId
#### The page for editing a project. The button for this page is on the right side of each project in the table.
![edycja projektu](https://user-images.githubusercontent.com/61734661/212404725-0b8e2e82-3f8c-4e5d-bed4-bd87479f9fe0.png)
### 9.The rest of the subpages (Production, Supplier and Technologist) work similarly to the example presented earlier.
