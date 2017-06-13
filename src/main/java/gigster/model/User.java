package gigster.model;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String firstName;
    @Column(name="last_name")
    private String lastName;
    

	@Column(name="email_id")
    private String emailId;
	
    private String password;
    
    
    @ManyToOne
    private UserRole userRole;
    
    @OneToMany
    private List<Expense> transactions;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Expense> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Expense> transactions) {
		this.transactions = transactions;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

    
}
