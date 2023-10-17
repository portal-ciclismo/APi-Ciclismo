-- V1_Create_Bike_Table.sql
CREATE TABLE bike(
    BIKE_ID INT PRIMARY KEY,
    FRAMEBRAND VARCHAR(30) NOT NULL,
    FRAMEMATERIAL VARCHAR(30) NOT NULL,
    WHEELSIZE INTEGER  (2) NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES  Profile(USER_ID)
);