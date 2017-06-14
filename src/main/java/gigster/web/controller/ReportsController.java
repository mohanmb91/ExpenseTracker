package gigster.web.controller;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gigster.model.Expense;
import gigster.model.User;
import gigster.model.dao.UserDao;
import helper.Checker;
import helper.GeneratePdfInRange;
import helper.GeneratePdfReport;
import helper.WeekReport;


@Controller
public class ReportsController  {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value = "/user/reportsWeekly.html", method = RequestMethod.GET)
	public ModelAndView generateReport(HttpServletRequest request, @RequestParam int userId, HttpSession session, ModelMap models) {
		User user = userDao.getUser(userId);
		List<Expense> transactions = user.getTransactions();
		Collections.sort(transactions,new Checker());
		WeekReport weekReport = new WeekReport();
		List<WeekReport> weeklyReports= new ArrayList<>();
		for(Expense eachExpense: transactions){
			if(weekReport.startDate == null){
				weekReport = addExpenseToWeek(eachExpense, weekReport);
			}
			else if(eachExpense.getTransactionTime().after(weekReport.startDate) && eachExpense.getTransactionTime().before(weekReport.endDate)){
				weekReport.totalWeekExpense.add(eachExpense.getAmount());//addExpenseToWeek(eachExpense, weekReport);
			}else{
				weeklyReports.add(weekReport);
				weekReport = new WeekReport();
				weekReport = addExpenseToWeek(eachExpense, weekReport);
				
			}
		}
		weeklyReports.add(weekReport);
		return new ModelAndView(new GeneratePdfReport(),"weeklyReports",weeklyReports);
	}
	
	@RequestMapping(value = "/user/reportsDateRange.html", method = RequestMethod.GET)
	public String generateReportWithinRange(@RequestParam int userId, ModelMap models){
		models.put("userId", userId);
		return "report/ExpenseReportsInRange";
	}
	@RequestMapping(value = "/user/reportsDateRange.html", method = RequestMethod.POST)
	public ModelAndView generateReportWithinRange(HttpServletRequest request, @RequestParam int userId, HttpSession session, ModelMap models) {
		User user = userDao.getUser(userId);
		List<Expense> transactions = user.getTransactions();
		List<Expense> results = new ArrayList<>();
		String startDateStr = request.getParameter("dateStart");
		String endDateStr = request.getParameter("dateEnd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate = null,endDate = null;
		try {
		    startDate = df.parse(startDateStr);
		    endDate = df.parse(endDateStr);
		    for(Expense eachExpense: transactions){
		    	if(eachExpense.getTransactionTime().after(startDate) && eachExpense.getTransactionTime().before(endDate)){
		    		results.add(eachExpense);
		    	}
		    }
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		return new ModelAndView(new GeneratePdfInRange(),"reportsInRange",results);
	}
	public static WeekReport addExpenseToWeek(Expense eachExpense,WeekReport weekReport){
		weekReport.startDate = eachExpense.getTransactionTime();
		Calendar c = Calendar.getInstance();    
		c.setTime(weekReport.startDate);
		c.add(Calendar.DAY_OF_YEAR, 7);
		weekReport.endDate = c.getTime();
		weekReport.expenses.add(eachExpense);
		weekReport.totalWeekExpense = weekReport.totalWeekExpense.add(eachExpense.getAmount());

		return weekReport;
	}
	
	
}
