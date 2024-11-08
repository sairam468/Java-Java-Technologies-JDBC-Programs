package sai;

import java.util.Scanner;
import java.sql.*;

public class sai {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
        	
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");
		
		CallableStatement cs=c.prepareCall("{call insertstudetails64(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
        // Get user input for the parameters
        System.out.print("Enter rollno: ");
        int rollno = Integer.parseInt(scanner.next());
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter branch: ");
        String branch = scanner.next();
        System.out.print("Enter city: ");
        String city = scanner.next();
        System.out.print("Enter state: ");
        String state = scanner.next();
        System.out.print("Enter pincode: ");
        int pincode = Integer.parseInt(scanner.next());
        System.out.print("Enter mailid: ");
        String mailid = scanner.next();
        System.out.print("Enter phno: ");
        long phno = Long.parseLong(scanner.next());
        System.out.print("Enter English marks: ");
        int english = Integer.parseInt(scanner.next());
        System.out.print("Enter Telugu marks: ");
        int telugu = Integer.parseInt(scanner.next());
        System.out.print("Enter Hindi marks: ");
        int hindi = Integer.parseInt(scanner.next());
        System.out.print("Enter Maths marks: ");
        int maths = Integer.parseInt(scanner.next());
        System.out.print("Enter Science marks: ");
        int science = Integer.parseInt(scanner.next());
        System.out.print("Enter Social marks: ");
        int social = Integer.parseInt(scanner.next());
      
        int totalMarks = english+telugu+hindi+maths+science+social;
        
        int percentage = totalMarks/6;
        String result;
       
        if(percentage>=40 && percentage<=50) {
        	System.out.println("Your Result is Pass");
        	 result="pass";
        }
        else if(percentage>50 && percentage<=60) {
        	System.out.println("Your Result is average");
        	result="average";
        }
        else if(percentage>60 && percentage<=70) {
        	System.out.println("Your Result is Good");
        	result="good";
        }
        else if(percentage>70 && percentage<=80) {
        	System.out.println("Your Result is very Good");
        	result="Very good";
        }
        else if(percentage>80 && percentage<=90) {
        	System.out.println("Your Result is excellent");
        	result="Excellent";
        }
        else if(percentage>90 && percentage<=100) {
        	System.out.println("Your Result is out standing");
        	result="Out standing";
        }
        else {
        	System.out.println("You are failed...");
        	result="fail";
        }

        // Set the input parameters
        cs.setInt(1, rollno);
        cs.setString(2, name);
        cs.setString(3, branch);
        cs.setString(4, city);
        cs.setString(5, state);
        cs.setInt(6, pincode);
        cs.setString(7, mailid);
        cs.setLong(8, phno);
        cs.setInt(9, english);
        cs.setInt(10, telugu);
        cs.setInt(11, hindi);
        cs.setInt(12, maths);
        cs.setInt(13, science);
        cs.setInt(14, social);
        cs.setInt(15, totalMarks);
        cs.setInt(16, percentage);
        cs.setString(17, result);

        
        // Execute the callable statement
        cs.execute();

        // Close the resources
        cs.close();
        c.close();
        scanner.close();

        System.out.println("Procedure executed successfully!");
    } 
        catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
       
}
}

