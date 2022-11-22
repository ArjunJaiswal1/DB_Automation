package com.db.automation.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.db.test.base.BaseClass;

public class DB_test extends BaseClass {
	@Test
	public void getTableData() throws SQLException {
		con = this.setUp();
		//Statement Object to send queries.
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from employee");
		while (rs.next())
	    {
	        int id =rs.getInt(1);
	        String name =rs.getString(2);
	        int age =rs.getInt(3);
	        
	        System.out.println(id+"  "+name+"  "+age );
	    }
	}
	@Test
	 public void insertData() throws SQLException {
		 con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
		 ps.setInt(1,4);
		 ps.setString(2, "Rani");
		 ps.setInt(3, 27);
		 ps.executeUpdate();
		 getTableData();
	 }
	@Test 
	 
	 public void updateTableData () throws SQLException {
		con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("update employee set name = ? where id = ?");
		 ps.setInt(2, 3);
		 ps.setString(1, "Paras");
		 
		 ps.executeUpdate();
		 getTableData(); 
	 }
	@Test
	
	public void deleteTaleData() throws SQLException {
		 con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("delete from employee where Id= ?");
		 ps.setInt(1, 3);
		 ps.executeUpdate();
		 getTableData(); 
		
	}
	

}

