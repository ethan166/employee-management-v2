CREATE TABLE Address(
   AddressId  INT(11) NOT NULL Primary Key,
   StreetName VARCHAR(255) NOT NULL,
   City VARCHAR(255) NOT NULL,
   Pincode VARCHAR(255) NULL   
);
CREATE TABLE Employee(
   EmpId INT(11) NOT NULL Primary Key,
   EmployeeName VARCHAR(255) NOT NULL,
   Department VARCHAR(255) NOT NULL,
   Age INT(11) NOT NULL,
   Gender VARCHAR(255) NOT NULL,
   StartDate VARCHAR(255) NOT NULL,
   EndDate VARCHAR(255) NULL
   Salary INT(11) NOT NULL,
   Address INT(11) null,
   CONSTRAINT Emp_FK Foreign key (Address) REFERENCES Address(AddressId)
);