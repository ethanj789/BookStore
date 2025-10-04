#  Book Store Web App

A Java web application built with **JSP**, **Servlets**, and **JDBC** to manage books in a MySQL database.  
Users can view, add, update, and delete books through a clean web interface.

---

## Features

- View all books in a table format  
- Add a new book (title, author, price)  
- Edit existing book details  
- Delete a book with confirmation  
- Database persistence using **MySQL** and **connection pooling**  

---

## Tech Stack

| Layer | Technology |
|-------|-------------|
| Frontend | JSP, HTML, JSTL |
| Backend | Java Servlets |
| Database | MySQL |
| Server | Apache Tomcat |
| JDBC Management | `javax.sql.DataSource` (connection pooling) |

---

## Setup
1. setup database
2. Run the following SQL commands in MySQL:

```sql
CREATE DATABASE book_store;
USE book_store;

CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(100),
  author VARCHAR(100),
  price DOUBLE,
  PRIMARY KEY (id)
);
```
3. set up database connection
   - create context.xml and fill in the username and password for your database
   - there is a context.example.xml template
4. run by deploying to Tomcat from your IDE
