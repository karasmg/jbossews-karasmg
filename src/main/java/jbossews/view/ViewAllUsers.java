package jbossews.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbossews.model.DaoFactory;
import jbossews.model.MySqlDaoFactory;
import jbossews.model.User;
import jbossews.model.UserDao;

public class ViewAllUsers {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		DaoFactory conn = new MySqlDaoFactory();
		Connection db = null;
		try {
			db = conn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao Ud = conn.getUserDao(db);
		List<User> lst = new ArrayList<User>();
		try {
			lst = Ud.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (User m : lst) {
			System.out.println("|" + m.getName() + "|" + m.getCountry() + "|"
					+ m.getCity() + "|" + m.getAddress() + "|");
		}
		try {
			db.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} 
}
