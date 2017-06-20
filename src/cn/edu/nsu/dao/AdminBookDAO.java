package cn.edu.nsu.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nsu.bean.Book;


public class AdminBookDAO {
    private SessionFactory sessionFactory;
    private Session session;
    private ArrayList<Book> books;
    private String hql="";
    private int pageSize=20;
    private int lastPage=1;
    private Query query;
    private Book book;
    private int result=0;
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
	public ArrayList<Book> get(int page) {
		hql="from Book";
		query=getSession().createQuery(hql);
		lastPage=getLastPage(query.list().size());
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		books=(ArrayList<Book>)query.list();
		return books;
	}
	private int getLastPage(int total) {
		if(total<=0){
			return 1;
		}
		if(total%pageSize==0)
			lastPage=total/pageSize;
		else
			lastPage=total/pageSize+1;
		return lastPage;
	}
	 public Book getById(int id){
  	   session=getSession();
  	   book=(Book)session.get(Book.class,id);
  	   closeSession();
  	   return book;	   
     }
	 private void closeSession(){
   	  if(session!=null){
   		  session.close();
   	  }
   	  session=null;
     }  
	 public int update(Book book){
	    	int result=0;
	    	session=getSession();
	    	Transaction tx=session.beginTransaction();
	    	try{
	    		session.update(book);
	    		tx.commit();
	    		result=1;
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		tx.rollback();
	    	}finally{
	    		closeSession();
	    	}
	    	return result;
	    }
	    public int delete(Book book){
	    	int result=0;
	    	session=getSession();
	    	Transaction tx=session.beginTransaction();
	    	try{
	    		session.delete(book);
	    		tx.commit();
	    		result=1;
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		tx.rollback();
	    	}finally{
	    		closeSession();
	    	}
	    	return result;
	    }
	    public int add(Book book){
	    	   session=getSession();
	    	   Transaction tx=session.beginTransaction();
	    	   try{
	    		   result=(int)session.save(book);
	    		   tx.commit();
	    	   }catch(Exception e){
	    		   e.printStackTrace();
	    		   tx.rollback();
	    	   }finally 
	    	   {
	    		   closeSession();
	    	   }
	    	   return result;
	       }
}
