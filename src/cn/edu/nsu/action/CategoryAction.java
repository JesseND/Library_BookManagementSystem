package cn.edu.nsu.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.Category;
import cn.edu.nsu.dao.CategoryDAO;

public class CategoryAction extends ActionSupport{
	 private ArrayList<Category> categories;
	   private CategoryDAO categoryDAO;
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	public CategoryDAO getCategoryDAO() {
		if(categoryDAO==null)
			categoryDAO = new CategoryDAO();
		return categoryDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		categories = getCategoryDAO().getAllCat();
		System.out.println(categories.size());
		return SUCCESS;
	}
	   
	   
}
