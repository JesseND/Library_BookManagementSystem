package cn.edu.nsu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.Borrow;
import cn.edu.nsu.bean.BorrowHistory;
import cn.edu.nsu.dao.BorrowDAO;

public class ReturnBookAction extends ActionSupport {

	private BorrowDAO borrowDAO;
	private List<Borrow> borrows;
	private List<BorrowHistory> borrowhistory;
	private Borrow borrow;
	private String msg = "";
	private int userId;
	private int bookId;
	private int countBorrows;
	private int bcounts;

	
	public BorrowDAO getBorrowDAO() {
		if(borrowDAO == null)
			borrowDAO = new BorrowDAO();
		return borrowDAO;
	}
	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	
	
	public List<Borrow> getBorrows() {
		return borrows;
	}
	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}
	public List<BorrowHistory> getBorrowhistory() {
		return borrowhistory;
	}
	public void setBorrowhistory(List<BorrowHistory> borrowhistory) {
		this.borrowhistory = borrowhistory;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCountBorrows() {
		return countBorrows;
	}
	public void setCountBorrows(int countBorrows) {
		this.countBorrows = countBorrows;
	}
	public int getBcounts() {
		return bcounts;
	}
	public void setBcounts(int bcounts) {
		this.bcounts = bcounts;
	}
	
	   public int getUser(){

			int kuser;
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("userId");
			if(obj == null)
				kuser = 0;
			else
				kuser = (int)obj;
			
			return kuser;
		}
	
	@Override
	public String execute() throws Exception {
		System.out.println(getBookId());

		userId = getUser();
		System.out.print("bookid="+bookId);
		//System.out.print("bookId: "+ bookId+" userId: "+userId+ "in the return method");
		
		int result = getBorrowDAO().returnBook(bookId, userId);
		if(result == 1){
			msg += "Book has been returned successfully ";
		}else{
			msg += "Failed to return the book to our system! please TRY AGAIN";
		}
		
		return "success";
	}
	
	
}
