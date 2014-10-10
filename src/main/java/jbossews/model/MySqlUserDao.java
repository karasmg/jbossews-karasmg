package jbossews.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDao {
	
	public MySqlUserDao(Connection connection) {
		super();
		this.connection = connection;
	}

	private final Connection connection;
	@Override
	public User create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User read(int key) throws SQLException {
		String sql = "SELECT * FROM ppool.User WHERE idUser = ?"; 
		PreparedStatement stm = connection.prepareStatement(sql); 
		stm.setInt(1, key); 
		ResultSet rs = stm.executeQuery(); 
		rs.next(); 
		User g = new User(); 
		g.setUserId(rs.getInt("idUser")); 
		g.setName(rs.getString("Name")); 
		g.setCity(rs.getString("City"));
		g.setCountry(rs.getString("Country"));
		g.setGpsPoint(rs.getString("GPSpoint"));
		g.setAddress(rs.getString("Address"));
		return g;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAll() throws SQLException {
		 String sql = "SELECT * FROM ppool.User;";  
		 PreparedStatement stm = connection.prepareStatement(sql); 
		 ResultSet rs = stm.executeQuery(); 
		 List<User> list = new ArrayList<User>(); 
		 while (rs.next()) { 
			 User g = new User(); 
				g.setUserId(rs.getInt("idUser")); 
				g.setName(rs.getString("Name")); 
				g.setCity(rs.getString("City"));
				g.setCountry(rs.getString("Country"));
				g.setGpsPoint(rs.getString("GPSpoint"));
				g.setAddress(rs.getString("Address"));			 
				list.add(g);
		 } return list;	}

	/**
	 * @return the connection
	 */


}
