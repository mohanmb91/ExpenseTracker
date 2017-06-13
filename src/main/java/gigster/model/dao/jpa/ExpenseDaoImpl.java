package gigster.model.dao.jpa;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gigster.model.*;
import gigster.model.dao.ExpenseDao;


@Repository
public class ExpenseDaoImpl implements ExpenseDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Expense getExpense( Integer id )
    {
        return entityManager.find( Expense.class, id );
    }
	@Override
	@Transactional
	public Expense saveExpense(Expense expense) {
		// TODO Auto-generated method stub
		return entityManager.merge(expense);
	}

	@Override
	@Transactional
	public void removeExpense(Integer id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(Expense.class, id));
	}
	
}
    
    