-- V1__Create_User_Table.sql
CREATE TABLE User (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PASSWORD VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) UNIQUE NOT NULL
);


