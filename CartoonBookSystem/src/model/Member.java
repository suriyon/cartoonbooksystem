package model;

public class Member {
	private String memId;
	private String memName;
	private String memAddr;
	private String memTel;
	
	public Member() {
		super();
	}
	public Member(String memId, String memName, String memAddr, String memTel) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memAddr = memAddr;
		this.memTel = memTel;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	
}
