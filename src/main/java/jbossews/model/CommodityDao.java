package jbossews.model;

import java.sql.SQLException;
import java.util.List;

public interface CommodityDao {


	/** Создает новую запись и соответствующий ей объект 
	 * @throws SQLException */ 
	public void create(Commodity commodity) throws SQLException; 

	/** Возвращает объект соответствующий записи с первичным ключом key или null 
	 * @throws SQLException */ 
	public Commodity read(int key) throws SQLException; 

	/** Сохраняет состояние объекта group в базе данных */ 
	public void update(Commodity commodity); 

	/** Удаляет запись об объекте из базы данных */ 
	public void delete(Commodity commodity); 

}
