package jbossews.model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommodityDao implements CommodityDao {

	public MySqlCommodityDao(Connection connection) {
		super();
		this.connection = connection;
	}

	private final Connection connection;

	public void create(Commodity commodity) throws SQLException {
		
		String sql = "INSERT INTO ppool.Commodity (Name, Units, Manufacturer, Packing, BarCode) VALUES ('"+commodity.getName()+"', '"+commodity.getUnits()+"', '"+commodity.getManufacturer()+"', '"+commodity.getPacking()+"', '"+commodity.getBarCode()+"');";
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

	public List<String> getNamesCommoditiesByString(String query) throws SQLException {
		//String sql = "SELECT Name FROM ppool.Commodity WHERE Name LIKE '%"+query+"%';";
		int spaceCount = query.split(" ").length-1;
		String sql = "SELECT DISTINCT SUBSTRING_INDEX(replace(name,'  ',' '), ' ', "+spaceCount+") as hhh From ppool.Commodity where (char_length(replace(name,'  ',' ')) - char_length(replace(replace(name,'  ',' '),' ','')))>=3 and SUBSTRING_INDEX(replace(name,'  ',' '), ' ', "+spaceCount+") like '%"+query+"%';";
		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		List<String> list = new ArrayList<String>();

		while (rs.next()) {
			String g = new String();
			g = (rs.getString("Name"));
			list.add(g);
		}

		return list;
	}


}
