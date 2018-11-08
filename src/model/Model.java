package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	String url = "jdbc:oracle:thin:@localhost:1521/newpdb";
	String user = "Tousif";
	String password = "Tousif";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null; 
	
	String usn = null;
	String name = null;
	int marks1 = 0;
	int marks2 = 0;
	int marks3 = 0;
	float avg = 0.0f;
	
	public Model() {
		super();
		try {
			//Goto Project-->Properties-->Deployment Assembly-->Java Build Path Assembly-->Add OJDBC Jar Here
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Successfull");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Failed");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void setUsn(String usn) {
		this.usn = usn;
		System.out.println("Received usn in model and usn is : "+usn);
	}
	
	public void getResult() {
		try {
			pstmt = con.prepareStatement("SELECT * FROM JulyStudents WHERE USN = ?");
			pstmt.setString(1, usn);
			res = pstmt.executeQuery();
			
			while(res.next()==true) {
				usn = res.getString(1);
				name = res.getString(2);
				marks1 = res.getInt(3);
				marks2 = res.getInt(4);
				marks3 = res.getInt(5);
				avg = res.getFloat(6);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUsn() {
		return usn;
	}

	public String getName() {
		return name;
	}

	public int getMarks1() {
		return marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public float getAvg() {
		return avg;
	}



}
