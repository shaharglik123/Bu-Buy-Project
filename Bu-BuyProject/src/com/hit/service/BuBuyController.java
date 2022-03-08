package com.hit.service;

import java.io.IOException;
import java.util.List;

import com.hit.algorithm.StringMatchingAlgorithmTest;
import com.hit.dm.Customer;
import com.hit.dm.Product;

public class BuBuyController{
	
	StringMatchingAlgorithmTest alg=new StringMatchingAlgorithmTest();
	BuBuyService service=BuBuyService.getinstance(alg);
	
	public BuBuyController() {
	}
	
	public void purchaseItem(Customer customer) throws ClassNotFoundException, IOException {
		service.purchase(customer);
	}
	public void createCustomer(Customer customer) throws ClassNotFoundException, IOException {
		service.add_customer(customer);
		//UI function call
	}

	public void createProduct(Product product)  throws ClassNotFoundException, IOException{
		service.add_product(product);
		//UI function call
	}

	public void removeCustomer(int id) throws ClassNotFoundException, IOException {
		service.remove_customer(id);;
		//UI function call
	}

	public void removeProduct(int id ) throws ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		service.remove_product(id);
		//UI function call
		
	}

	public boolean Login(int id,String pass) throws ClassNotFoundException, IOException {
		return service.Login(id,pass) ?true:false;
		//UI function call
	}
	
	public Customer getCustomer (int id) throws ClassNotFoundException, IOException {
		return service.get_customer(id);
		//UI function call
	}
	public Product getProduct (int id) throws ClassNotFoundException, IOException {
		return service.get_product(id);
		//UI function call
	}
public List<Customer> getallcustomers() throws ClassNotFoundException, IOException {
		return service.getallcustomers();
		//UI function call
	}

	public List<Product> getallproducts() throws ClassNotFoundException, IOException {
		return service.getallproducts();
		//UI function call
	}

	public List<Customer> searchCustomerByName(String name )  throws ClassNotFoundException, IOException{
		return service.searchCustomerByName(name);
		//UI function call
	}

	public List<Product> searchProductrByName(String name)  throws ClassNotFoundException, IOException{
		return service.searchProductByName(name);
		//UI function call
	}

	public List<Product> searchProductrByDescription(String description)  throws ClassNotFoundException, IOException{
		return service.searchProductByDescription(description);
		//UI function call
	}

	public void updateCustomer(Customer customer) throws ClassNotFoundException, IOException {
		service.update_customer(customer);
	}
	
	public void updateProduct(Product product) throws ClassNotFoundException, IOException {
		service.update_product(product);
	}
		
	}

