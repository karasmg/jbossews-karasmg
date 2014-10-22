package jbossews.model;

import java.sql.*;
import java.util.Properties;
import org.apache.log4j.Logger;

public class MySqlDaoFactory implements DaoFactory {
	 private String user = "adminsBzzT2D"; //Логин пользователя 
	 private String password = "9BLRREpyGu3K"; //Пароль пользователя 
	 private String url = "jdbc:mysql://5434014fe0b8cde08b00017f-karasmg.rhcloud.com:45471/ppool?useUnicode=true&characterEncoding=UTF-8"; //URL адрес 
	// private String url = "jdbc:mysql://127.0.0.1:45471/ppool?useUnicode=true&characterEncoding=UTF-8"; //URL адрес
	 private String driver = "com.mysql.jdbc.Driver"; //Имя драйвера 
	
	 
	 
	 public Connection getConnection() throws SQLException 
	 { 
	 return DriverManager.getConnection(url, user, password); 
	 } 
	
	 public UserDao getUserDao(Connection connection) { 
		 return new MySqlUserDao(connection); 
		 } 
	 
	 
	 public MySqlDaoFactory() { 
	/*	 Properties p = new Properties();
		 p.setProperty('useUnicode','true');
		 p.setProperty('characterEncoding','cp1251');*/
	 try { 
		 Class.forName(driver); //Регистрируем драйвер 
	 	} 
	 catch (ClassNotFoundException e) { 
		 e.printStackTrace(); 
		 } 
	 }
}
