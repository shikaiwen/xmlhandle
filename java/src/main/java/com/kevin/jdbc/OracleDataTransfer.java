package com.kevin.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDataTransfer {

	public static void main(String[] args) throws Exception{
//		getConn();
//		test1();
		test2();
	}
	
	public static void test2()throws Exception{
		String fileName = "data.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String s = null;
		Connection conn = getConn();
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		
		while((s=br.readLine()) != null ){
			String [] arr = s.split("\t");
			if(arr.length==2){
				stmt.executeUpdate("update fenrun_order set"
						+ " mer_code=" + arr[1] +"where fenrun_order_no="+ arr[0]);
			}
		}
		
		conn.commit();
	}
	
	public static void test1() throws Exception{
		Connection conn = getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from fenrun_order");
		String fileName = "data.txt";
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		while(rs.next()){
			String id = rs.getString(1);
			String col = rs.getString("mer_code");
//			System.out.println("id="+ id + ",col="+col);
			pw.println(id +"\t" + col);
		}
		

		
	}
	
	public static Connection getConn(){
		Connection conn = null;
		try{
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@139.196.49.159:1521:JINRI", "fi", "fi");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
