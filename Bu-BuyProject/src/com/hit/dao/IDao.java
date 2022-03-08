package com.hit.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.hit.dm.Customer;
import com.hit.dm.Product;


public interface IDao {
	public void createfile(String pathfile);
	public void add_customer()throws ClassNotFoundException, IOException;
	public void add_customer(Customer customer)throws ClassNotFoundException, IOException;
	public void add_product()throws ClassNotFoundException, IOException;
	public void add_product(Product product)throws ClassNotFoundException, IOException;
	public void remove_customer(int id)throws ClassNotFoundException, IOException;
	public void remove_product(int id)throws ClassNotFoundException, IOException;
	public Customer get_customer(int id)throws ClassNotFoundException, IOException;
	public Product get_product(int id)throws ClassNotFoundException, IOException;
	public List<Customer> get_customers()throws ClassNotFoundException, IOException;
	public List<Product> get_products()throws ClassNotFoundException, IOException;
	public void update_customer(Customer customer)throws ClassNotFoundException, IOException;
	public void update_product(Product product)throws ClassNotFoundException, IOException;
	public boolean cheacking_customer_id_exist(int id)throws ClassNotFoundException, IOException ;
	public boolean cheacking_product_id_exist(int id)throws ClassNotFoundException, IOException;
	public List<Customer> searchCustomerByName(String name)throws ClassNotFoundException, IOException;
	public List<Product> searchProductByName(String name)throws ClassNotFoundException, IOException;
	public List<Product> searchProductByDescription(String description)throws ClassNotFoundException, IOException;
	void remove_customer() throws ClassNotFoundException, FileNotFoundException, IOException;
	void remove_product() throws ClassNotFoundException, IOException;
	public boolean Login(int id, String pass)throws ClassNotFoundException, IOException;
	public void purchaseItem(Customer customer)throws ClassNotFoundException, IOException ;
}
