package sAI;
import java.sql.*;
public class Sai {
public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //optional as next step automatically loads the driver
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sai","1234");
		
		System.out.println("---Statement---");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs1=s.executeQuery("select * from customer64");
		System.out.println("--afterLast()--");
		rs1.afterLast();
		while(rs1.previous()) {
			System.out.println(rs1.getLong(1)+"\t"+rs1.getString(2)+"\t"+rs1.getLong(3)+"\t"+rs1.getLong(4));
		}
		
		System.out.println("--Prepare Statement--");
		PreparedStatement ps=c.prepareStatement("select * from customer64", 1004,1007);
		ResultSet rs2=ps.executeQuery();
		System.out.println("--Employee Details--");
		while(rs2.next()) {
			System.out.println(rs2.getLong(1)+"\t"+rs2.getString(2)+"\t"+rs2.getLong(3)+"\t"+rs2.getLong(4));
		}
		
		System.out.println("--first()--");
		rs2.first();
		System.out.println(rs2.getLong(1)+"\t"+rs2.getString(2)+"\t"+rs2.getLong(3)+"\t"+rs2.getLong(4));
	
		System.out.println("--absolute(int)--");
		rs2.absolute(4);
		System.out.println(rs2.getLong(1)+"\t"+rs2.getString(2)+"\t"+rs2.getLong(3)+"\t"+rs2.getLong(4));
	
		System.out.println("--relative(int)--");
		rs2.relative(-2);
		System.out.println(rs2.getLong(1)+"\t"+rs2.getString(2)+"\t"+rs2.getLong(3)+"\t"+rs2.getLong(4));
	
        System.out.println("===Values Assigned to fields===");
		System.out.println("Type forward only : "+ResultSet.TYPE_FORWARD_ONLY);
		System.out.println("Type Scroll Insensitive : "+ResultSet.TYPE_SCROLL_INSENSITIVE);
		System.out.println("Type Scroll sensitive : "+ResultSet.TYPE_SCROLL_SENSITIVE);
		
		System.out.println("Concur Read Only : "+ResultSet.CONCUR_READ_ONLY);
		System.out.println("Concur Updatable : "+ResultSet.CONCUR_UPDATABLE);
		
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
}
}
