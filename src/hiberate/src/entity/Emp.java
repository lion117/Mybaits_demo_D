package entity;

import java.math.BigDecimal;

public class Emp {

	private int id; // ID
	private String name; // ÐÕÃû
	private BigDecimal salary; // Ð½×Ê
	private int age; // ÄêÁä

	public Emp() {   

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setname(String ename) {
		this.name = ename;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Emp [age=" + age + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
}
