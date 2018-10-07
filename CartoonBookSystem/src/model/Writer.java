package model;

public class Writer {
	private String writerId;
	private String writerName;
	
	public Writer() {
		super();
	}
	public Writer(String writerId, String writerName) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
}
