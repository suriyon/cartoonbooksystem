package test;

import dao.MemberDAO;

public class TestMemberDAO {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		System.out.println(dao.genMemId());
	}

}
