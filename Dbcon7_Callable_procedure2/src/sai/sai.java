package sai;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class sai {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

    try {
    	
	Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");
	
	CallableStatement cs=c.prepareCall("{call getstudetails64(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	System.out.println("Enter Stu-RollNo : ");
	long accNo=scanner.nextLong();
	
	cs.setLong(1,accNo);
	
	cs.registerOutParameter(2, Types.VARCHAR);
	cs.registerOutParameter(3, Types.VARCHAR);
	cs.registerOutParameter(4, Types.VARCHAR);
	cs.registerOutParameter(5, Types.VARCHAR);
	cs.registerOutParameter(6, Types.INTEGER);
	cs.registerOutParameter(7, Types.VARCHAR);
	cs.registerOutParameter(8, Types.INTEGER);
	cs.registerOutParameter(9, Types.INTEGER);
	cs.registerOutParameter(10, Types.INTEGER);
	cs.registerOutParameter(11, Types.INTEGER);
	cs.registerOutParameter(12, Types.INTEGER);
	cs.registerOutParameter(13, Types.INTEGER);
	cs.registerOutParameter(14, Types.INTEGER);
	cs.registerOutParameter(15, Types.INTEGER);
	cs.registerOutParameter(16, Types.INTEGER);
	cs.registerOutParameter(17, Types.VARCHAR);
	
	cs.execute();
	
	System.out.println("---Details---");
	System.out.println("Stu-RollNo : "+accNo);
	System.out.println("Stu-Name : "+cs.getString(2));
	System.out.println("Stu-Branch : "+cs.getString(3));
	System.out.println("Stu-City : "+cs.getString(4));
	System.out.println("Stu-State : "+cs.getString(5));
	System.out.println("Stu-pincode : "+cs.getInt(6));
	System.out.println("Stu-MailId : "+cs.getString(7));
	System.out.println("Stu-phno: "+cs.getLong(8));
	System.out.println("Eng : "+cs.getInt(9));
	System.out.println("Tel : "+cs.getInt(10));
	System.out.println("Hin : "+cs.getInt(11));
	System.out.println("Mat : "+cs.getInt(12));
	System.out.println("Sci : "+cs.getInt(13));
	System.out.println("Soc : "+cs.getInt(14));
	System.out.println("Total : "+cs.getInt(15));
	System.out.println("Perc : "+cs.getInt(16));
	System.out.println("Results : "+cs.getString(17));
	

    // Close the resources
    cs.close();
    c.close();
    scanner.close();


    System.out.println("Procedure executed successfully!");
} catch (Exception e) {
    e.printStackTrace();
}
}
}
