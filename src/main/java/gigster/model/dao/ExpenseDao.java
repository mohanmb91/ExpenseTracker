package gigster.model.dao;

import java.util.List;

import gigster.model.*;

public interface ExpenseDao {

	Expense saveExpense(Expense expense);
	void removeExpense(Integer id);
	 Expense getExpense( Integer id );
}
