package com.hit.cards;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.hit.model.Customer;
import com.hit.model.Product;
import com.hit.view.GraphicView;

public class Card2 extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l;  
    JCheckBox cb1,cb2,cb3;  
    JButton b;  
    GraphicView view;
    @SuppressWarnings("rawtypes")
	JComboBox jComboBox;
    public Card2(){
    	
    }
    ArrayList<Product> products;
    Customer customer;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public JPanel card2Show(GraphicView view, Customer customer){
    	this.customer=customer;
    	products=new ArrayList<Product>();
    	JButton button = new JButton("Buy");
    	products=view.getAllProducts();
    	String[] productsNames = new String[products.size()] ;
    	for (int i = 0; i < products.size(); i++) {
    		productsNames[i]=products.get(i).getName();
		}
    	JPanel panel=new JPanel(new FlowLayout(SwingConstants.LEADING, 30, 60));
//    	Create the combo box, select item at index 4.
//    	Indices start at 0, so 4 specifies the pig.
    	jComboBox = new JComboBox(productsNames);
    	jComboBox.setSelectedIndex(4);
    	jComboBox.addActionListener(this);
    	button.addActionListener(this);
    	JLabel wip=new JLabel("Work in progress!...", SwingConstants.RIGHT);
    	
    	panel.add(jComboBox);
    	panel.add(button);
    	panel.add(wip);
		return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	String s = e.getActionCommand();
        if (s.equals("Buy")) {
        	Product product=new Product();
        	String productname =(String)jComboBox.getSelectedItem();
        	for (int i = 0; i < products.size(); i++) {
				if(products.get(i).getName().equals(productname))
					product=products.get(i);
			}
        	List<Product> products_own =new ArrayList<Product>();
        	products_own=customer.getProducts_own();
        	products_own.add(product);
        	customer.setProducts_own(products_own);
        	view.purchaseItem(customer);
}
}
}