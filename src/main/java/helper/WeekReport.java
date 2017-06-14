package helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gigster.model.Expense;

public class WeekReport{
	public Date startDate;
	public Date endDate;
	public List<Expense> expenses;
	public BigDecimal totalWeekExpense;
	public WeekReport(){
		expenses = new ArrayList<>();
		totalWeekExpense = new BigDecimal("0");
	}
}