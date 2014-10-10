package jbossews.model;

import java.sql.*;

public class MySqlDataFactory {
	 private String user = "adminsBzzT2D"; //Логин пользователя 
	 private String password = "9BLRREpyGu3K"; //Пароль пользователя 
	 private String url = "jdbc:mysql://127.0.0.1:45471/"; //URL адрес 
	 private String driver = "com.mysql.jdbc.Driver"; //Имя драйвера 
	 public Connection getConnection() throws SQLException { 
	 return DriverManager.getConnection(url, user, password); } 
	
	 public UserDao getUserDao(Connection connection) { 
		 return new MySqlUserDao(connection); 
		 } 
	 
	 
	 public MySqlDataFactory() { 
	 try { 
		 Class.forName(driver); //Регистрируем драйвер 
	 	} 
	 catch (ClassNotFoundException e) { 
		 e.printStackTrace(); 
		 } 
	 }
}
