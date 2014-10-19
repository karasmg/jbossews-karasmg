package jbossews.model;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {


	/** Создает новую запись и соответствующий ей объект 
	 * @throws SQLException */ 
	public void create(Store store) throws SQLException; 

	/** Возвращает объект соответствующий записи с первичным ключом key или null 
	 * @throws SQLException */ 
	public Store read(int key) throws SQLException; 

	/** Сохраняет состояние объекта group в базе данных */ 
	public void update(Store store); 

	/** Удаляет запись об объекте из базы данных */ 
	public void delete(Store store); 

	/** Возвращает список объектов соответствующих всем записям в базе данных */ 
	public List<Store> getAll() throws SQLException;
}
