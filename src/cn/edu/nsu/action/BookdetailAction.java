package cn.edu.nsu.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.Book;
import cn.edu.nsu.bean.Category;
import cn.edu.nsu.dao.BookDAO;
import cn.edu.nsu.dao.CategoryDAO;

public class BookdetailAction extends ActionSupport{

     private int book_id,cat_id;
	 private Book dbook;
	 private BookDAO bookDAO;
	 private CategoryDAO categoryDAO;
	 private Category bnCategory;
	 private ArrayList<Book> rbooks;
	 private int pge=1;
	 private int lastPg;
	   
	   
	
	
	public int getPge() {
		return pge;
	}
	public void setPge(int pge) {
		this.pge = pge;
	}
	public int getLastPg() {
		return lastPg;
	}
	public void setLastPg(int lastPg) {
		this.lastPg = lastPg;
	}
	public ArrayList<Book> getRbooks() {
		return rbooks;
	}
	public void setRbooks(ArrayList<Book> rbooks) {
		this.rbooks = rbooks;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	public Category getBnCategory() {
		return bnCategory;
	}
	public void setBnCategory(Category bnCategory) {
		this.bnCategory = bnCategory;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	

	public Book getDbook() {
		return dbook;
	}
	public void setDbook(Book dbook) {
		this.dbook = dbook;
	}
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		dbook=getBookDAO().getoneBook(getBook_id());
		bnCategory = getCategoryDAO().getCatName(getCat_id());
//		rbooks = getBookDAO().getAllBooksByCat(getCat_id(),getPage());
	   
		return SUCCESS;
	}
	
	public String relByCat() throws Exception{
		
		rbooks = getBookDAO().getAllBooksByCate(getCat_id(),getPge());
//		lastPg=getBookDAO().getLastPage();
        System.out.println(getCat_id()+" passed id by ajax nnnnnnnnnnnnnnnnnnnnnnnnn");
        
		return "relByCat";
	}
	
	
}
