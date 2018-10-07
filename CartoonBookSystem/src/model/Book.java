package model;

public class Book {
	private String bookId;
	private String bookName;
	private int bookPrice;
	private int price;
	private int bookTotal;
	private int bookRemain;
	private int bookRent;
	private Publisher publisher;
	private Writer writer;
	private Category category;
	
	public Book(String bookId, String bookName, int bookPrice, int price, int bookTotal, int bookRemain, int bookRent) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.price = price;
		this.bookTotal = bookTotal;
		this.bookRemain = bookRemain;
		this.bookRent = bookRent;
	}
	public Book() {
		super();
	}
	public Book(String bookId, String bookName, int bookPrice, int price, int bookTotal, int bookRemain, int bookRent,
			Publisher publisher, Writer writer, Category category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.price = price;
		this.bookTotal = bookTotal;
		this.bookRemain = bookRemain;
		this.bookRent = bookRent;
		this.publisher = publisher;
		this.writer = writer;
		this.category = category;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBookTotal() {
		return bookTotal;
	}
	public void setBookTotal(int bookTotal) {
		this.bookTotal = bookTotal;
	}
	public int getBookRemain() {
		return bookRemain;
	}
	public void setBookRemain(int bookRemain) {
		this.bookRemain = bookRemain;
	}
	public int getBookRent() {
		return bookRent;
	}
	public void setBookRent(int bookRent) {
		this.bookRent = bookRent;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
