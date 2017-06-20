package cn.edu.nsu.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session  = request.getSession();
		Object obj = session.getAttribute("userId");
		
		if(obj==null) {
			return "login";
		}
		String myuser = obj.toString();
		if(myuser.equals("")) {
			return "login";
		}
		
		String result = arg0.invoke();
		return result;
	}
	
	

}
