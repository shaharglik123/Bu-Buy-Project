package com.hit.cards;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.hit.model.Customer;
import com.hit.model.Product;
import com.hit.view.GraphicView;

public class Card10 extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
List<Product> products;
GraphicView view;
Customer customer;
	public JPanel card10Show(GraphicView view) {
		this.view=view;
		customer=view.getSelection().getCustomer();
		JPanel card=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		JTextArea textField1 = new JTextArea(30, 50);
		final String newline = "\n";
		textField1.setFont(new Font("Serif", Font.BOLD, 15));
//		Color c = new Color(65, 63, 47,100);
//		textField1.setBackground(c);
		textField1.setEditable(false);
		products=new ArrayList<Product>();
		products=customer.getProducts_own();
		if(products==null) {
			textField1.append("you didnt purchase any products yet"+newline);
		}else {
			
		textField1.append("List of my products :"+newline);
		for (int i=0; i<products.size();i++) {
			textField1.append("product :"+products.get(i)+newline);
		}
		}
		card.add(textField1);
		return card;
	}

}
