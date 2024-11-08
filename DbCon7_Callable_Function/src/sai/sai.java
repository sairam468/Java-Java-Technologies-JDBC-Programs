package sai;

import java.util.Scanner;
import java.sql.*;

public class sai {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {

			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");

			CallableStatement cs=c.prepareCall("{call ?:=retrieve_stuphno(?)}");

			// Get user input for the parameters
			System.out.print("Enter rollno: ");
			int rollno = scanner.nextInt();

			// Set the input parameters
			cs.registerOutParameter(1, Types.BIGINT);
			cs.setInt(2, rollno);

			// Execute the callable statement
			cs.execute();
			
			System.out.println("Student rollno : "+rollno);
			System.out.println("Student Phone Number : "+cs.getLong(1));

			// Close the resources
			cs.close();
			c.close();
			scanner.close();


			System.out.println("Procedure executed successfully!");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

