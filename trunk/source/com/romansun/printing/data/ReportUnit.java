package com.romansun.printing.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class ReportUnit {
	@Alias(name="�")
	protected int num;
	@Alias(name="���")
	protected String visitorFirstname;
	@Alias(name="�������")
	protected String visitorLastname;
	@Alias(name="��������")
	protected String visitorMiddlename;
	@Alias(name="������")
	protected String visitorGroupName;
	@Alias(name="����������� ������")
	protected int countOfLunches;
	@Alias(name="����������� ������")
	protected int countOfDinners;
	@Alias(name="��������� ������")
	protected double costOfLunches;
	@Alias(name="��������� ������")
	protected double costOfDinners;
	@Alias(name="����� ���������")
	protected double generalCost;
	
	public int getNumber() {
		return num;
	}
	public void setNumber(int num) {
		this.num = num;
	}
	public String getVisitorFirstname() {
		return visitorFirstname;
	}
	public void setVisitorFirstname(String visitorFirstname) {
		this.visitorFirstname = visitorFirstname;
	}
	public String getVisitorLastname() {
		return visitorLastname;
	}
	public void setVisitorLastname(String visitorLastname) {
		this.visitorLastname = visitorLastname;
	}
	public String getVisitorMiddlename() {
		return visitorMiddlename;
	}
	public void setVisitorMiddlename(String visitorMiddlename) {
		this.visitorMiddlename = visitorMiddlename;
	}
	public String getVisitorGroupName() {
		return visitorGroupName;
	}
	public void setVisitorGroupName(String visitorGroupName) {
		this.visitorGroupName = visitorGroupName;
	}
	public int getCountOfLunches() {
		return countOfLunches;
	}
	public void setCountOfLunches(int countOfLunches) {
		this.countOfLunches = countOfLunches;
	}
	public int getCountOfDinners() {
		return countOfDinners;
	}
	public void setCountOfDinners(int countOfDinners) {
		this.countOfDinners = countOfDinners;
	}
	public double getCostOfLunches() {
		return costOfLunches;
	}
	public void setCostOfLunches(double costOfLunches) {
		this.costOfLunches = costOfLunches;
	}
	public double getCostOfDinners() {
		return costOfDinners;
	}
	public void setCostOfDinners(double costOfDinners) {
		this.costOfDinners = costOfDinners;
	}
	public double getGeneralCost() {
		return generalCost;
	}
	public void setGeneralCost(double generalCost) {
		this.generalCost = generalCost;
	}
	
	/**
	 * Method for getting property of report unit by property name
	 * @param pName property name
	 * @return value of property or null if property with this name doesn't exist
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object getPropertyByName(String pName) throws IllegalArgumentException, IllegalAccessException {
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String alias = field.getAnnotation(Alias.class).name();
			
			if (alias.equals(pName)) {
				return field.get(this);
			}
		}
		
		return null;
	}
	
	@Target(value=ElementType.FIELD)
	@Retention(value= RetentionPolicy.RUNTIME)
	public @interface Alias {
		String name();
	}
}
