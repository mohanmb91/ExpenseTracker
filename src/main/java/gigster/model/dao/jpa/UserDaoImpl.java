package gigster.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gigster.model.*;
import gigster.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser( Integer id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

    @Override
	public UserRole getUserRoleByName(String role) {
    	 return entityManager.createQuery( "from UserRole where role like "+role, UserRole.class ).getSingleResult();
		            
	}

    @Override
	public UserRole getUserRoleById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(UserRole.class,id );
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return entityManager.merge(user);
	}
}
    
    