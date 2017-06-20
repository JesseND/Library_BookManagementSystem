package cn.edu.nsu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nsu.bean.User;
import cn.edu.nsu.dao.UserDAO;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> Users;
	private UserDAO userDAO;
	private String msg = "";
	private int userId = 0;
	private String username;
	private String pwd;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return Users;
	}
	public void setUsers(List<User> users) {
		Users = users;
	}
	public UserDAO getUserDAO() {
		if(userDAO == null){
			userDAO = new UserDAO();
		}
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public HttpSession getSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		return session;
	}
	
	public String execute() throws Exception{
		Object obj = getSession().getAttribute("userId");
		 if(obj == null)
			 setUserId(0);
		 else
		     setUserId((int) obj);
		return SUCCESS;
	} 
	
	public String register() throws Exception{
		int result = getUserDAO().add(user);
		if(result > 0)
			msg += "You have created an account successfully";
		else
			msg += "Something went wrong! Please try again";
		return "register";
	}
	
	
	public String login() throws Exception{
		
		userId  = getUserDAO().login(username, pwd);
		status="logged";
		getSession().setAttribute("name", username);
		getSession().setAttribute("userId", userId);
		getSession().setAttribute("status", status);
		
	    if(userId == 1)
			return "adLog";
		else if(userId == 0) 
			return "login";
		else
		return "log";
	}
	
	
	public String logout() throws Exception{
		
		setUserId(0);
		getSession().setAttribute("userId", 0);
		status="no";
		getSession().setAttribute("status", status);
		return "logout";
	}
	
}
