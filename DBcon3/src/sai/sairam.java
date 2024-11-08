package sai;
import java.util.*;
import java.sql.*;


public class sairam {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the CUSTId");
				int cusid=s.nextInt();
				System.out.println("Enter the CUSNMAE");
				String cusname=s.next();
				System.out.println("Enter the CUSSAL");
				long cussal=s.nextLong();
				System.out.println("Enter the CUSDEPT");
				int cusdept=s.nextInt();

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");
				Statement stm=c.createStatement();
				int k=stm.executeUpdate("insert into customer64 values ("+cusid+",'"+cusname+"',"+cussal+",'"+cusdept+"')");
				System.out.println("Value in k : "+k);
				if(k>0) {
					System.out.println("Customer added Successfully...");
				}
				c.close();
			}
			catch(SQLIntegrityConstraintViolationException ob)
			{
				System.out.println("Customer details already available....");
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}


}
