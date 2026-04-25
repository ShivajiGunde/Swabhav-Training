# Student Course Registration System (Java + JDBC)

A console-based Student Registration System built using 
**Core Java, JDBC, and MySQL**.  
It follows a layered architecture using
**DAO + Service + Utility classes** with proper transaction management.

##  Scenario

A training institute manages students enrolling in different courses.

Each student can:
- Register for courses
- Update details
- Cancel registrations

The system ensures:
- No duplicate registrations
- Valid fee handling
- Safe transactional database operations
- Consistent data integrity

## Key Features

-  Transaction Management (Commit / Rollback)
-  No duplicate registrations
-  Input validation (name, age, fee)
-  PreparedStatement (SQL Injection safe)
-  JOIN queries for reports
-  Proper exception handling

---

##  Edge Cases Handled

- Duplicate student ID
- Duplicate course registration
- Invalid/negative fees
- Student not found
- Empty results
- DB transaction failure

- 

## Tech Stack

- Java (Core Java)
- JDBC
- MySQL
- OOP + DAO Pattern

## Project Structure

com.monocept
│
├── model
│ ├── Student
│ ├── Course
│ ├── Branch
│ └── Registration
│
├── dao
│ ├── StudentDao
│ └── RegistrationDao
│
├── exception
│└── StudentNotFoundException
│
├── service
│ ├── StudentService
│ └── RegistrationService
│
├── main
│ ├── StudentRegistrationSystemApp
│ ├── StudentFacade
│ └── StudentManager
│
└── util
└── DBUtil





