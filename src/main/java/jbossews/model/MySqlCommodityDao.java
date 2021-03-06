package jbossews.model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jbossews.controller.GetNamesByString;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySqlCommodityDao implements CommodityDao {
	static final Logger log = LogManager.getLogger(MySqlCommodityDao.class
			.getName());
	private static final long serialVersionUID = 1L;

	public MySqlCommodityDao(Connection connection) {
		super();
		this.connection = connection;
	}

	private final Connection connection;

	public void create(Commodity commodity) throws SQLException {

		String sql = "INSERT INTO ppool.Commodity (Name, Units, Manufacturer, Packing, BarCode) VALUES ('"
				+ commodity.getName()
				+ "', '"
				+ commodity.getUnits()
				+ "', '"
				+ commodity.getManufacturer()
				+ "', '"
				+ commodity.getPacking()
				+ "', '" + commodity.getBarCode() + "');";
		Statement stm = connection.createStatement();
		stm.executeUpdate(sql);

	}

	@Override
	public Commodity read(int key) throws SQLException {
		String sql = "SELECT * FROM ppool.Commodity WHERE idCommodity = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, key);
		ResultSet rs = stm.executeQuery();
		rs.next();
		Commodity g = new Commodity();
		g.setCommodityId(rs.getInt("idCommodity"));
		g.setName(rs.getString("Name"));
		g.setUnits(rs.getString("Units"));
		g.setManufacturer(rs.getString("Manufacturer"));
		g.setPacking(rs.getString("Packing"));
		g.setBarCode(rs.getString("BarCode"));
		return g;
	}

	@Override
	public void update(Commodity Commodity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Commodity Commodity) {
		// TODO Auto-generated method stub

	}
/* Функция по запросу query делает запрос в таблицу Commodity. 
 * В зависимости от количества пробелов в query, из поля name формируется словарь
 * из одного слова или из 2 слов или из 3 слов и т.д. И уже к словарю применяется
 * фильтр query.
 */
	public List<String> getNamesCommoditiesByString(String query)
			throws SQLException {

		//Считаем количество пробелов в query
		int spaceCount = (query.length() - query.replaceAll(" ", "").length()) + 1;
		
		//Формруем запрос в зависимости от количества пробелов. 
		String sql = "SELECT DISTINCT SUBSTRING_INDEX(replace(name,'  ',' '), ' ', "
				+ spaceCount
				+ ") as names From ppool.Commodity where (char_length(replace(name,'  ',' ')) - char_length(replace(replace(name,'  ',' '),' ','')))>="
				+ spaceCount
				+ " and SUBSTRING_INDEX(replace(name,'  ',' '), ' ', "
				+ spaceCount + ") like '" + query + "%' LIMIT 10;";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();

		List<String> list = new ArrayList<String>();

		while (rs.next()) {
			String g = new String();
			g = (rs.getString("names"));
			list.add(g);
		}

		return list;
	}

}
