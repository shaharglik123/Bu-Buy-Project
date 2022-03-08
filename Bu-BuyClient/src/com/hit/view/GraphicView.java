package com.hit.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.hit.controller.Controller;
import com.hit.model.Customer;
import com.hit.model.Model;
import com.hit.model.Product;

@SuppressWarnings("deprecation")
public class GraphicView extends Observable{
	JFrame frame1;
	JFrame frame2;
	private Login login;
	Selection selection;
	JPanel selectionPanel;
	JPanel loginPanel;
	Model model;
	Controller ctr;

	public GraphicView() {
	}

	public void start() {
		  /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	protected void createAndShowGUI() {
//		selection=new Selection(this,this.frame2);
        //Create and set up the windows.
        frame1 = new JFrame("Login");
        frame2 = new JFrame("Selection tabs");
        loginPanel=new JPanel();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content panes.
        setLogin(new Login(this));               
        loginPanel.add(getLogin());
        loginPanel.setVisible(true);
        frame1.setVisible(true);
        frame1.getContentPane().add(getLogin());
        //Display the windows.
        frame1.pack();
	}
	public void logingAccepted() {
		frame1.dispose();
		selection = new Selection(this,frame2.getContentPane());
		selection.selectionView();
		selectionPanel=new JPanel();	
		selection.customer.setId(getLogin().getidlogin());
		selectionPanel.add(selection);
		selectionPanel.setVisible(true);
		frame2.setVisible(false);
		frame2.getContentPane().add(selection);
		frame2.setLocationByPlatform(true);
        frame2.pack();
        frame2.setVisible(true);
	}
	
	public boolean Login(String request) throws ClassNotFoundException, IOException {
		model= new Model();
		return model.Login(request,this);
	}
	public Customer getCustomer(int id) {
		return model.getCustomer(id);
		
	}

	public ArrayList<Customer> getAllCustomers() {
		return model.getallcustomers();
	}

	public ArrayList<Product> getAllProducts() {
		return model.getallproducts();
	}

	public ArrayList<Product> getAllOfMyProducts() {
		return model.getallmyproducts();
	}

	public ArrayList<Customer> searchCustomerByName(String name) {
		return model.searchCustomerByName(name);
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public ArrayList<Product> searchProductByName(String name) {
		return model.searchProductByName(name);
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelectionCustomer(Customer customer) {
		this.selection.customer = customer;
	}
	public Customer getSelectionCustomer() {
		return this.selection.customer;
	}

	public Product getProductById(int id) {
		return model.searchProductById(id);
	}

	public ArrayList<Product> getProductByDesc(String desc) {
		return model.searchProductByDescription(desc);
	}

	public void purchaseItem(Customer customer) {
		model.purchaseItem(customer);
	}
	
	
}
