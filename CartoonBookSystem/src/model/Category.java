package model;

public class Category {
	private String catId;
	private String catName;
	
	public Category() {
		super();
	}
	public Category(String catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
}
