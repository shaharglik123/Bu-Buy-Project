package com.hit.cards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hit.model.Customer;
import com.hit.model.Product;
import com.hit.view.GraphicView;

public class Card8 extends JPanel implements ActionListener {
	 final String newline = "\n";
	 JTextArea searchFieldArea;
	 JTextField searchedText=new JTextField();
	 GraphicView view;
	 Customer customer;
	 Product product;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel card8Show(GraphicView view) {
		customer=view.getSelectionCustomer();
		this.view=view;
		JButton button = new JButton("Search");
		button.addActionListener(this);
		searchedText = new JTextField("Enter product id", 25);
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
	 searchedText.getText();
        	String text=searchedText.getText();
        	Product product=new Product();
        	int id = 0;
        	try {
        		id=Integer.parseInt(text);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	product=view.getProductById(id);
        	if(product != null) {
        		searchFieldArea.setText("");
        		searchFieldArea.setText("Product information :"+newline+"Id:"+product.getId()+newline
        				+"product name:"+product.getName()+newline
        				+"lastname:"+product.getStore()+newline
        				+"age:"+product.getDescription()+newline
		);
        	searchFieldArea.updateUI();
        	searchFieldArea.validate();
        	searchFieldArea.revalidate();
        }
		
	}

}
}
