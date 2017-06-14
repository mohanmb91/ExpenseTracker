package helper;

import java.util.Comparator;

import gigster.model.Expense;

public class Checker implements Comparator<Expense>{
		@Override
		public int compare(Expense o1, Expense o2) {
			 if (o1.getTransactionTime().getTime() < o2.getTransactionTime().getTime())
		            return -1;
		        else if (o1.getTransactionTime().getTime() == o2.getTransactionTime().getTime())
		            return 0;
		        else
		            return 1;
		}
}