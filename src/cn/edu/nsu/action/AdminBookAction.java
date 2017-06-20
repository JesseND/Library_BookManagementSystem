package cn.edu.nsu.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.Book;
import cn.edu.nsu.dao.AdminBookDAO;

public class AdminBookAction extends ActionSupport {
	private int page=1;
	private int lastPage;
	private ArrayList<Book> books;
	private Book book;
	private String msg;
	private int id;
	private AdminBookDAO adminBookDAO;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public String execute() throws Exception{
		books=adminBookDAO.get(page);
		lastPage=adminBookDAO.getLastPage();
		return SUCCESS;
	}
	public String getAll() throws Exception{
		books=adminBookDAO.get(1);
		lastPage=adminBookDAO.getLastPage();
		return "all";
	}
	public String modify() throws Exception{
		book=getAdminBookDAO().getById(id);
		return "modify";
	}
	public String saveModify() throws Exception{
		int result=getAdminBookDAO().update(book);
		if(result>0)
		{
			msg="Modify Book successfully!";
		}
		else{
			msg="Modify Book failed!";
		}
	    return "result";
	}
	public String del() throws Exception{
		book=getAdminBookDAO().getById(id);
		int result=getAdminBookDAO().delete(book);
		if(result>0)
		{
			msg="delete Book successfully!";
		}
		else{
			msg="delete Book fauled!";
		}
		return "result";
	}
	public String add() throws Exception{
		int result=getAdminBookDAO().add(book);
		if(result>0)
		{
			msg="Add book successfully!";
		}
		else{
			msg="Add book fauled!";
		}
		return "result";
	}
	public AdminBookDAO getAdminBookDAO() {
		return adminBookDAO;
	}
	public void setAdminBookDAO(AdminBookDAO adminBookDAO) {
		this.adminBookDAO = adminBookDAO;
	}
}
