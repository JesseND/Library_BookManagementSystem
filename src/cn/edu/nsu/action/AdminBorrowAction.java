package cn.edu.nsu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.Archive;
import cn.edu.nsu.dao.BorrowDAO;

public class AdminBorrowAction extends ActionSupport{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BorrowDAO borrowDAO;
	 
	 private List<Archive> archive;
	
	public BorrowDAO getBorrowDAO() {
		if(borrowDAO == null)
			borrowDAO = new BorrowDAO();
		return borrowDAO;
	}
	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}
	
	public List<Archive> getArchive() {
		return archive;
	}
	public void setArchive(List<Archive> archive) {
		this.archive = archive;
	} 
	
	public String execute() throws Exception{
		
		return SUCCESS;
	} 
	
	public String records() throws Exception{
		
		setArchive(getBorrowDAO().getAll());
		return "record";
		
	}
	
}
