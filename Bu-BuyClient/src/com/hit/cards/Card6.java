package com.hit.cards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.hit.model.Customer;
import com.hit.view.GraphicView;

public class Card6 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String newline = "\n";
	JTextArea searchFieldArea;
	JTextField searchedText=new JTextField();
	GraphicView view;
	Customer customer;

	public JPanel card6Show(GraphicView view) {
		this.view=view;
		Customer customer=view.getSelectionCustomer();
			JButton button = new JButton("Search");
			button.addActionListener(this);
			searchedText = new JTextField("Enter customer name", 25);
			searchedText.setLocation(100, 0);
			searchedText.setEditable(true);
			JPanel panel = new JPanel();
			searchFieldArea= new JTextArea(30, 60);
			searchFieldArea.setFont(new Font("Serif", Font.BOLD, 15));
			searchFieldArea.setEditable(false);
			searchFieldArea.append("Hello :"+customer.getFirstname()+" "+customer.getLastname()+newline
					+"Your information :"+newline+"Id:"+customer.getId()+newline
					+"firstname:"+customer.getFirstname()+newline
					+"lastname:"+customer.getLastname()+newline
					+"age:"+customer.getAge()+newline
					+"product I own :"+customer.getProducts_own()+newline+newline+newline+newline+newline+"Have a nice day :)"
					);
			panel.add(searchedText);
			panel.add(button);
			panel.add(searchFieldArea);
			return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
        if (s.equals("Search")) {
        	ArrayList<Customer> searchedCustomers=new ArrayList<Customer>();
        	searchedCustomers=view.searchCustomerByName(searchedText.getText());
        	if(searchedCustomers != null) {
        		searchFieldArea.setText("");
        		for (int i=0; i<searchedCustomers.size();i++) {
				searchFieldArea.append("User information :"+newline+"Id:"+searchedCustomers.get(i).getId()+newline
		+"firstname:"+searchedCustomers.get(i).getFirstname()+newline
		+"lastname:"+searchedCustomers.get(i).getLastname()+newline
		+"age:"+searchedCustomers.get(i).getAge()+newline
		+"product I own :"+searchedCustomers.get(i).getProducts_own()+newline
		);
        		}
        		searchFieldArea.updateUI();
        		searchFieldArea.validate();
        		searchFieldArea.revalidate();
        }
	}
	}
	}
