package sai;

import java.sql.Connection;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class sai {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		try(sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
				PreparedStatement ps=con.prepareStatement("select * from StreamTab64 where ID=?");
				System.out.println("Enter the id  : ");
				String id=sc.nextLine();
				
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					Blob b=rs.getBlob(2);
					byte by[]=b.getBytes(1,(int)b.length());
					System.out.println("Enter the fpath & fname to destination : ");
					String destinationPath = sc.nextLine() + ".jpg";
					File f=new File(destinationPath);

					FileOutputStream fos=new FileOutputStream(f);
					fos.write(by);
					System.out.println("Image Retrived sucessfully...");

					fos.close();
				
				}
				else {
					System.out.println("Invalid Id...");
				}


			}	

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
