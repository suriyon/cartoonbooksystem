package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Book;
import model.Category;
import model.Member;
import utils.MySQLHelper;

public class BookDAO {
	public String genBookId() {
		String id = "";
		String sql = "select book_id from book order by book_id desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String str = rs.getString(1);
				str = str.substring(3);
				int count = Integer.parseInt(str);
				count++;
				if(count<10)
					id = "B00000" + count;
				else if(count<100)
					id = "B0000" + count;
				else if(count<1000)
					id = "B000" + count;
				else if(count<10000)
					id = "B00" + count;
				else if(count<100000)
					id = "B0" + count;
				else 
					id = "B" + count;				
			}else {
				id = "B000001";
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
	public boolean insert(Book book) {
		boolean result = false;
		String sql = "insert into book (book_id, book_name, book_price, price, book_total, book_remanin, book_rent, pub_id, writer_id, cat_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setInt(3, book.getBookPrice());
			ps.setInt(4, book.getPrice());
			ps.setInt(5, book.getBookTotal());
			ps.setInt(6, book.getBookRemain());
			ps.setInt(7, book.getBookRent());
			ps.setString(8, book.getPublisher().getPubId());
			ps.setString(9, book.getWriter().getWriterId());
			ps.setString(10, book.getCategory().getCatId());
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
	public boolean update(Book book) {
		boolean result = false;
		String sql = "update book set book_name = ?, price = ?, book_total = ?, book_remain = ?, book_rent = ? where book_id = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(6, book.getBookId());
			ps.setString(1, book.getBookName());
			ps.setInt(5, book.getBookRent());
			ps.setInt(2, book.getPrice());
			ps.setInt(3, book.getBookTotal());
			ps.setInt(4, book.getBookRemain());
			
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
	
	public Vector selectAll() {
		Vector books = new Vector();
		String sql = "select * from book";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector book = new Vector();
				book.add(rs.getString(1));
				book.add(rs.getString(2));
				book.add(rs.getString(3));
				book.add(rs.getString(4));
				book.add(rs.getString(5));
				book.add(rs.getString(6));
				book.add(rs.getString(7));
				book.add(rs.getString(8));
				book.add(rs.getString(9));
				book.add(rs.getString(10));
								
				books.add(book);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public Vector selectByName(String name) {
		Vector books = new Vector();
		String sql = "select * from book where book_name like ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector book = new Vector();
				book.add(rs.getString(1));
				book.add(rs.getString(2));
				book.add(rs.getString(3));
				book.add(rs.getString(4));
				book.add(rs.getString(5));
				book.add(rs.getString(6));
				book.add(rs.getString(7));
				book.add(rs.getString(8));
				book.add(rs.getString(9));
				book.add(rs.getString(10));				
				
				books.add(book);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
}
