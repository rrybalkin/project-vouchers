package com.rrybalkin.hibernate.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Visitors")
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="visitor_id")
	private Long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="description")
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="association", referencedColumnName="association_id")
	private Association association;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name="visitor_talon", joinColumns = @JoinColumn(name="visitor_id"), inverseJoinColumns = @JoinColumn(name = "talon_id"))
	private Talon talon;

	public Talon getTalon() {
		return talon;
	}

	public void setTalon(Talon talon) {
		this.talon = talon;
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
	public String getMiddleName() {
		return middleName != null ? middleName : "";
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFIO() {
		return getLastName() + " " + getFirstName() + " " + getMiddleName();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Visitor) {
			Visitor that = (Visitor) o;
			return Objects.equals(this.id, that.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (association != null ? association.hashCode() : 0);
		result = 31 * result + (talon != null ? talon.hashCode() : 0);
		return result;
	}

	@Override
    public String toString() {
       return getFIO();
    }
}
