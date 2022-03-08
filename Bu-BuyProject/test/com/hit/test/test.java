package com.hit.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.hit.algorithm.StringMatchingAlgorithmTest;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.Customer;
import com.hit.dm.Product;
import com.hit.service.BuBuyService;

public class test {
	
	static StringMatchingAlgorithmTest alg=new StringMatchingAlgorithmTest();
	static BuBuyService BuBuy=BuBuyService.getinstance(alg);
	static Scanner scanner=new Scanner(System.in);
	static Scanner scannerInt = new Scanner(System.in);
	static Scanner scannerString = new Scanner(System.in);
	
	public test() {
	}

	public static void addmethod() throws ClassNotFoundException, IOException {	
		System.out.println("Enter 1 if you want to add Customer,2 for Product");
		if(scanner.nextInt()==1)
		BuBuy.add_customer();
		else
		BuBuy.add_product();
	}
	public static void remove_file() {
		
		File f=new File("resources/data source.txt");
		if(f.delete()) 
		System.out.println("file deleted");
		else
			System.out.println("cannot delete file");
		}
	public static void remove_method() throws ClassNotFoundException, IOException {
		//int key;
//		StringMatchingAlgorithmTest alg=new StringMatchingAlgorithmTest();
//		BuBuyService BuBuy=BuBuyService.getinstance(alg);
		System.out.println("Enter 1 if you want to remove Customer,2 for Product");
		if(scanner.nextInt()==1) {
		System.out.println("Enter product id to delete");
		//Scanner scanner=new Scanner(System.in);
		BuBuy.remove_product(scanner.nextInt());
		}else {
		BuBuy.remove_customer(scanner.nextInt());
		//key=scanner.nextInt();
		//scanner.close();
		}
	}
	public static void update_method() throws ClassNotFoundException, IOException{
		int id;
		System.out.println("Enter 1 if you want to update Customer,2 for Product");
		if(scanner.nextInt()==1) {
		System.out.println("Enter customer with existing id and updated info to update customer");
		//temporary
		Customer customer=new Customer();
		
		//Scanner scanner = new Scanner(System.in);
		//Scanner scannerString = new Scanner(System.in);
		
	//	System.out.println("Enter id:");
		id=scannerInt.nextInt();
		if(BuBuy.cheacking_customer_id_exist(id)) {
		
		//customer.setId(scannerInt.nextInt());
		customer.setId(id);
		System.out.println("Enter name:");
		customer.setFirstname(scannerString.nextLine());
		System.out.println("Enter Lastname:");
		customer.setLastname(scannerString.nextLine());
		System.out.println("Enter age:");
		customer.setAge(scannerInt.nextInt());
		System.out.println("Enter Country:");
		customer.setCountry(scannerString.nextLine());
		customer.setProducts_own(null);
		customer.setNums_of_visits(1);
		//scanner prob
		//scannerInt.close();
		//scannerString.close();
		BuBuy.update_customer(customer);
	}else
		System.out.println("the customer with id :"+id+"doesnt exists");
		}else {
		//temporary
				Product product=new Product();
				System.out.println("Enter product with existing id and updated info to update product");
				id=scannerInt.nextInt();
				if(BuBuy.cheacking_product_id_exist(id)) {
				//System.out.println("Enter id:");
				product.setId(id);
				System.out.println("Enter product name:");
				product.setName(scannerString.nextLine());
				System.out.println("Enter store:");
				product.setStore(scannerString.nextLine());
			//scanner prob
				//scannerInt.close();
				//scannerString.close();
				BuBuy.update_product(product);
	}else
		System.out.println("product with id :"+id+"doesnt exist");
	}
	}
	public static void searchCustomersByName() throws ClassNotFoundException, IOException {
		System.out.println("Enter Customer name that you want search");
		String name=scannerString.nextLine();
		System.out.println(BuBuy.searchCustomerByName(name));
	}
	public static void searchProductsByName() throws ClassNotFoundException, IOException {
		System.out.println("Enter Product name that you want search");
		String name=scannerString.nextLine();
		System.out.println(BuBuy.searchCustomerByName(name));
	}
	public static void searchProductsByDescription() throws ClassNotFoundException, IOException {
		System.out.println("Enter Product Description that you want search");
		String name=scannerString.nextLine();
		System.out.println(BuBuy.searchCustomerByName(name));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
	
	boolean temp=true;
	int key = 0;
	while(temp) {
		System.out.println("Enter function number and -1 to exit");
		//no need
		scanner=new Scanner(System.in);
		key=scanner.nextInt();
	switch (key) {
	case 1:{
		remove_file();	
		break;
	}
	case 2: {
		BuBuy.createfile();
		break;
	}
	case 3:{
		addmethod();
		break;
	}
	case 4:{
		System.out.println(BuBuy.getallcustomers());
		break;
	}
	case 5:{
		System.out.println(BuBuy.getallproducts());
		break;
	}
	case 6:{
		update_method();
		break;
	}
	case 7:{
		remove_method();	
		break;
	}
	case 8:{
		searchCustomersByName();
	}
	case 9:{
		searchProductsByName();
	}
	case 10:{
		searchProductsByDescription();
	}
	case 11:{
		System.out.println("enter id :");
		int id=scannerInt.nextInt();
		System.out.println("enter password");
		String pass=scannerString.nextLine();
		IDao idao=new DaoFileImpl("resources/data source.txt");
		if(idao.Login(id,pass))
			System.out.println("User logged in");
		else
			System.out.println("user username or password is wrong try again");
		break;
	}
		
	case -1:{
		temp=false;
		break;
	}
	default:
		temp=true;
		System.out.println("try entring again");
	}
	}
}
	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		scanner.close();
		scannerInt.close();
		scannerString.close();
	}
	

}
