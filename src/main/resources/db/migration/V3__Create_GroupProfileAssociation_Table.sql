-- V3__Create_GroupProfileAssociation_Table.sql
CREATE TABLE GroupProfileAssociation (
    GROUP_ID INT NOT NULL,
    USER_ID INT NOT NULL,
    PRIMARY KEY (GROUP_ID, USER_ID)
);

-- Documentação das chaves estrangeiras
-- FOREIGN KEY (GROUP_ID) REFERENCES CyclistGroup(ID);
-- FOREIGN KEY (USER_ID) REFERENCES Profile(USER_ID);