package com.hit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.controller.Controller;
import com.hit.view.GraphicView;

import Networking.Client;

@SuppressWarnings("deprecation")
public class Model extends Observable  {
	Customer customer;
	ArrayList<Customer> customers;
	ArrayList<Product> products;
	Product product;
	Controller ctr;
	GraphicView view;
	
	Client client =new Client();
	
	
	public boolean Login(String request, GraphicView graphicView) throws ClassNotFoundException, IOException {
		this.view=graphicView;
		String login=client.sendData(request);
		if(login.equals("Response [body=\"true\"]")) {
			return true;
		}
		else
			return false;
	}


	public Customer getCustomer(int id) {
		Gson gson=new Gson();
        Request<Customer> req=new Request<>();
        Response response= new Response();
        customer=new Customer();
        customer.setId(id);
        req.setBody(customer);
        req.getHeader().setAction("get");
        req.getHeader().setTarget("customer");
        req.setBody(customer);
        String getinfo=gson.toJson(req);
        response.body =client.sendData(getinfo);
        StringBuilder customersb = new StringBuilder(response.body);
        customersb.delete(0,15);
        customersb.deleteCharAt(customersb.length()-1);
        Customer customer=gson.fromJson((String)customersb.toString(), Customer.class);
        return customer;
	}


	public ArrayList<Customer> getallcustomers() {
		Gson gson=new Gson();
		ArrayList<Customer> custs=new ArrayList<Customer>();
        Request<Customer> req=new Request<>();
        Response response= new Response();
        customer=new Customer();
        req.getHeader().setAction("getall");
        req.getHeader().setTarget("customer");
        req.body=customer;
        String getinfo=gson.toJson(req);
        System.out.println(getinfo);
        response.body =client.sendData(getinfo);
        StringBuilder customersb = new StringBuilder(response.body);
        customersb.delete(0,15);
        customersb.deleteCharAt(customersb.length()-1);
    	if(getinfo.isEmpty()||getinfo==null)
      		return custs=null;
        custs=gson.fromJson((String)customersb.toString(), new TypeToken<List<Customer>>(){}.getType());
        return custs;
	}


	public ArrayList<Product> getallproducts() {
		Gson gson=new Gson();
		ArrayList<Product> products=new ArrayList<Product>();
        Request<Product> req=new Request<>();
        Response response= new Response();
        product=new Product();
        req.getHeader().setAction("getall");
        req.getHeader().setTarget("product");
        req.body=product;
        String getinfo=gson.toJson(req);
        System.out.println(getinfo);
        response.body =client.sendData(getinfo);
        StringBuilder productsb = new StringBuilder(response.body);
        productsb.delete(0,15);
        productsb.deleteCharAt(productsb.length()-1);
    	if(getinfo.isEmpty()||getinfo==null)
      		return products=null;
        products=gson.fromJson((String)productsb.toString(), new TypeToken<List<Product>>(){}.getType());
        return products;
	}


	public ArrayList<Product> getallmyproducts() {
		Gson gson=new Gson();
		ArrayList<Product> products=new ArrayList<Product>();
        Request<Product> req=new Request<>();
        Response response= new Response();
        product=new Product();
        req.getHeader().setAction("getall");
        req.getHeader().setTarget("product");
        req.body=product;
        String getinfo=gson.toJson(req);
        System.out.println(getinfo);
        response.body =client.sendData(getinfo);
        StringBuilder productsb = new StringBuilder(response.body);
        productsb.delete(0,15);
        productsb.deleteCharAt(productsb.length()-1);
//      	if(getinfo.isEmpty()||getinfo==null)
//      		return products=null;
        products=gson.fromJson((String)productsb.toString(), new TypeToken<List<Product>>(){}.getType());
        return products;
	}


	public ArrayList<Customer> searchCustomerByName(String name) {
		Gson gson=new Gson();
        Request<Customer> req=new Request<>();
        Response response= new Response();
        customer=new Customer();
        customers=new ArrayList<Customer>();
        customer.setFirstname(name);
        req.setBody(customer);
        req.getHeader().setAction("searchbyname");
        req.getHeader().setTarget("customer");
        String getinfo=gson.toJson(req);
        response.body =client.sendData(getinfo);
        StringBuilder customersb = new StringBuilder(response.body);
        customersb.delete(0,15);
        customersb.deleteCharAt(customersb.length()-1);
        getinfo=customersb.toString();
      	if(getinfo.contains("coundt find product by the decription :"))
      		return customers=null;
        ArrayList<Customer> customers=gson.fromJson((String)customersb.toString(), new TypeToken<List<Customer>>(){}.getType());
        return customers;
	}


	public ArrayList<Product> searchProductByName(String name) {
		Gson gson=new Gson();
        Request<Product> req=new Request<>();
        Response response= new Response();
        ArrayList<Product> products=new ArrayList<Product>();
        product=new Product();
        product.setName(name);
        req.setBody(product);
        req.getHeader().setAction("searchbyname");
        req.getHeader().setTarget("product");
        req.setBody(product);
        String getinfo=gson.toJson(req);
        response.body =client.sendData(getinfo);
        StringBuilder productsb = new StringBuilder(response.body);
        productsb.delete(0,15);
        productsb.deleteCharAt(productsb.length()-1);
        getinfo=productsb.toString();
		if(getinfo.contains("coundt find product by the decription :"))
			return products=null;
        products=gson.fromJson((String)productsb.toString(), new TypeToken<List<Product>>(){}.getType());
		return products;
	}


	public Product searchProductById(int id) {
		Gson gson=new Gson();
        Request<Product> req=new Request<>();
        Response response= new Response();
        product=new Product();
        product.setId(id);
        req.setBody(product);
        req.getHeader().setAction("get");
        req.getHeader().setTarget("product");
        req.setBody(product);
        String getinfo=gson.toJson(req);
        response.body =client.sendData(getinfo);
        StringBuilder customersb = new StringBuilder(response.body);
        customersb.delete(0,15);
        customersb.deleteCharAt(customersb.length()-1);
        Product product=gson.fromJson((String)customersb.toString(), Product.class);
		return product;
	}
	
	public ArrayList<Product> searchProductByDescription(String Description) {
		Gson gson=new Gson();
		Request<Product> req=new Request<>();
		Response response= new Response();
		product.setDescription(Description);
		req.setBody(product);
		req.getHeader().setAction("searchbydescription");
		req.getHeader().setTarget("product");
		req.setBody(product);
		String getinfo=gson.toJson(req);
		response.body =client.sendData(getinfo);
		StringBuilder productsb = new StringBuilder(response.body);
		productsb.delete(0,15);
		productsb.deleteCharAt(productsb.length()-1);
		getinfo=productsb.toString();
		if(getinfo.contains("coundt find product by the decription :"))
			return products=null;
		ArrayList<Product> products=gson.fromJson((String)productsb.toString(), new TypeToken<List<Product>>(){}.getType());
		return products;
	}


	public void purchaseItem(Customer customer2) {
		
	}
}