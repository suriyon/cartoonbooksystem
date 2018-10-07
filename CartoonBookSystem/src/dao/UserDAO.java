package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.MySQLHelper;

public class UserDAO {
	public boolean checkUser(User user) {
		boolean result = false;
		String sql = "select * from user where username = ? and password = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
