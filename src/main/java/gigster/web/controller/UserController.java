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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gigster.model.User;
import gigster.model.UserRole;
import gigster.model.dao.UserDao;

@Controller
@SessionAttributes({"user"})
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/user/userHome.html", method = RequestMethod.GET)
	public String studentHomeGet(@RequestParam Integer userId, ModelMap models) {
		
		User user = userDao.getUser(userId);
		models.put("user", user);
		
		return "/user/UserHome";
	}
	
}
