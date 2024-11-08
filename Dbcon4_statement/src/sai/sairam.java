package sai;

import java.util.Scanner;
import java.sql.*;


public class sairam {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai", "1234");
			Statement s=c.createStatement();

			while(true) {
				System.out.println("***Choice***");
				System.out.println("1.AddEmployee\r\n"
						+ "2.ViewAllEmployees\r\n"
						+ "3.ViewEmployeeById\r\n"
						+ "4.Exit");
				System.out.println("Enter choice : ");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Enter the EID : ");
					int eId=(sc.nextInt());
					System.out.println("Enter the EName : ");
					String eName=sc.next();
					System.out.println("Enter the EDESG : ");
					String eDesg=sc.next();
					System.out.println("Enter the BSAL : ");
					int bSal=Integer.parseInt(sc.next());
					int k=s.executeUpdate("insert into employee64 (eid,ename,edesg,bsal) values("+eId+",'"+eName+"','"+eDesg+"','"+bSal+"')");
					System.out.println("k value is : "+k);
					if(k>0) {
						System.out.println("Employee Added Sucessfully");
					}
					break;
				case 2:
					ResultSet r=s.executeQuery("select * from employee64");
					while(r.next()) {
						System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5)+"\t"+r.getLong(6)+"\t"+r.getLong(7));
					}
					break;
				case 3:
					System.out.println("Enter the employee Id");
					int empid=sc.nextInt();
					ResultSet rs=s.executeQuery("select * from employee64 where eid="+empid+"");
					if(rs.next()) {
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getLong(5)+"\t"+rs.getLong(6)+"\t"+rs.getLong(7));
					}
					else
						System.out.println("Invalid customer Id");
					break;
				case 4:
					System.out.println("End of Operation ...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice...");
				}
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
