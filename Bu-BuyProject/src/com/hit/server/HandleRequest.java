package com.hit.server;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.hit.dm.Customer;
import com.hit.dm.Product;
import com.hit.service.BuBuyController;


public class HandleRequest  implements Runnable{
	Request<?> request;
	Response response;
	BuBuyController controller;
	Customer customer;
	Product product;
	List<Customer> customers ;
	List <Product> products;
	
	public HandleRequest(Request<?> req,BuBuyController controller ) {

		if(req.header.target.equals("customer")) {
			Request<Customer> request=new Request<>();
			request.header.target=req.header.target;
			request.header.action=req.header.action;
			request.body=new Customer();
			request.body=new Gson().fromJson((String) req.body.toString(), Customer.class);
			this.request=request;
			System.out.println(this.request);
		}else if(req.header.target.equals("product")) {
			Request<Product> request=new Request<>();
			request.header.target=req.header.target;
			request.header.action=req.header.action;
			request.body=new Product();
			request.body=new Gson().fromJson((String) req.body.toString().toString(), Product.class);
			this.request=request;
			System.out.println(this.request);
		}
		this.controller=controller;
	}

	@Override
	public void run() {
		if(request.header.target.equals("customer")) {
			try {
				this.customer=(Customer)request.body;
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
			if(request.header.action.equals( "Login")) {
				try {
					response=new Response();
					if(controller.Login(customer.getId(),customer.getPassword()))
						response.body =new Gson().toJson("true");
					else
						response.body =new Gson().toJson("false");
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("create")) {
				try {
					controller.createCustomer(customer);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("remove")) {
				try {
					controller.removeCustomer(customer.getId());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("update")) {
				try {
					controller.updateCustomer(customer);
					response=new Response();
					response.body =new Gson().toJson(customer);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("getall")) {
				try {
					customers=controller.getallcustomers();
					response=new Response();
					for (Customer customer : customers) {
						customer.setPassword("*************");
					}
					response.body =new Gson().toJson(customers);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else if(request.header.action.equals("get")) {
				try {
					customer=controller.getCustomer(customer.getId());
					response=new Response();
					response.body =new Gson().toJson(customer);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("searchbyname")) {
				try {
					customers=controller.searchCustomerByName(customer.getFirstname());
					response=new Response();
					if(customers==null||customers.isEmpty())
						response.body =new Gson().toJson("coundt find customers by the name of :"+customer.getFirstname());
					else
					response.body =new Gson().toJson(customers);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("purchase")) {
				try {
					controller.purchaseItem(customer);
//					response=new Response();
//					if(customers==null||customers.isEmpty())
						response.body =new Gson().toJson("purchase made for customer :"+customer.getFirstname());
//					else
//						response.body =new Gson().toJson(customers);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		if(request.header.target.equals("product")) {
			try {
				this.product=(Product)request.body;
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
			if(request.header.action.equals("create")) {
				try {
					controller.createProduct(product);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("remove")) {
				try {
					controller.removeProduct(product.getId());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("update")) {
				try {
					controller.updateProduct(product);
					response=new Response();
					response.body =new Gson().toJson(product);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("getall")) {
				try {
					products=controller.getallproducts();
					response=new Response();
					response.body =new Gson().toJson(products);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("get")) {
				try {
					product=controller.getProduct(product.getId());
					response=new Response();
					response.body =new Gson().toJson(product);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("searchbyname")) {
				try {
					products=controller.searchProductrByName(product.getName());
					response=new Response();
					if(products==null||products.isEmpty())
						response.body =new Gson().toJson("coundt find product by the name of : "+product.getName());
					else
					response.body =new Gson().toJson(products);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.header.action.equals("searchbydescription")) {
				try {
					products=controller.searchProductrByDescription(product.getDescription());
					response=new Response();
					if(products==null||products.isEmpty())
						response.body =new Gson().toJson("coundt find product by the decription :" + product.getDescription());
					else
					response.body =new Gson().toJson(products);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	}


	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}


	public Customer getCustomer() {
		return customer;
	}
	public Product getProduct() {
		return product;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}