use mangueira_jdbc;

CREATE TABLE department (
  Id int NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE professor (
  Id int NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  CPF int NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computer Engeneering'),
  ('Civil Engeneering'),
  ('Eletrical Engeneering'),
  ('Math');

INSERT INTO professor (Name, Email, BirthDate, CPF, BaseSalary, DepartmentId) VALUES 
  ('Sergio','sergio@gmail.com','1974-04-21 00:00:00',222333, 1000,1),
  ('Maria','maria@gmail.com','1979-12-31 00:00:00',111222, 3500,2),
  ('Davi','davi@gmail.com','1988-01-15 00:00:00', 555666, 2200,1),
  ('Marcos','marcos@gmail.com','1993-11-30 00:00:00',999888, 3000,4),
  ('Joana','joana@gmail.com','2000-01-09 00:00:00',444777, 4000,3),
  ('Nilton','nilton@gmail.com','1978-04-17 00:00:00',333555, 3000,2);
  
   SHOW TABLES;