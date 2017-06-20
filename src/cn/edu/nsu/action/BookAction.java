package cn.edu.nsu.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nsu.bean.Category;
import cn.edu.nsu.bean.Book;
import cn.edu.nsu.dao.BookDAO;



public class BookAction extends ActionSupport {

	 private ArrayList<Book> books;
	 private ArrayList<Book> dtbooks;
	 private List<Book> briefBook;
	 private ArrayList<Book> authors;
	 private BookDAO bookDAO;
	 private int page=1;
	 private int lastPage;
	 private int cat_id;
	 private String searchKey;
	  
    
	public ArrayList<Book> getDtbooks() {
		return dtbooks;
	}
	public void setDtbooks(ArrayList<Book> dtbooks) {
		this.dtbooks = dtbooks;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
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
	public List getBriefBook() {
		if(books.size()>12)
		briefBook =  books.subList(0, 12);
		else briefBook =books;
		return briefBook;
	}
	public void setBriefBook(List briefBook) {
		this.briefBook = briefBook;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
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
		books = getBookDAO().getAllBooks(page);
		dtbooks = getBookDAO().getAllbyTime();
		briefBook = getBriefBook();
		authors = getBookDAO().getAllAuthor();
		System.out.println(authors.size()+"all authors");
		
		return SUCCESS;
		
	}
	
	public String toBooks() throws Exception {
		// TODO Auto-generated method stub
		books = getBookDAO().getAllBooks(getPage());
		lastPage = bookDAO.getLastPage();
		return "toBooks";
		
	}
	
	
	public String getSearch() {
		lastPage=bookDAO.getLastPage();
		books = getBookDAO().getSearched(getSearchKey(), getPage());
		System.out.println(books.size()+"searched ones" );
		return "toSearch";
	}
	
	public String getByCat() throws Exception{
		lastPage=bookDAO.getLpg();
		books = getBookDAO().getAllBooksByCat(getCat_id(),getPage());
		System.out.print(lastPage+" 11111111111111111111122222222");
		
		return "byCat";
	}
	
	   
	   
}
