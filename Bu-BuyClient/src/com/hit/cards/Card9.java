package com.hit.cards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hit.model.Customer;
import com.hit.model.Product;
import com.hit.view.GraphicView;

public class Card9 extends JPanel implements ActionListener {
	 final String newline = "\n";
	 JTextArea searchFieldArea;
	 JTextField searchedText=new JTextField();
	 GraphicView view;
	 Customer customer;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Product product;
	public JPanel card9Show(GraphicView view,Container pane) {
		customer=view.getSelectionCustomer();
		this.view=view;
		JButton button = new JButton("Search");
		button.addActionListener(this);
		searchedText = new JTextField("Enter product description", 25);
		searchedText.setLocation(100, 0);
		searchedText.setEditable(true);
		JPanel panel = new JPanel();
		searchFieldArea= new JTextArea(30, 60);
		searchFieldArea.setFont(new Font("Serif", Font.BOLD, 15));
		searchFieldArea.setEditable(false);
		panel.setMaximumSize(new Dimension(0, 0));
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
		setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		return panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
        if (s.equals("Search")) {
        	ArrayList<Product> products=new ArrayList<Product>();
        	products=view.getProductByDesc(searchedText.getText());
        	if(products != null) {
        		searchFieldArea.setText("");
        	for (int i = 0; i < products.size(); i++) {
        		searchFieldArea.append("Product information :"+newline+"Id:"+products.get(i).getId()+newline
        				+"product name:"+products.get(i).getName()+newline
        				+"lastname:"+products.get(i).getStore()+newline
        				+"age:"+products.get(i).getDescription()+newline
        				+"---------------------------------------------"
		);
        	}
        	searchFieldArea.updateUI();
        	searchFieldArea.validate();
        	searchFieldArea.revalidate();
        }
		
	}

}
}
