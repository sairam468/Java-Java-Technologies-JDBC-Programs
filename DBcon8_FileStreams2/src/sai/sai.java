package sai;

import java.sql.Connection;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class sai {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		try(sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
				PreparedStatement ps=con.prepareStatement("insert into StreamTab64 values(?,?)");
				System.out.println("Enter the id to store image : ");
				String id=sc.nextLine();
				System.out.println("Enter the fpath & fname(source) : ");
				File f=new File(sc.nextLine());
				
				if(f.exists()) {
					FileInputStream fis=new FileInputStream(f);
					
					ps.setString(1, id);
					ps.setBinaryStream(2, fis,f.length());
					
					int k=ps.executeUpdate();
					if(k>0) {
						System.out.println("Image stored successfully...");
					}
					
				}
				else {
					System.out.println("Invalid fpath or fname...");
				}

			}	

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
