package cn.edu.nsu.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.nsu.bean.Book;
import cn.edu.nsu.bean.Category;

public class CategoryDAO {

	private SessionFactory sessionFactory;
    private Session session;
    private ArrayList<Category> categories;
    private String hql="";
    private Query query;
    private Category category;
    
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
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public ArrayList<Category> getAllCat(){
		hql= "  from Category where code in (select category from Book)";
		query = getSession().createQuery(hql);
		categories = (ArrayList<Category>)query.list();
		return categories;
	}
	
	public Category getCatName(int id) {
		hql= "from Category where code="+id+"";
		query = getSession().createQuery(hql);
		category = (Category)query.list().get(0);
		return category;
	}
    
}
