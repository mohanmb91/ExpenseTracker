package gigster.web.controller;
import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import gigster.model.User;
import gigster.model.UserRole;
import gigster.model.dao.UserDao;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login()
	{
		return "Login";
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, HttpSession session, ModelMap models) {
		List<User> users =  userDao.getUsers(); 
		User user =null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		for(User eachUser : users){
			if(eachUser.getEmailId().equalsIgnoreCase(email) && eachUser.getPassword().equals(password)){
				user = eachUser;
				if (user.getUserRole().getId()== 2){
					return "redirect:/admin.html";
				}
				else if(user.getUserRole().getId()== 1){
					return "redirect:/user/userHome.html?userId="+user.getId();
				}
				break;
			}
		}
		models.put("error", "yes");
		return "Login";
	}
	
	@RequestMapping(value = "/Register.html", method = RequestMethod.GET)
	public String Register(HttpServletRequest request, ModelMap models)
	{
		models.put("user", new User() );
		
		return "Register";
	}
	
	@RequestMapping(value = "/Register.html", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request,@ModelAttribute User user, ModelMap models) {
		
		UserRole userRole = new UserRole();

		List<User> users = userDao.getUsers();
		String error = "no";
		for (User eachUser : users) {
			if(eachUser.getEmailId().equalsIgnoreCase(user.getEmailId())){
				error = "yes";
				models.put("error", error);
				return "Register";
			}
		}
		models.put("error", error);
		userRole = userDao.getUserRoleById(1);
		
		
		user.setUserRole(userRole);
		
		user = userDao.saveUser(user);
	
		return "redirect:/login.html";
	}
	
	@RequestMapping("/logout.html")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.invalidate();
		return "redirect:/login.html";
	}

}
