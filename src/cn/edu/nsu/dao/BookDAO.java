package cn.edu.nsu.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.nsu.bean.Book;


public class BookDAO {

	private SessionFactory sessionFactory;
    private Session session;
    private ArrayList<Book> books;
    private ArrayList<Book> authors;
    private Book book;
    private String hql="";
    private int pageSize=18;
    private int lastPage,lpg,lpgs=1;
    private int pSize = 3;
    private Query query;

    
    
	public int getLpgs() {
		return lpgs;
	}
	public void setLpgs(int lpgs) {
		this.lpgs = lpgs;
	}
	public int getLpg() {
		return lpg;
	}
	public void setLpg(int lpg) {
		this.lpg = lpg;
	}
	public int getpSize() {
		return pSize;
	}
	public void setpSize(int pSize) {
		this.pSize = pSize;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		if(session==null||!session.isOpen())
			session=sessionFactory.openSession();
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
    
	public int getLastPage(int size) {
		if(size<0) {
			lastPage=1;
		}
			
		if(size%pageSize==0) {
			lastPage = size/pageSize;
		}
		else {
			lastPage= size/pageSize+1;
		}
		return lastPage;
	}
	
    public ArrayList<Book> getAllBooks(int page){
    	hql = " from Book";
    	query = getSession().createQuery(hql);
    	lastPage = getLastPage(query.list().size());
    	query.setFirstResult((page-1)*pageSize);
    	query.setMaxResults(pageSize);
    	books = (ArrayList<Book>) query.list();
    	return books;
    }
    
    public ArrayList<Book> getAllbyTime(){
    	hql = " from Book where presstime > CAST('2008-01-01' as date)";
    	query = getSession().createQuery(hql);
    	books = (ArrayList<Book>) query.list();
    	return books;
    }
    
    public ArrayList<Book> getSearched(String key,int page){
    	hql = " from Book where bookname like :key or author like :key";
    	query = getSession().createQuery(hql);
        query.setParameter("key", "%"+key+"%");
        lpgs = getLastPage(query.list().size());
    	query.setFirstResult((page-1)*pageSize);
    	query.setMaxResults(pageSize);
    	System.out.println(lastPage +" this is the last page");
    	books = (ArrayList<Book>) query.list();
    	return books;
    }
    
    public ArrayList<Book> getAllBooksByCat(int cat_id,int page){
    	hql = " from Book where category="+cat_id+"";
    	query = getSession().createQuery(hql);
    	lpg = getLastPage(query.list().size());
    	
    	System.out.println(lpg+"dfsdgfsdgfdghsdfgd111111111111111111111111111111111111111dd");
    	query.setFirstResult((page-1)*pageSize);
    	query.setMaxResults(pageSize);
    	books = (ArrayList<Book>) query.list();
    	return books;
    }
    
    public ArrayList<Book> getAllBooksByCate(int cat_id,int page){
    	hql = " from Book where category="+cat_id+"";
    	query = getSession().createQuery(hql);
    	lastPage = getLastPage(query.list().size());
    
    	query.setFirstResult((page-1)*pSize);
    	query.setMaxResults(pSize);
    	books = (ArrayList<Book>) query.list();
    	return books;
    }
    
    public Book getoneBook(int id){
  
    	hql = " from Book where id="+id+"";
    	query = getSession().createQuery(hql);
    	book =  (Book)query.list().get(0);
    	return book;
    }
    
    public ArrayList<Book> getAllAuthor(){
    	hql = " select distinct author from Book ";
    	query = getSession().createQuery(hql);
    	authors =  (ArrayList<Book>)query.list();
    	return authors;
    }
    
   
    
	
}
