
CREATE TABLE User (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    LOGIN VARCHAR(35) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) UNIQUE NOT NULL,
    ROLE VARCHAR(20) NOT NULL
);

CREATE TABLE Profile(
    USER_ID INT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    USERNAME VARCHAR(255),
    CATEGORY VARCHAR(35) NOT NULL,
    USER_TYPE VARCHAR(35) NOT NULL,
    LOCALITY VARCHAR(35) NOT NULL,
    SEX CHAR(1) NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES User(ID)
);

