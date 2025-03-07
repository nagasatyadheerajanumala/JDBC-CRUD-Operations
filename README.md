# Student Management System - CRUD Operations

## Description

This project implements a **Student Management System** that performs CRUD (Create, Read, Update, Delete) operations on a MySQL database using **JDBC**. The system allows users to add, view, update, and delete student records. The student records include information such as `name`, `email`, and `date_of_birth`.

## Features

- **Create**: Add new students to the database.
- **Read**: View details of a specific student or all students in the database.
- **Update**: Modify the details of an existing student.
- **Delete**: Remove a student from the database.

## Requirements

- Java Development Kit (JDK) 8 or later
- MySQL Database
- JDBC driver for MySQL
- A MySQL database named `Student_manage` with a `student` table containing the following columns:
    - `id` (Primary Key, Auto Increment)
    - `name` (VARCHAR)
    - `email` (VARCHAR)
    - `date_of_birth` (DATE)

## Setup and Installation

### 1. Clone the repository

```bash
git clone https://github.com/nagasatyadheeraj/student-management-system.git
cd JDBC-CRUD-Operation
```

# Set up the MySQL Database
## 1. Log in to MySQL:
```mysql -u root -p```

