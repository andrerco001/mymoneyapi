package com.cadmoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "releases")
public class Release 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	private String description;
	
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	@Column(name = "pay_day")
	private LocalDate payday;
	
	private BigDecimal value;
	
	private String note;
	
	@Enumerated(EnumType.STRING)
	private TypeReleases type;
	
	@ManyToOne
	@JoinColumn(name = "code_category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "code_person")
	private Person person;

	public Long getCode() 
	{
		return code;
	}

	public void setCode(Long code) 
	{
		this.code = code;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public LocalDate getDueDate() 
	{
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) 
	{
		this.dueDate = dueDate;
	}

	public LocalDate getPayday() 
	{
		return payday;
	}

	public void setPayday(LocalDate payday) 
	{
		this.payday = payday;
	}

	public BigDecimal getValue() 
	{
		return value;
	}

	public void setValue(BigDecimal value) 
	{
		this.value = value;
	}

	public String getNote() 
	{
		return note;
	}

	public void setNote(String note) 
	{
		this.note = note;
	}

	public TypeReleases getType() 
	{
		return type;
	}

	public void setType(TypeReleases type) 
	{
		this.type = type;
	}

	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
	}

	public Person getPerson() 
	{
		return person;
	}

	public void setPerson(Person person) 
	{
		this.person = person;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Release other = (Release) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
}