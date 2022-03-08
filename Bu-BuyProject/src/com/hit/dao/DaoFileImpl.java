package com.hit.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hit.algorithm.*;
import com.hit.dm.Customer;
import com.hit.dm.Product;

public class DaoFileImpl  implements IDao {

	List<Customer> customers;
	List<Product> products;
	List<Object> objects;
	
	FileOutputStream fos;
	FileInputStream fileIn;
	ObjectOutputStream oos;
	MyObjectOutputStream moos;
	ObjectInputStream objIn;

	Scanner scannerInt = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	File myfile;
	public DaoFileImpl(String pathfile)  {
		try {
			myfile = new File(pathfile);
			if (myfile.createNewFile()) {
				System.out.println("File created: " + myfile.getName());
			} else {
			//	System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	@Override
	public void createfile(String pathfile) {
	try {
		myfile = new File(pathfile);
		if (myfile.createNewFile()) {
			System.out.println("File created: " + myfile.getName());
		} else {
				System.out.println("File already exists.");
		}
	} catch (IOException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
	}
	
	public synchronized boolean Login(int id,String password) throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true;
		Object obj;
		//System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				System.out.println("The file is empty,there is no customers in it");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			objects.add(obj);
			}
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Customer) {
					if (id == ((Customer) objects.get(i)).getId()&& password.equals(((Customer) objects.get(i)).getPassword())) {
						return true;
					}
				}
				}
				return false;
	}
	/**
	 * add customer method for second part of the project
	 */
	@Override
	public synchronized void add_customer() throws ClassNotFoundException, IOException {
		boolean temp1=true,temp2=true;
		Customer customer = new Customer();
		customers = new ArrayList<Customer>();
		Object obj;
		int temp_id=0;
		System.out.println("Enter customer id:");
		fileIn = new FileInputStream("resources/data source.txt");
		fos=new FileOutputStream("resources/data source.txt",true);
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				temp_id = scannerInt.nextInt();
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			if (obj != null) {
				if (obj instanceof Customer) {
					customers.add((Customer) obj);
					}
				}
			}
		
		while(temp2) {
			temp_id = scannerInt.nextInt();
			temp2=false;
			for (Customer customer2 : customers) {
				if (temp_id == customer2.getId()) {
					temp2 = true;
					System.out.println("id allready exists ,try entreing new id again");
				}
			}
		}
		customer.setId(temp_id);
		System.out.println("Enter name:");
		customer.setFirstname(scannerString.nextLine());
		System.out.println("Enter password:");
		customer.setPassword(scannerString.nextLine());
		System.out.println("Enter Lastname:");
		customer.setLastname(scannerString.nextLine());
		System.out.println("Enter age:");
		customer.setAge(scannerInt.nextInt());
		System.out.println("Enter Country:");
		customer.setCountry(scannerString.nextLine());
		customer.setProducts_own(null);
		customer.setNums_of_visits(1);
		
			if(myfile.length()==0) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(customer);
		}else {
			moos = new MyObjectOutputStream(fos);
			moos.writeObject(customer);
		}
		
			System.out.println(customer);
			if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			fileIn=null;
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null) 
			objIn.close();
		System.out.println("Customer created");
		}
	/**
	 * for 3rd part of project
	 */
	@Override
	public synchronized void add_customer(Customer customer) throws ClassNotFoundException, IOException {
		System.out.println("Enter customer id:");
		fileIn = new FileInputStream("resources/data source.txt");
		fos=new FileOutputStream("resources/data source.txt",true);
			if(myfile.length()==0) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(customer);
		}else {
			moos = new MyObjectOutputStream(fos);
			moos.writeObject(customer);
		}
		
			System.out.println(customer);
			if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			fileIn=null;
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();
		System.out.println("Customer created");
		System.out.println("");
	}
	/**
	 * 
	 */
	@Override
	public synchronized void add_product() throws ClassNotFoundException, IOException{
		boolean temp1=true,temp2=true;
		Product Product = new Product();
		products = new ArrayList<Product>();
		Object obj;
		int temp_id=0;
		System.out.println("Enter Product id:");
		fileIn = new FileInputStream("resources/data source.txt");
		fos=new FileOutputStream("resources/data source.txt",true);
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				temp_id = scannerInt.nextInt();
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
				if (obj instanceof Product) {
					products.add((Product) obj);
					}
			}
		
		while(temp2) {
			temp_id = scannerInt.nextInt();
			temp2=false;
			for (Product Product2 : products) {
				if (temp_id == Product2.getId()) {
					temp2 = true;
					System.out.println("id allready exists ,try entreing new id again");
				}
			}
		}
		Product.setId(temp_id);
		System.out.println("Enter name of the product:");
		Product.setName(scannerString.nextLine());
		System.out.println("Enter the name of the store that the product is been sold :");
		Product.setStore(scannerString.nextLine());
		
		
		
			if(myfile.length()==0) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(Product);
		}else {
			moos = new MyObjectOutputStream(fos);
			moos.writeObject(Product);
		}
		
			System.out.println(Product);
			if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null) 
			objIn.close();
		System.out.println("Product created");
	}
	/**
	 * for 3rd part of the project
	 */
	@Override
	public synchronized void add_product(Product product) throws ClassNotFoundException, IOException{
		System.out.println("Enter Product id:");
		fileIn = new FileInputStream("resources/data source.txt");
		fos=new FileOutputStream("resources/data source.txt",true);
			if(myfile.length()==0) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(product);
		}else {
			moos = new MyObjectOutputStream(fos);
			moos.writeObject(product);
		}
		
			System.out.println(product);
			if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();
		System.out.println("Product created");
		System.out.println("");
	}
	/**
	 * remove customer 3rd part
	 */
	@Override
	public synchronized void remove_customer(int id) throws ClassNotFoundException, FileNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
		//System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to delete");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
				// e.printStackTrace();
			}
			objects.add(obj);
			}
		while(temp2) {
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Customer) {
					if (id == ((Customer) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(objects.get(i));
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find Customer by id of :"+temp_id+"try entering the id again ");
			}
		}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) 
				fileIn.close();
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();
		System.out.println("Customer "+id+ "deleted");
		System.out.println("");
	}
	/**
	 * 
	 */
	@Override
	public synchronized void remove_customer() throws ClassNotFoundException, FileNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
//		System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to delete");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
				// e.printStackTrace();
			}
			objects.add(obj);
			}
		while(temp2) {
					temp_id = scannerInt.nextInt();
					temp2=false;
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Customer) {
					if (temp_id == ((Customer) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(objects.get(i));
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
//					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find Customer by id of :"+temp_id+"try entering the id again ");
				temp_id = scannerInt.nextInt();
			}
		}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) 
				fileIn.close();
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();
		System.out.println("Customer "+temp_id+ "deleted");
		}
		}
	/**
	 * 
	 */
	@Override
	public synchronized void remove_product(int id) throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
		//System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to delete");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
				// e.printStackTrace();
			}
			objects.add(obj);
			}
		while(temp2) {
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Product) {
					if (id == ((Product) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(objects.get(i));
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find product by id of :"+temp_id+"try entering the id again ");
			}
		}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();		
			System.out.println("Product "+id+ "deleted");
			System.out.println("");
	}
	/**
	 * 
	 */
	@Override
	public synchronized void remove_product() throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
		System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to delete");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
				// e.printStackTrace();
			}
			objects.add(obj);
			}
		while(temp2) {
					temp_id = scannerInt.nextInt();
					temp2=false;
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Product) {
					if (temp_id == ((Product) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(objects.get(i));
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find product by id of :"+temp_id+"try entering the id again ");
				temp_id = scannerInt.nextInt();
			}
		}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) 
				fileIn.close();
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();		
			System.out.println("Product "+temp_id+ "deleted");
	}
	/**
	 * 
	 */
	public synchronized boolean cheacking_customer_id_exist(int id) throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true;
		Object obj;
		//System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				System.out.println("The file is empty,there is no customers in it");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			objects.add(obj);
			}
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Customer) {
					if (id == ((Customer) objects.get(i)).getId()) {
						return true;
					}
				}
				}
				return false;
	}
	/**
	 * 
	 */
	@Override
	public synchronized boolean cheacking_product_id_exist(int id) throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true;
		Object obj;
		//System.out.println("Enter Customer id that you want to delete :");
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				System.out.println("The file is empty,there is no customers in it");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			objects.add(obj);
			}
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Product) {
					if (id == ((Product) objects.get(i)).getId()) {
						return true;
					}
				}
				}
				return false;
	}
	/**
	 * 
	 */
	@Override
	public synchronized void update_customer(Customer customer) throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to update");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			objects.add(obj);
			}
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Customer) {
					if (customer.getId() == ((Customer) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(i);
						objects.add(i,customer);
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find Customer by id of :"+temp_id+" try entering the id again ");
			}
			else {
				System.out.println("Customer "+customer.getId()+ "updated");
			}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null) 
			objIn.close();
	}
	/**
	 * 
	 */
	@Override
	public synchronized void update_product(Product product)throws ClassNotFoundException, IOException {
		objects=new ArrayList<Object>();
		boolean temp1=true,temp2=true;
		int temp_id=0;
		Object obj;
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
				temp2 = false;
				System.out.println("The file is empty,there is no customers to update");
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
			objects.add(obj);
			}
				for (int i=0;i<objects.size();i++) {
				if (objects.get(i)!=null &&objects.get(i) instanceof Product) {
					if (product.getId() == ((Product) objects.get(i)).getId()) {
						temp2 = false;
						objects.remove(i);
						objects.add(i,product);
						//rewrite
						fos=new FileOutputStream("resources/data source.txt");
						for (Object object2 : objects) {
							if(myfile.length()==0) {
								oos = new ObjectOutputStream(fos);
								oos.writeObject(object2);
						}else {
							moos = new MyObjectOutputStream(fos);
							moos.writeObject(object2);
						}
						}
						continue;
					}
					}
			}
			if(temp2==true) {
				System.out.println("Coudnt find Product by id of :"+temp_id+" try entering the id again ");
			}else {
				System.out.println("Product "+product.getId()+ "updated");
			}
		if (fos!=null) 
			fos.close();
			if (fileIn!=null) {
				fileIn.close();
			}
			if (oos!=null) 
			oos.close();
			if (moos!=null) 
			moos.close();
			if (objIn!=null)  
			objIn.close();
	}
	/**
	 * 
	 */
	@Override
	public synchronized Customer get_customer(int id) throws ClassNotFoundException, IOException {
		customers = new ArrayList<Customer>();
		customers=get_customers();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId() == id)
				return customers.get(i);
		}
		System.out.println("cust didnt found");
		objIn.close();
		fileIn.close();
		return null;
	}
	/**
	 * 
	 */
	@Override
	public synchronized Product get_product(int id) throws ClassNotFoundException, IOException {
		products =new ArrayList<Product>();
		products=get_products();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id)
				return products.get(i);
		}
		System.out.println("pro didnt found");
		fileIn.close();
		objIn.close();
		return null;
	}
	/**
	 * 
	 */
	@Override
	public synchronized List<Customer> get_customers() throws ClassNotFoundException, IOException {
		customers = new ArrayList<Customer>();
		boolean temp1=true;
		Object obj;
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
				if (obj instanceof Customer) {
					customers.add((Customer) obj);
					}
			}
		return customers;
	
	}
/**
 * 
 */
	@Override
	public synchronized List<Product> get_products() throws ClassNotFoundException, IOException {
		products=new ArrayList<Product>();
		boolean temp1=true;
		Object obj;
		fileIn = new FileInputStream("resources/data source.txt");
		try {
			objIn = new ObjectInputStream(fileIn);
		} catch (EOFException e) {
				temp1 = false;
		}
		while(temp1){	
			try {
				obj=objIn.readObject();
			} catch (EOFException e) {
				temp1 = false;
				obj=null;
				continue;
			}
				if (obj instanceof Product) {
					products.add((Product) obj);
					}
			}
		return products;
	}
	/**
	 * 
	 */
	@Override
	public synchronized List<Customer> searchCustomerByName(String name) throws ClassNotFoundException, IOException {
		customers=new ArrayList<Customer>();
		List<Integer> indexs=new ArrayList<Integer>();
		List<Customer> customersReturn=new ArrayList<Customer>();
		customers=get_customers();
		KMP_Algorithm RKA=new KMP_Algorithm();
		for (Customer customer : customers) {
			if(name!=null) 
			indexs=RKA.Search(name, customer.getFirstname());
			if(!indexs.isEmpty())
				customersReturn.add(customer);
		}
		return customersReturn;
	}
	/**
	 * 
	 */
	@Override
	public synchronized List<Product> searchProductByName(String name) throws ClassNotFoundException, IOException{
		products=new ArrayList<Product>();
		List<Product> productsReturn=new ArrayList<>();
		List<Integer> indexs=new ArrayList<Integer>();
		products=get_products();
		KMP_Algorithm KMPA=new KMP_Algorithm();
		for (Product product : products) {
			if(name!=null) 
			indexs=KMPA.Search(name, product.getName());
			if(!indexs.isEmpty())
				productsReturn.add(product);
		}
		return productsReturn;
	}
	/**
	 * 
	 */
	@Override
	public synchronized List<Product> searchProductByDescription(String description)throws ClassNotFoundException, IOException {
		products=new ArrayList<Product>();
		List<Product> productsReturn=new ArrayList<>();
		List<Integer> indexs=new ArrayList<Integer>();
		products=get_products();
		Rabin_Karp_Algorithm KMPA=new Rabin_Karp_Algorithm();
		for (Product product : products) {
			if(product.getDescription()!=null) 
			indexs=KMPA.Search(description, product.getDescription());
			if(!indexs.isEmpty())
				productsReturn.add(product);
		}
		return productsReturn;
	}
	@Override
	public synchronized void purchaseItem(Customer customer) throws ClassNotFoundException, IOException {
//		List<Product> temp= new ArrayList<Product>();
//		if(customer.getProducts_own()==null) {
//			temp.add(product);
//			customer.setProducts_own(temp);
//		}
//		else {
//			temp=customer.getProducts_own();
//			temp.add(product);
//			customer.setProducts_own(temp);
//		}
		update_customer(customer);
	}
	/**
	 * 
	 */
	@Override
	protected void finalize() throws Throwable {
		scannerInt.close();
		scannerString.close();
	}
}