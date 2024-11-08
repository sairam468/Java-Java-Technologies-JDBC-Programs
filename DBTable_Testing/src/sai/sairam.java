package sai;

import java.sql.*;

public class sairam {
	public static void main(String[] args) throws SQLException {
		//System.out.println("sairam");
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
//			Statement stm=con.createStatement();
//			ResultSet rs=stm.executeQuery("select * from emp where job in('javadev','tester','devopseng')");
//			while(rs.next()) {
//				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
//			}
////			ResultSet r=stm.executeQuery("select * from employee64");
////			while(r.next()) {
////				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5)+"\t"+r.getLong(6));
////			}
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
			try {
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
	            // Corrected SQL query with closing parenthesis and single quotes
	            ps = con.prepareStatement("SELECT * FROM emp WHERE job IN ('javadev', 'tester', 'deveopseng')");
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                // Use "\t" for tab space instead of "/t"
	                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getLong(4) + "\t" + rs.getInt(5) + "\t");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources in finally block
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (con != null) con.close();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
			
			
			con.close();
		}
		
	}


	
