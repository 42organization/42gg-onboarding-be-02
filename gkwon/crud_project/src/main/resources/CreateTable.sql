drop table if exists CRUD;

CREATE TABLE CRUD (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      title VARCHAR(255) NOT NULL,
                      content TEXT NOT NULL
);