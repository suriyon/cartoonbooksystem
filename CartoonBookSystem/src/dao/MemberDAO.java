package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Category;
import model.Member;
import utils.MySQLHelper;

public class MemberDAO {
	public String genMemId() {
		String id = "";
		String sql = "select mem_id from member order by mem_id desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String str = rs.getString(1);
				str = str.substring(3);
				int count = Integer.parseInt(str);
				count++;
				if(count<10)
					id = "MEM000000" + count;
				else if(count<100)
					id = "MEM00000" + count;
				else if(count<1000)
					id = "MEM0000" + count;
				else if(count<10000)
					id = "MEM000" + count;
				else if(count<100000)
					id = "MEM00" + count;
				else if(count<1000000)
					id = "MEM0" + count;
				else
					id = "MEM" + count;
			}else {
				id = "MEM0000001";
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
	public boolean insert(Member member) {
		boolean result = false;
		String sql = "insert into member (mem_id, mem_name, mem_addr, mem_tel) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, member.getMemId());
			ps.setString(2, member.getMemName());
			ps.setString(3, member.getMemAddr());
			ps.setString(4, member.getMemTel());
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
	public boolean update(Member member) {
		boolean result = false;
		String sql = "update member set mem_name = ?, mem_addr = ?, mem_tel = ? where mem_id = ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, member.getMemName());
			ps.setString(2, member.getMemAddr());
			ps.setString(3, member.getMemTel());
			ps.setString(4, member.getMemId());
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
		Vector members = new Vector();
		String sql = "select * from member";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector member = new Vector();
				member.add(rs.getString(1));
				member.add(rs.getString(2));
				member.add(rs.getString(3));
				member.add(rs.getString(4));
				
				members.add(member);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
	public Vector selectByName(String name) {
		Vector members = new Vector();
		String sql = "select * from member where mem_name like ?";
		try {
			PreparedStatement ps = MySQLHelper.open().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector member = new Vector();
				member.add(rs.getString(1));
				member.add(rs.getString(2));
				member.add(rs.getString(3));
				member.add(rs.getString(4));
				
				members.add(member);
			}
			rs.close();
			ps.close();
			MySQLHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
}
