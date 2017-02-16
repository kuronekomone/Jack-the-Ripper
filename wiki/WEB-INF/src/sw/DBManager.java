package sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager{
	
	
	
	public static Connection getConnection(){
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection con = DriverManager.getConnection(url,"os", "wiki");
			
			
			return con;
			
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}
	
	public static int simpleUpdate(String sql)throws SQLException{
		
		Connection con = null;
		Statement smt = null;
		
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			return smt.executeUpdate(sql);
			
		}finally{
			if(smt != null){
				try {smt.close();} catch(SQLException ignore){}
			}
			if(con != null){
				try {smt.close();} catch(SQLException ignore){}
			} 
		}
	}
	
	public static List simpleFind(String sql,ResultSetBeanMapping mapping)throws SQLException{
		
		Connection con = null;
		Statement smt = null;
		
		try{
			List list = new ArrayList();
			
			con = DBManager.getConnection();
			smt = con.createStatement();
			System.out.println(sql);
			ResultSet rs = smt.executeQuery(sql);
			
			while(rs.next()){
				
				Object bean = mapping.createFromResultSet(rs);
				
				list.add(bean);
			}
			
			return list;
			
		}finally{
			if(smt != null){
				try {smt.close();} catch(SQLException ignore){}
			}
			if(con != null){
				try {con.close();} catch(SQLException ignore){}
			} 
		}
	}
	/*
	public static void main(String[] args) throws Exception{
		
		Connection con = getConnection();
		System.out.println("con=" + con);
		con.close();
	}*/
}