package cn.edu.nsu.bean;
import java.util.Date;


public class Borrow {

	
	private int id;
	private int bookid;
	private int userid;
	private String borrowtime;
	private int returned;
	
	public Borrow() {
			
	}
	
	
	public Borrow(int bookid, int userid, String borrowtime, int returned) {
		super();
		this.bookid = bookid;
		this.userid = userid;
		this.borrowtime = borrowtime;
		this.returned = returned;
	}
	
	
	public Borrow(int bookid, int userid) {
		super();
		this.bookid = bookid;
		this.userid = userid;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	
	
}
