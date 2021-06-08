package kr.or.kpc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnLocator {
	public static Connection getConnect() {
		
		DataSource ds = null;
		Connection con = null; 
		
		try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup(
				"java:comp/env/jdbc/kpc"); 
		//ConnectionPool에 만들어진 Connection 객체를 반환 
		con = ds.getConnection(); 
		}catch (NamingException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con; 
	}
}
