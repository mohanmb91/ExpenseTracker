package gigster.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import gigster.model.Expense;
import gigster.model.User;
import gigster.model.UserRole;
import gigster.model.dao.ExpenseDao;
import gigster.model.dao.UserDao;

@Controller
@SessionAttributes({"user"})
public class ExpenseController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ExpenseDao expenseDao;
	@RequestMapping(value = "/user/addNewExpense.html", method = RequestMethod.GET)
	public String studentHomeGet(@RequestParam Integer userId, ModelMap models) {
		
		models.put("userId", userId);
		models.put("expense", new Expense());
		
		return "/user/AddExpense";
	}

	
	@RequestMapping(value = "/user/addNewExpense.html", method = RequestMethod.POST)
	public String studentHomePost(HttpServletRequest request, @RequestParam Integer userId, ModelMap models,@ModelAttribute Expense expense) {
		String startDateString = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate = null;
		try {
		    startDate = df.parse(startDateString);
		    String newDateString = df.format(startDate);
		    System.out.println(newDateString);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		expense.setTransactionTime(startDate);
		
		User user = userDao.getUser(userId);
		expense = expenseDao.saveExpense(expense);
		List<Expense> expenses = user.getTransactions();
		expenses.add(expense);
		user.setTransactions(expenses);
		
		userDao.saveUser(user);
		
		return "redirect:/user/userHome.html?userId="+user.getId();
	}
	
	@RequestMapping(value = "/user/DeleteExpense.html", method = RequestMethod.GET)
	public String DeleteExpense(@RequestParam Integer expenseId,@RequestParam Integer userId, HttpServletRequest request, ModelMap models) {
		Expense expense = expenseDao.getExpense(expenseId);
		User user= userDao.getUser(userId);
		user.getTransactions().remove(expense);
		userDao.saveUser(user);
		expenseDao.removeExpense(expenseId);
		
		return "redirect:/user/userHome.html?userId="+userId;
	}
	
	@RequestMapping(value = "/user/ModifyExpense.html", method = RequestMethod.GET)
	public String modifyExpenseGet(@RequestParam Integer userId,@RequestParam Integer expenseId, ModelMap models) {
		
		models.put("userId", userId);
		Expense exp = expenseDao.getExpense(expenseId);
		
		models.put("expense", exp);
		
		return "/user/ModifyExpense";
	}

	
	@RequestMapping(value = "/user/ModifyExpense.html", method = RequestMethod.POST)
	public String ModifyExpensePost(HttpServletRequest request, @RequestParam Integer userId,@RequestParam Integer expenseId, ModelMap models,@ModelAttribute Expense expense) {
		String startDateString = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate = null;
		try {
		    startDate = df.parse(startDateString);
		    String newDateString = df.format(startDate);
		    System.out.println(newDateString);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		expense.setTransactionTime(startDate);
		
		User user = userDao.getUser(userId);
		Expense oldExpense = expenseDao.getExpense(expenseId);
		oldExpense.setAmount(expense.getAmount());
		oldExpense.setDescription(expense.getDescription());
		oldExpense.setTransactionTime(expense.getTransactionTime());
		expense = expenseDao.saveExpense(oldExpense);
		
		
		return "redirect:/user/userHome.html?userId="+user.getId();
	}
}
