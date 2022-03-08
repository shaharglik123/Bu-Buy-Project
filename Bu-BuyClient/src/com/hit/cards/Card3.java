package com.hit.cards;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hit.model.Customer;
import com.hit.view.GraphicView;

public class Card3 extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String newline = "\n";
	JTextArea searchFieldArea;
	JTextField searchedText=new JTextField();
	GraphicView view;
	JPanel panel;
	List<Customer> customers;
	public JPanel card3Show(GraphicView view) {
		this.view=view;
		panel=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		JTextArea textField1 = new JTextArea(30, 50);
		final String newline = "\n";
		textField1.setFont(new Font("Serif", Font.BOLD, 15));
		customers=new ArrayList<Customer>();
		customers=view.getAllCustomers();
		textField1.append("List of all the customers :"+newline);
		for (int i=0; i<customers.size();i++) {
			textField1.append("customer :"+customers.get(i)+newline);
		}
		panel.add(textField1);
		return panel;
	}

}
