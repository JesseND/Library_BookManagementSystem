package cn.edu.nsu.bean;

public class BorrowHistory {
	
	private String cover;
	private String bookname;
	private String bookauthor;
	private String borrowtime;
	private String status;
	//private int userId;
	private int bookId;
	
	public BorrowHistory(){
		
	}
	
	
	
	public BorrowHistory(int bookId, String cover, String bookname, String bookauthor, String borrowtime, String status) {
		super();
		this.bookId = bookId;
		this.cover = cover;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.borrowtime = borrowtime;
		this.status = status;
	}



	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
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



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	

}
