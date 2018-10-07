package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Category;
import model.Publisher;
import model.Writer;
import utils.MySQLHelper;

public class WriterDAO {
	public String genWriterId() {
		String id = "";
		String sql = "select writer_id from writer order by writer_id desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String str = rs.getString(1);
				str = str.substring(3);
				int count = Integer.parseInt(str);
				count++;
				if(count<10)
					id = "WRT00" + count;
				else if(count<100)
					id = "WRT0" + count;
				else
					id = "WRT" + count;
			}else {
				id = "WRT001";
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
	public boolean insert(Writer writer) {
		boolean result = false;
		String sql = "insert into writer (writer_id, writer_name) values(?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, writer.getWriterId());
			ps.setString(2, writer.getWriterName());
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
	public boolean update(Writer writer) {
		boolean result = false;
		String sql = "update writer set writer_name = ? where writer_id = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(2, writer.getWriterId());
			ps.setString(1, writer.getWriterName());
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
		Vector writers = new Vector();
		String sql = "select * from writer";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector writer = new Vector();
				writer.add(rs.getString(1));
				writer.add(rs.getString(2));
				
				writers.add(writer);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writers;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector selectByName(String name) {
		Vector writers = new Vector();
		String sql = "select * from writer where writer_name like ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector writer = new Vector();
				writer.add(rs.getString(1));
				writer.add(rs.getString(2));
				
				writers.add(writer);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writers;
	}
}
