#  Task Manager

A simple task management REST API built with **Spring Boot**, **Spring Data JPA**, and **H2 in-memory database**.

This application allows users to perform basic operations on tasks such as **create**, **read**, **update**, and **delete** (CRUD) via HTTP requests. 

##  Features

- Add new tasks
- Get a list of all tasks
- Get a task by ID
- Update an existing task
- Delete a task
- In-memory H2 database (no setup required)
- RESTful API ready to be tested with Postman

##  Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Gradle

##  How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/AlicjaCi/Task-Application.git
   cd task-manager
2. Build and run:

    ```bash
    ./mvnw spring-boot:run
    
3. The application will be available at:
http://localhost:8080



##  API Endpoints



GET	/api/tasks	Get all tasks

GET	/api/tasks/{id}	Get task by ID

POST	/api/tasks	Create a new task

PUT	/api/tasks/{id}	Update a task

DELETE	/api/tasks/{id}	Delete a task


##  Example JSON


{

  "title": "Buy groceries",
  
  "description": "Milk, bread, eggs",
  
  "completed": false
  
}


##  Author

Alicja Cichocka
Automation Tester in training 
📧 alicjacichocka27[TaskManager_TestCases_EN.md](https://github.com/user-attachments/files/21671381/TaskManager_TestCases_EN.md)
@gmail.com

Feel free to contribute, give feedback, or fork the project ⭐
[TaskManager_Postman_Collection.json](https://github.com/user-attachments/files/21670817/TaskManager_Postman_Collection.json)

