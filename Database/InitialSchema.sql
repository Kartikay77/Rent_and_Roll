CREATE TABLE 
customer (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(50),
contact_no VARCHAR(20),
bill DECIMAL(10,2));

CREATE TABLE 
car_owner (
owner_id INT AUTO_INCREMENT PRIMARY KEY,
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
booking_id INT AUTO_INCREMENT PRIMARY KEY,
rent_time DATETIME,
return_time DATETIME,
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (car_id) REFERENCES car(car_id));

insert into customer values (1,'Kartikay','+918764242882',111.50);
insert into customer values (2,'eesha','+918628676766',170.5);
insert into customer values (3,'eesha','+918628676766',170.50);
insert into customer values (4,'Pranitiee','+918778783789',169.5);
insert into customer values (5,'Rachna','+918778993789',180.5);
insert into customer values (6,'Pranchal','+918778883789',280.5);
insert into customer values (7,'Manish','+9199778993789',380.5);
insert into customer values (8,'Rachna','+918778993789',480.5);
insert into customer values (9,'Aaditriee','+910078993789',580.5);
insert into customer values (10,'Adwait','+918700993789',680.5);

insert into car_owner values (1,'Ram','66667770',880.50);
insert into car_owner values (2,'Hari','55578989',999.50);
insert into car_owner values (3,'Hari','55578989',999.50);
insert into car_owner values (4,'Vivek','57781891',777.5);
insert into car_owner values (5,'Aprajit','66681891',887.5);
insert into car_owner values (6,'karim lala','90981891',789.5);
insert into car_owner values (7,'Haji mastan','77981891',745.5);
insert into car_owner values (8,'pasha','88981891',589.5);
insert into car_owner values (9,'pathaan','956981891',689.5);
insert into car_owner values (10,'Animal','977981891',788.5);

insert into car values (1,'Toyota','Etios','whilte','sedan','small','CA12CP7777','Good',4,80.5,1);
insert into car values (2,'Honda','City','Black','subcompact sedan','big','MA15KL9999','Excellent',5,100.5,2);
insert into car values (3,'Riva','Birla','Red','subcompact sedan','big','MA99KG1111','POOR',5,150.5,4);
insert into car values (4,'Volkswagen','Audi A3,','Blue','Wagon','Huge','MO99EK1111','Bad',8,175.5,5);
insert into car values (5,'Ford F-Series','Ford Mustang','Pink','Convertible','small','SE88DT1310','POOR',2,150.5,6);
insert into car values (6,'General Motors (GM)','Chevrolet Equinox','Orange','Coupe','big','AP97KG1311','POOR',5,250.5,7);
insert into car values (7,'Volkswagen','Audi A3,','Black','Hatchback','small','VG70VG2008','POOR',4,550.5,8);
insert into car values (8,'BMW Group','BMW 5 Series,','Blue','SUV (Sports Utility Vehicle)','big','SG71SG1807','POOR',5,750.5,9);
insert into car values (9,'Mercedes-Benz','Mercedes GLC,','Black','Convertible','big','KL41GU1941','Excellent',2,1000.5,8);
insert into car values (10,'Hyundai Motor Group','Hyundai Elantra','Blue','SUV (Sports Utility Vehicle)','big','DT13DT1807','POOR',5,420.5,9);


insert into booking values (1, '2023-12-01 10:30:00', '2023-12-01 10:30:00',1,1);
insert into booking values (2, '2022-12-01 11:30:00', '2022-12-01 13:45:00',2,2);
insert into booking values (4, '2022-12-01 12:30:00', '2022-12-01 13:45:00',3,3);
insert into booking values (3, '2023-12-01 10:00:00', '2023-12-01 10:30:00',4,4);
insert into booking values (5, '2021-12-01 11:30:00', '2022-11-01 14:45:00',5,5);
insert into booking values (6, '2022-11-01 12:30:00', '2020-12-01 15:45:00',6,6);
insert into booking values (7, '2022-01-01 10:30:00', '2021-08-01 13:45:00',3,3);
insert into booking values (8, '2023-11-01 11:00:00', '2023-09-01 17:30:00',4,4);
insert into booking values (9, '2022-07-01 12:00:00', '2022-03-01 18:45:00',5,5);
insert into booking values (10, '2022-18-01 10:00:00', '2022-04-01 19:45:00',6,6);