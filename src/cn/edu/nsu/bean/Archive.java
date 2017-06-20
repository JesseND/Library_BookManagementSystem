package cn.edu.nsu.bean;

public class Archive {

	private int id;
	private String bookname;
	private String borrower;
	private String borrowtime;
	private String status;
	
	
	
	public Archive() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Archive(int id, String bookname, String borrower, String borrowtime, String status) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.borrower = borrower;
		this.borrowtime = borrowtime;
		this.status = status;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
