package com.hit.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.hit.cards.Card1;
import com.hit.cards.Card10;
import com.hit.cards.Card2;
import com.hit.cards.Card3;
import com.hit.cards.Card4;
import com.hit.cards.Card5;
import com.hit.cards.Card6;
import com.hit.cards.Card7;
import com.hit.cards.Card8;
import com.hit.cards.Card9;
import com.hit.model.Customer;
import com.hit.model.Product;
public class Selection extends JPanel{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		GraphicView view;
		 final static String CLIENTINFO = "Client info";
		 final static String PURCHASE = "Purchase items";
		 final static String GETALLCUST = "list of all the customers";
		 final static String GETALLPRO = "list of all the products";
		 final static String SEARCHCUSTBYID = "search customer by id";
		 final static String SEARCHCUSTBYNAME = "search customer by name";
		 final static String SEARCHPROBYNAME = "search product by name";
		 final static String SEARCHPROBYID = "search product by id";
		 final static String GETALLMYPRO = "list of my products";
		 final static String SEARCHPROBYDESC = "Search product by description";
		 final static String LISTOFMYPRODUCTS = "list of my products";
		 final static int extraWindowWidth = 100;
		 List<Customer> customers=new ArrayList<Customer>();
		 List<Product> products=new ArrayList<Product>();
		Customer customer=new Customer();
		 Container pane;
		
	public Selection(GraphicView view, Container pane) {
		this.view=view;
		this.pane=pane;
    }
public void selectionView() {
	customer=view.getCustomer(view.getLogin().getidlogin());
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel card1= new Card1().card1Show(view);
    JPanel card2 =new Card2().card2Show(view,customer);
    JPanel card3 = new Card3().card3Show(view);
    JPanel card4 = new Card4().card4Show(view);
    JPanel card5 = new Card5().card5Show(view);
    JPanel card6 = new Card6().card6Show(view);
    JPanel card7 = new Card7().card7Show(view);
    JPanel card8 = new Card8().card8Show(view);
    JPanel card9 = new Card9().card9Show(view,pane);
    JPanel card10 = new Card10().card10Show(view);

    tabbedPane.addTab(CLIENTINFO, card1);
    tabbedPane.addTab(PURCHASE, card2);
    tabbedPane.addTab(GETALLCUST, card3);
    tabbedPane.addTab(GETALLPRO, card4);
    tabbedPane.addTab(SEARCHCUSTBYID, card5);
    tabbedPane.addTab(SEARCHCUSTBYNAME, card6);
    tabbedPane.addTab(SEARCHPROBYNAME, card7);
    tabbedPane.addTab(SEARCHPROBYID, card8);
    tabbedPane.addTab(SEARCHPROBYDESC, card9);
    tabbedPane.addTab(LISTOFMYPRODUCTS, card10);
    pane.add(tabbedPane, BorderLayout.CENTER);
    add(tabbedPane);
}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
