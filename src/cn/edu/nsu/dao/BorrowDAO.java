package cn.edu.nsu.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import cn.edu.nsu.bean.*;


public class BorrowDAO {

	private SessionFactory sessionFactory;
	private Session session;
	private Query query;
	private String hql;
	private List<Borrow> borrows;
	private Book book;
	private User user;
	private Borrow borrow;
	private BorrowHistory bh;
	private Archive arch;
	public int result;
	public int borrowedbooks = 0;
	
	public int getBorrowedbooks(int userId) {
		
		String hql = "from Borrow where userid =?";
		query = getSession().createQuery(hql);
		query.setParameter(0, userId);
		borrows = query.list();
		 
		 borrowedbooks = 0;
		 
		 for(int i=0; i<borrows.size(); i++){
			 
			 if(borrows.get(i).getReturned() == 0){
				 
				 borrowedbooks++;
			 }
		 }
		 
		return borrowedbooks;
}

	public int getBorrowedbooks() {
		return borrowedbooks;
	}

	public void setBorrowedbooks(int borrowedbooks) {
		this.borrowedbooks = borrowedbooks;
	}

	public Book getBook() {
		if(book == null){
			book = new Book();
		}
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		if(user == null){
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		if(session==null || !session.isOpen())
			session = sessionFactory.openSession();
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	private void closeSession(){
		if(session!=null)
	    	 session.close();
	     session = null;
	}
	
	public int increaseBorrowCounts(Book book){
		
		int x = book.getBorrowcounts()+1;
		book.setBorrowcounts(x);
		
		result = 0;
		session = getSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.update(book);
			tx.commit();
			result =1;
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			closeSession();
		}
		
		return result;
		
	}
	
	public int  decreaseBorrowCounts(Book book){
	    
		if(book.getBorrowcounts()> 0){
			
			int x = book.getBorrowcounts()-1;
			book.setBorrowcounts(x);
			
			result = 0;
			session = getSession();
			Transaction tx = session.beginTransaction();
			
			try{
				session.update(book);
				tx.commit();
				result =1;
				
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
			}finally{
				closeSession();
			}
			
			return result;
		}
		
		return 0;
	}
	
	public boolean ableToBorrow(int bookId){
		
		session = getSession();
		book = (Book) session.get(Book.class, bookId); 
		
		int available = book.getBookcounts();
		int borrowed = book.getBorrowcounts();
		
		if(borrowed<available){
			return true;
		}	    
		else
		return false;
	}
	
	
	//By now I use default userId, and bookId. 
	public int borrowBook(int bookId, int userId){
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		if(ableToBorrow(bookId))
		{
			
				borrow = new Borrow(bookId, userId, timeStamp, 0);
				
				session = getSession();
				
				Transaction tx = session.beginTransaction();
				
				try{
					
					result = (int) session.save(borrow);
					tx.commit();
					result = increaseBorrowCounts(book); 
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}finally{
					closeSession();
				}
				
				return result;
				
		}else 
			return 0;
	}
	
	public List<Borrow> getRow(int bookId , int userId){
		
		String hql = "from Borrow where bookid =? and userid=? and returned=?";
		query = getSession().createQuery(hql);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		query.setParameter(2, 0);
		borrows = query.list();
		
		closeSession();
		return borrows;
	}
	
	
	public int returnBook(int bookId, int userId){
		  
		//System.out.print("bookId: "+ bookId+" userId: "+userId);
		borrow = getRow(bookId,userId).get(0);
		
		if(borrow == null){
		     	System.out.println("No Book found!!!");
			  return 0;
		  }
		
		borrow.setReturned(1);
		//System.out.print(borrow.getReturned());
		
        session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		result = 0;
		
		try{
			
			session.update(borrow);
			tx.commit();
			result = decreaseBorrowCounts(book);
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			closeSession();
		}
		
		return result;
		
	}
	
	
	public List<Archive> getAll(){
		
		hql = "from Borrow";
		query = getSession().createQuery(hql);
		borrows = query.list();
		session.close();
		session = null;
		
		Book bk;
		List<Archive> arr = new ArrayList<Archive>() ;
		String bookname, borrowtime, status, borrower; 
		int s;
		
		for(int i=0; i<borrows.size(); i++ )
		{
			borrow = borrows.get(i);
			bk = getBook(borrow.getBookid());
			user = getUser(borrow.getUserid());
		     
			if( bk == null || user == null){
				continue;
			}else{
				
				borrower = user.getName();
				bookname = bk.getBookname();
				borrowtime = borrow.getBorrowtime();
				s = borrow.getReturned();
				if(s==0){
					setBorrowedbooks(borrowedbooks++);
					status = "Not Returned";
					}
				else if(s == 1)
					status = "Returned";
				else 
					status = "Unknown";
				
				//System.out.print(" "+(i+1)+ " "+bookname+" "+ borrower+" "+ borrowtime+" " +status);
				arch = new Archive((i+1),bookname, borrower, borrowtime, status);
				
				arr.add(arch);				
			}
		}
		
		return arr;
	}
	
	
	
	public Book getBook(int k){
		
		session = getSession();
		book = (Book) session.get(Book.class, k); 
		closeSession();
		
		return book;
	}
	
	public User getUser(int k){
		session = getSession();
		user = (User) session.get(User.class, k);
		closeSession();
		
		return user;
		
	}
	
	
	public List<BorrowHistory> mybooks (int userId){
		
		String hql = "from Borrow where userid =?";
		query = getSession().createQuery(hql);
		query.setParameter(0, userId);
		borrows = query.list();
		
		List<BorrowHistory> bhs = new ArrayList<BorrowHistory>() ;
		Borrow br ;
		Book bk;
	    String cover;
	    String bookname;
		String bookauthor;
		String borrowtime;
		String status;
		int bookId;
		
		int s;
		
		for(int i=0; i<borrows.size(); i++ )
		{
			br = borrows.get(i);
			bk = getBook(br.getBookid());
			
			if( bk == null){
				continue;
			}
			else{
				bookId = br.getBookid();
				cover = bk.getCover();
				bookname = bk.getBookname();
				bookauthor = bk.getAuthor();
				borrowtime = br.getBorrowtime();
				s = br.getReturned();
				if(s==0){
					setBorrowedbooks(borrowedbooks++);
					status = "Not Returned";
					}
				else if(s == 1)
					status = "Returned";
				else 
					status = "Unknown";
				
				bh = new BorrowHistory(bookId,cover, bookname, bookauthor, borrowtime, status);
				
				bhs.add(bh);				
			}
			
		}
		
		return bhs; 
		
	}
	
}
