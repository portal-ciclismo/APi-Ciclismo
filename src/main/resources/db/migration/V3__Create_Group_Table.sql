-- V2__Create_Group_Table.sql
CREATE TABLE CyclistGroup (

    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    LOCATION VARCHAR(35) NOT NULL,
    PRIVACY BOOLEAN NOT NULL

);