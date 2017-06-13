package gigster.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "expenses")

public class Expense {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "transactionTime", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionTime;
	
	@Column(name="description")
    private String description;
	
	@Column(name="amount")
	private BigDecimal amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
