package Backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
public class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/se","root","heart");  
//here stock is database name, root is username and heart is password  
Statement stmt=con.createStatement(); 
//String sql1 = "insert into customer values (5,'Rachna','+918778993789',180.5)";
//String sql1 = "insert into customer values (6,'Pranchal','+918778883789',280.5)";
//String sql1 = "insert into customer values (7,'Manish','+9199778993789',380.5)";
//String sql1 = "insert into customer values (8,'Rachna','+918778993789',480.5)";
//String sql1 = "insert into customer values (9,'Aaditriee','+910078993789',580.5)";
//String sql1 = "insert into customer values (10,'Adwait','+918700993789',680.5)";
//stmt.executeUpdate(sql1);
//String sql3 = "insert into car_owner values (5,'Aprajit','66681891',887.5)";
//String sql3 = "insert into car_owner values (6,'karim lala','90981891',789.5)";
//String sql3 = "insert into car_owner values (7,'Haji mastan','77981891',745.5)";
//String sql3 = "insert into car_owner values (8,'pasha','88981891',589.5)";
//String sql3 = "insert into car_owner values (9,'pathaan','956981891',689.5)";
//String sql3 = "insert into car_owner values (10,'Animal','977981891',788.5)";
//stmt.executeUpdate(sql3);
String sql2 = "insert into car values (4,'Volkswagen','Audi A3,','Blue','Wagon','Huge','MO99EK1111','Bad',8,175.5,5)";
//String sql2 = "insert into car values (5,'Ford F-Series','Ford Mustang','Pink','Convertible','small','SE88DT1310','POOR',2,150.5,5)";
//String sql2 = "insert into car values (6,'General Motors (GM)','Chevrolet Equinox','Orange','Coupe','big','AP97KG1311','POOR',5,250.5,6)";
//String sql2 = "insert into car values (7,'Volkswagen','Audi A3,','Black','Hatchback','small','VG70VG2008','POOR',4,550.5,7)";
//String sql2 = "insert into car values (8,'BMW Group','BMW 5 Series,','Blue','SUV (Sports Utility Vehicle)','big','SG71SG1807','POOR',5,750.5,5)";
//String sql2 = "insert into car values (9,'Mercedes-Benz','Mercedes GLC,','Black','Convertible','big','KL41GU1941','Excellent',2,1000.5,8)";
//String sql2 = "insert into car values (10,'Hyundai Motor Group','Hyundai Elantra','Blue','SUV (Sports Utility Vehicle)','big','DT13DT1807','POOR',5,420.5,9)";
stmt.executeUpdate(sql2);
String sql4 = "insert into booking values (3, '2023-12-01 10:00:00', '2023-12-01 10:30:00',4,4)";
//String sql4 = "insert into booking values (5, '2021-12-01 11:30:00', '2022-11-01 14:45:00',5,5)";
//String sql4 = "insert into booking values (6, '2022-11-01 12:30:00', '2020-12-01 15:45:00',6,6)";
//String sql4 = "insert into booking values (7, '2022-01-01 10:30:00', '2021-08-01 13:45:00',3,3)";
//String sql4 = "INSERT INTO booking VALUES (8, '2023-01-11 11:00:00', '2023-01-09 17:30:00', 7, 7)";
//String sql4 = "insert into booking values (9, '2022-07-01 12:00:00', '2022-03-01 18:45:00',5,5)";
//String sql4 = "INSERT INTO booking VALUES (10, '2022-01-18 10:00:00', '2022-04-01 19:45:00', 6, 6)";
stmt.executeUpdate(sql4);
ResultSet rs=stmt.executeQuery("select * from customer"); 
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  