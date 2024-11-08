package sai;

import java.sql.*;

public class sairam {
	public static void main(String[] args) {
		//System.out.println("sairam");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from customer64");
			while(rs.next()) {
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			ResultSet r=stm.executeQuery("select * from employee64");
			while(r.next()) {
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5)+"\t"+r.getLong(6));
			}
			
			
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
