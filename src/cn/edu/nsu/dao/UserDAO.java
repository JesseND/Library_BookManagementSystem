package cn.edu.nsu.dao;

import java.util.ArrayList;
import java.util.List;
import cn.edu.nsu.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class UserDAO {

	private SessionFactory sessionFactory;
	private Session session;
	private Query query;
	private List<User> users;
	
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
	
	
    public int  add(User user){
			int result = 0;
			session = getSession();
			Transaction tx = session.beginTransaction();
			try{
				result = (int) session.save(user);
				tx.commit();				
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
			}finally{
				closeSession();
			}
			
			return result;
	}

	public int login(String username, String pwd) {
		
		if(username==""&& pwd=="")
			return 2;
		User user;
		String hql = "from User where name =? and password=?";
		query = getSession().createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, pwd);
		users = query.list();
		closeSession();
		
		if(users == null || users.size()<1)
			return 0;
		else
			user = users.get(0);
			return user.getId();
	}

}
