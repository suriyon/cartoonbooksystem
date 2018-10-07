package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Category;
import utils.MySQLHelper;

public class CategoryDAO {
	public String genCatId() {
		String id = "";
		String sql = "select cat_id from category order by cat_id desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String str = rs.getString(1);
				str = str.substring(3);
				int count = Integer.parseInt(str);
				count++;
				if(count<10)
					id = "CAT00" + count;
				else if(count<100)
					id = "CAT0" + count;
				else
					id = "CAT" + count;
			}else {
				id = "CAT001";
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public boolean insert(Category category) {
		boolean result = false;
		String sql = "insert into category (cat_id, cat_name) values(?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, category.getCatId());
			ps.setString(2, category.getCatName());
			int row = ps.executeUpdate();
			if(row > 0)
				result = true;
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean update(Category category) {
		boolean result = false;
		String sql = "update category set cat_name = ? where cat_id = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(2, category.getCatId());
			ps.setString(1, category.getCatName());
			int row = ps.executeUpdate();
			if(row > 0)
				result = true;
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector selectAll() {
		Vector categories = new Vector();
		String sql = "select * from category";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector category = new Vector();
				category.add(rs.getString(1));
				category.add(rs.getString(2));
				
				categories.add(category);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector selectByName(String name) {
		Vector categories = new Vector();
		String sql = "select * from category where cat_name like ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector category = new Vector();
				category.add(rs.getString(1));
				category.add(rs.getString(2));
				
				categories.add(category);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
}
