package jbossews.model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlStoreDao implements StoreDao {

	public MySqlStoreDao(Connection connection) {
		super();
		this.connection = connection;
	}

	private final Connection connection;

	public void create(Store store) throws SQLException {
		
		String sql = "INSERT INTO `ppool`.`Store` (`Name`, `Address`, `GPSpoint`) VALUES ("+store.getName()+", "+store.getAddress()+", "+store.getGpsPoint()+"');";
		Statement stm = connection.createStatement();
		stm.executeQuery(sql);
		
	}

	@Override
	public Store read(int key) throws SQLException {
		String sql = "SELECT * FROM ppool.Store WHERE idStore = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, key);
		ResultSet rs = stm.executeQuery();
		rs.next();
		Store g = new Store();
		g.setStoreId(rs.getInt("idStore"));
		g.setName(rs.getString("Name"));
		g.setGpsPoint(rs.getString("GPSpoint"));
		g.setAddress(rs.getString("Address"));
		return g;
	}

	@Override
	public void update(Store Store) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Store Store) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Store> getAll() throws SQLException {
		String sql = "SELECT * FROM ppool.Store WHERE Country LIKE '%Укр%';";
		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		List<Store> list = new ArrayList<Store>();

		while (rs.next()) {
			Store g = new Store();
			g.setStoreId(rs.getInt("idStore"));
			g.setName(rs.getString("Name"));
			g.setGpsPoint(rs.getString("GPSpoint"));
			g.setAddress(rs.getString("Address"));
			list.add(g);
		}

		return list;
	}

	/**
	 * @return the connection
	 */
	public String[][] getSqlSet(String sql) throws SQLException {
		// String sql = "SELECT * FROM ppool.Store WHERE Country LIKE '%Укр%';";
		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();
		System.out.println(rs.getMetaData().toString());

		// Получаем набор столбцов запроса
		List<String> columns = new ArrayList<String>();
		int columnCount = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			columns.add(rs.getMetaData().getColumnName(i));
		}
		// Получаем количество строк результирующего набора
		int rowCount = 0;
		if (rs.last())
			rowCount = rs.getRow() + 1;
		else
			System.out.print("чей-т нето!");
		rs.beforeFirst();

		// Создаем масив типа String по раземрам результирующего набора
		String[][] sqlSet = new String[columns.size()][rowCount];

		// Заносим первую строку в массив с именами столбцов
		int count = 0;
		for (String e : columns) {
			sqlSet[count][0] = e;

			System.out.print("|" + sqlSet[count][0] + "|");
			count++;
		}
		System.out.println("");

		int rowNumber = 1;
		while (rs.next()) {
			for (int i = 1; i < columnCount; i++) {
				sqlSet[i][rowNumber] = rs.getString(i);
				System.out.print("|" + sqlSet[i][rowNumber] + "|");
			}
			rowNumber++;
			System.out.println("");
		}

		return sqlSet;
	}

}
