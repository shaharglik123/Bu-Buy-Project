package com.hit.dm;

import java.io.Serializable;
import java.util.List;


public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int id;
	private String password;
	private String firstname;
	private String lastname;
	private int age;
	private String country;
	private List<Product> products_own;
	private int nums_of_visits;
	
	public Customer() {
	} 
	
	public Customer(int id, String password, String firstname, String lastname, int age, String country,
			List<Product> products_own, int nums_of_visits) {
		this.id = id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.country = country;
		this.products_own = products_own;
		this.nums_of_visits = nums_of_visits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Product> getProducts_own() {
		return products_own;
	}

	public void setProducts_own(List<Product> products_own) {
		this.products_own = products_own;
	}

	public int getNums_of_visits() {
		return nums_of_visits;
	}

	public void setNums_of_visits(int nums_of_visits) {
		this.nums_of_visits = nums_of_visits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", country=" + country + ", products_own=" + products_own + ", nums_of_visits="
				+ nums_of_visits + "]";
	}
	
	

	
}
