package sai;
import java.util.*;
import java.sql.*;


public class sairam {
	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl", "sai","1234");
			Statement stm=con.createStatement();
			System.out.println("Enter the customer Id");
			int custid=sc.nextInt();
			ResultSet rs=stm.executeQuery("select * from customer64 where custid="+custid+"");
			if(rs.next()) {
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+rs.getLong(4));
			}
			else
				System.out.println("Invalid customer Id");
			con.close();
			sc.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
