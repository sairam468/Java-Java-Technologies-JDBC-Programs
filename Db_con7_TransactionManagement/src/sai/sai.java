package sai;

import java.sql.*;
import java.util.Scanner;

public class sai {
	public static void main(String[] args) { 
		Scanner sc=new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //optional as next step automatically loads the driver
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");

			System.out.println("Status of Auto-commit : "+c.getAutoCommit());
			c.setAutoCommit(false);
			System.out.println("Status of Auto-commit : "+c.getAutoCommit());

			PreparedStatement ps1=c.prepareStatement("select * from bank64 where accno=?");
			PreparedStatement ps2=c.prepareStatement("update bank64 set balance =balance+? where accno=?");

			Savepoint sv=c.setSavepoint();			
			System.out.println("Enter the Home Account Number : ");
			long hAccNo=sc.nextLong();
			ps1.setLong(1, hAccNo);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				double hAccBal=rs1.getDouble(3);
				System.out.println("Enter beneficary Account Number :");
				long bAccNo=sc.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2=ps1.executeQuery();
				if(rs2.next()) {
					System.out.println("Enter the Amount :");
					long Amt=sc.nextLong();
					if(Amt<=hAccBal) {
						ps2.setLong(1, -Amt);
						ps2.setLong(2, hAccNo);
						int i=ps2.executeUpdate();

						ps2.setLong(1, Amt);
						ps2.setLong(2, bAccNo);
						int j=ps2.executeUpdate();

						if(i==1 && j==1) {
							System.out.println("Your Transaction Sucessful :) ...");
							c.commit();
						}
						else {
							System.out.println("Youe Transaction failed :( ...");
							c.rollback(sv);
						}
					}
				}
				else {
					System.out.println("Invalid BAccNo .....");
				}
			}
			else {
				System.out.println("Invalid HAccNo .....");
			}

			c.close();
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
