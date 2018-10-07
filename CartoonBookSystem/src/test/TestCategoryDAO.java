package test;

import dao.CategoryDAO;

public class TestCategoryDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryDAO dao = new CategoryDAO();
		System.out.println(dao.genCatId());
	}

}
