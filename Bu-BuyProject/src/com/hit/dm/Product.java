package com.hit.dm;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	int id;
	private String name;
	private String store;
	private String description;
	//Enum type

	public Product() {
	}

		public Product(int id, String name, String store, String description) {
		this.id = id;
		this.name = name;
		this.store = store;
		this.description = description;
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
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", store=" + store + ", description=" + description +"]";
	}
	


}
