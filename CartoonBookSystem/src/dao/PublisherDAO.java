package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Category;
import model.Publisher;
import utils.MySQLHelper;

public class PublisherDAO {
	public String genPubId() {
		String id = "";
		String sql = "select pub_id from publisher order by pub_id desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String str = rs.getString(1);
				str = str.substring(3);
				int count = Integer.parseInt(str);
				count++;
				if(count<10)
					id = "PUB00" + count;
				else if(count<100)
					id = "PUB0" + count;
				else
					id = "PUB" + count;
			}else {
				id = "PUB001";
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
	public boolean insert(Publisher publisher) {
		boolean result = false;
		String sql = "insert into publisher (pub_id, pub_name) values(?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, publisher.getPubId());
			ps.setString(2, publisher.getPubName());
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
	public boolean update(Publisher publisher) {
		boolean result = false;
		String sql = "update publisher set pub_name = ? where pub_id = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(2, publisher.getPubId());
			ps.setString(1, publisher.getPubName());
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
		Vector publishers = new Vector();
		String sql = "select * from publisher";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector pubisher = new Vector();
				pubisher.add(rs.getString(1));
				pubisher.add(rs.getString(2));
				
				publishers.add(pubisher);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publishers;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector selectByName(String name) {
		Vector publishers = new Vector();
		String sql = "select * from publisher where pub_name like ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector publisher = new Vector();
				publisher.add(rs.getString(1));
				publisher.add(rs.getString(2));
				
				publishers.add(publisher);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publishers;
	}
}
