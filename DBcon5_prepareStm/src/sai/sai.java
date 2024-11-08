package sai;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;

public class sai {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		try(sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");
				PreparedStatement ps1=con.prepareStatement("insert into employee64(eid,ename,edesg,bsal) values(?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("select * from employee64");
				PreparedStatement ps3=con.prepareStatement("select * from employee64 where eid=?");
				PreparedStatement ps4=con.prepareStatement("update employee64 set eid=?,ename=?,edesg=?,bsal=? where eid=?");
				PreparedStatement ps5=con.prepareStatement("delete employee64 where eid=?");



				while(true) {

					System.out.println("***Choice***");
					System.out.println("\t1.AddEmployee"
							+ "\n\t2.View All Employees"
							+ "\n\t3.View Employee By Id"
							+ "\n\t4.Edit Employee By Id(..Details..)"
							+ "\n\t5.Delete Employee By Id"
							+ "\n\t6.Exit");
					System.out.println("Enter Choice : ");
					int c=sc.nextInt();
					switch(c) {
					case 1:
						System.out.println("Enter the EID : ");
						int eId=(sc.nextInt());
						System.out.println("Enter the EName : ");
						String eName=sc.next();
						System.out.println("Enter thye EDESG : ");
						String eDesg=sc.next();
						System.out.println("Enter thye BSAL : ");
						int bSal=Integer.parseInt(sc.next());
						ps1.setInt(1, eId);
						ps1.setString(2, eName);
						ps1.setString(3, eDesg);
						ps1.setLong(4, bSal);
						int k=ps1.executeUpdate();
						if(k>0) {
							System.out.println("Employee Inserted");
						}
						break;

					case 2:
						ResultSet rs=ps2.executeQuery();
						while(rs.next()) {
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getLong(5)+"\t"+rs.getLong(6)+"\t"+rs.getLong(7));
						}
						break;

					case 3:
						System.out.println("Enter the Eid : ");
						int eID=sc.nextInt();
						ps3.setInt(1,eID);
						ResultSet r=ps3.executeQuery();
						if(r.next()) {
							System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5)+"\t"+r.getLong(6)+"\t"+r.getLong(7));
						}
						else {
							System.out.println("Invalid details...");
						}
						break;

					case 4:
						System.out.println("Enter the Eid : ");
						int ID=sc.nextInt();
						ps3.setInt(1,ID);
						ResultSet res=ps3.executeQuery();
						if(res.next()) {
							System.out.println("old eName is "+res.getString(2));
							System.out.println("Enter new eName : ");
							String nEName=sc.next();
							System.out.println("Enter new eID : ");
							int nEID=sc.nextInt();
							System.out.println("Enter new eDes : ");
							String nEDes=sc.next();
							System.out.println("Enter new bSal : ");
							int nBSal=sc.nextInt();
							ps4.setInt(1, nEID);
							ps4.setString(2, nEName);
							ps4.setString(3, nEDes);
							ps4.setInt(4, nBSal);
							ps4.setInt(5, ID);
							int i=ps4.executeUpdate();
							if(i>0) {
								System.out.println("Details updated Sucessfully...");
							}
							else {
								System.out.println("Invalid details.");
							}

						}
						else {
							System.out.println("Invalid details...");
						}

						break;

					case 5:
						System.out.println("Enter the Eid : ");
						int EID=sc.nextInt();
						ps3.setInt(1,EID);
						ResultSet rES=ps3.executeQuery();
						if(rES.next()) {
							ps5.setInt(1,EID);
							int j=ps5.executeUpdate();
							if(j>0) {
								System.out.println("Record deleted sucessfully..");
							}
							else
								System.out.println("Something is wrong :( ");
						}


						break;

					case 6:
						System.out.println("Operations Ended :) ...");
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice!.......");
					}

				}	
			}	

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
