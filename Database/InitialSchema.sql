CREATE TABLE 
customer (
customer_id INT PRIMARY KEY,
customer_name VARCHAR(50),
contact_no VARCHAR(20),
bill DECIMAL(10,2));

CREATE TABLE 
car_owner (
owner_id INT PRIMARY KEY,
owner_name VARCHAR(50),
contact_no VARCHAR(20),
balance DECIMAL(10,2));

CREATE TABLE 
car (
car_id INT PRIMARY KEY,
maker VARCHAR(50),
car_name VARCHAR(50),
color VARCHAR(50),
car_type VARCHAR(50),
model VARCHAR(50),
reg_no VARCHAR(50),
condition VARCHAR(100),
seating_capacity INT,
rent_per_hour DECIMAL(10,2)
FOREIGN KEY (owner_id) REFERENCES car_owner(owner_id));

CREATE TABLE 
booking (
booking_id INT PRIMARY KEY,
rent_time DATETIME,
return_time DATETIME,
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (car_id) REFERENCES car(car_id));