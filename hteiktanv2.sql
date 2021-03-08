CREATE TABLE address(
   address_id  INT(11) NOT NULL Primary Key,
   city VARCHAR(255) NOT NULL,
   city VARCHAR(255) NOT NUL,
   pincode VARCHAR(255) NULL   
);
CREATE TABLE employee(
   emp_id INT(11) NOT NULL Primary Key,
   employee_name VARCHAR(255) NOT NULL,
   age INT(11) NOT NULL,
   gender VARCHAR(255) NOT NULL,
   department VARCHAR(255) NOT NULL,
   address INT(11) null,
   start_date DATE NOT NULL,
   end_date DATE null,
   successMessage
   CONSTRAINT Emp_FK Foreign key (address) REFERENCES address(address_id)
);