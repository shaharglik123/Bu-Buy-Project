package com.hit.service;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.hit.algorithm.StringMatchingAlgorithmTest;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.Customer;
import com.hit.dm.Product;


public class BuBuyService {
	
	Scanner scanner=new Scanner(System.in);
	
	//attribute
	String datasource="resources/data source.txt";
	static StringMatchingAlgorithmTest alg_member;
	IDao idao;
	
	//Singleton instance
	private static BuBuyService single_instance=null;
	//Contractor
	private BuBuyService(StringMatchingAlgorithmTest alg){
		alg_member=alg;
		idao=new DaoFileImpl(datasource);
		//from Exem
	}
	//instance
	public static BuBuyService getinstance(StringMatchingAlgorithmTest algorithm) {
		if(single_instance == null)
			single_instance=new BuBuyService(algorithm);
		return single_instance;
	}
	/////
	
	
	/*Logical methods*/
	public void createfile() {
		idao.createfile(datasource);
	}
	public void add_customer()throws ClassNotFoundException, IOException {
		idao.add_customer();
	}
	public void add_customer(Customer customer)throws ClassNotFoundException, IOException {
		if(!idao.cheacking_customer_id_exist(customer.getId()))
		idao.add_customer(customer);
		else
			System.out.println("Customer allrady exist");
	}
	public void add_product()throws ClassNotFoundException, IOException {
		idao.add_product();
	}
	public void add_product(Product product)throws ClassNotFoundException, IOException {
		if(!idao.cheacking_product_id_exist(product.getId())) 
		idao.add_product(product);
		else
		System.out.println("Product allrady exist");
	}
	
	public boolean Login(int id,String pass) throws ClassNotFoundException, IOException {
		return idao.Login(id,pass)?true:false;
	}
	
	public void remove_customer(int id) throws ClassNotFoundException, IOException {
		idao.remove_customer(id);
	}
	public void remove_product(int id) throws ClassNotFoundException, IOException {
		idao.remove_product(id);
	}
	
	public Customer get_customer(int id) throws ClassNotFoundException, IOException {
		return idao.get_customer(id);
	}
	public Product get_product(int id) throws ClassNotFoundException, IOException {
		return idao.get_product(id);
	}
	public List<Product> getallproducts() throws ClassNotFoundException, IOException {
		return idao.get_products();
	}
	public List<Customer> getallcustomers() throws ClassNotFoundException, IOException {
		return idao.get_customers();
	}
	public void update_customer(Customer customer) throws ClassNotFoundException, IOException {
		idao.update_customer(customer);
	}
	public void update_product(Product product) throws ClassNotFoundException, IOException  {
		idao.update_product(product);
	}
	public boolean cheacking_customer_id_exist(int id) throws ClassNotFoundException, IOException  {
		return idao.cheacking_customer_id_exist(id);
	}
	public boolean cheacking_product_id_exist(int id) throws ClassNotFoundException, IOException {
		return idao.cheacking_product_id_exist(id);
	}
	public List<Customer> searchCustomerByName(String name)throws ClassNotFoundException, IOException {
		return idao.searchCustomerByName(name);
	}
	public List<Product> searchProductByName(String name)throws ClassNotFoundException, IOException {
		return idao.searchProductByName(name);
	}
	public List<Product> searchProductByDescription(String description)throws ClassNotFoundException, IOException {
		return idao.searchProductByDescription(description);
	}
	public void purchase(Customer customer) throws ClassNotFoundException, IOException {
		idao.purchaseItem(customer);
	}
	
	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
	
}
