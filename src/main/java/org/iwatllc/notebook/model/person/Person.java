package org.iwatllc.notebook.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLASSIFICATION_ID", nullable = false)
	private PersonClassification classification;

	protected Person() { }
	
	public Person(String firstName, String lastName, PersonClassification classification) {
		setFirstName(firstName);
		setLastName(lastName);
		setClassification(classification);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public PersonClassification getClassification() {
		return classification;
	}

	public void setClassification(PersonClassification classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return String.format("Person[id=%d, firstName='%s', lastName='%s', classification='%s']", 
				getId(), getFirstName(), getLastName(), getClassification());
	}
}
