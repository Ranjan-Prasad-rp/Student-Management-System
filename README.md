# 🎓 Student Management System

A **Spring Boot 3 REST API** that provides CRUD operations for managing students, secured with **Spring Security (role-based access using SecurityFilterChain)**.  

---

## ✨ Features  
- ✅ **Role-based authentication with Spring Security** (`ROLE_USER`, `ROLE_ADMIN`)  
- ✅ **Student CRUD Operations**  
  - Get all students  
  - Get student by ID  
  - Add new student  
  - Update student  
  - Delete student  
- ✅ **Custom SecurityFilterChain** (no JWT yet — planned for future)  
- ✅ **MySQL & H2 database support**  


---

## ⚙️ Tech Stack  
- **Java 17**  
- **Spring Boot 3.5.4**  
- **Spring Security (role-based access)**  
- **Spring Data JPA (Hibernate)**  
- **MySQL**  
- **Maven**  

---

## 🚀 Getting Started  

### Prerequisites  
- Java 17  
- Maven 3+  
- MySQL 8+  

### Clone & Run  
```bash
git clone https://github.com/your-username/student-management-api.git
cd student-management-api
mvn spring-boot:run
```

Runs at:  
```
http://localhost:8080
```

---

## 📦 Dependencies (from `pom.xml`)  
- `spring-boot-starter-web` → REST APIs  
- `spring-boot-starter-security` → Role-based authentication  
- `spring-boot-starter-data-jpa` → ORM (Hibernate)  
- `mysql-connector-j` → MySQL driver  
- `MySQl` →  database for testing  
- `lombok` → Boilerplate reduction  

---

## 📡 API Endpoints  

| Method | Endpoint                  | Role Required | Description                  |
|--------|---------------------------|---------------|------------------------------|
| GET    | `/student/getAllStudents` | USER/ADMIN    | Get all students             |
| GET    | `/student/getStudentById/{id}` | USER/ADMIN | Get student by ID            |
| POST   | `/student/addStudent`     | ADMIN         | Add new student              |
| PUT    | `/student/updateStudent/{id}` | ADMIN      | Update student completely    |
| PATCH  | `/student/updateField/{id}` | ADMIN        | Update student partially     |
| DELETE | `/student/deleteStudent/{id}` | ADMIN      | Delete student               |

---

## 🔐 Security Overview  
- Configured using **Spring SecurityFilterChain**  
- **Role-based access control**:  
  - `ROLE_USER` → can view students  
  - `ROLE_ADMIN` → can add, update, delete students  
- Currently **no JWT** — planned for next iteration.  

---

## 🛠 Example Request  

### Get All Students  
```bash
curl -u user:password http://localhost:8080/student/getAllStudents
```

### Add Student (Admin Only)  
```bash
curl -X POST http://localhost:8080/student/addStudent -u admin:password -H "Content-Type: application/json" -d '{"name":"John Doe","age":22,"course":"CS"}'
```

---

## 📜 License  
This project is licensed under the MIT License.


## passwords are stored in hash form
<img width="621" height="143" alt="db table" src="https://github.com/user-attachments/assets/0ac3f6d8-4a33-4699-8db6-0fba79af28ad" />

## Postman API testing:
<img width="1906" height="952" alt="postman getAll" src="https://github.com/user-attachments/assets/2082e11e-c34b-4701-a39f-d9d4df2b43ba" />




