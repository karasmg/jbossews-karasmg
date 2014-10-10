package jbossews.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
	/** Возвращает подключение к базе данных */ 
	public Connection getConnection() throws SQLException; 
	
	/** Возвращает объект для управления персистентным состоянием объекта Group */ 
	public UserDao getGroupDao(Connection connection); 
			
}
