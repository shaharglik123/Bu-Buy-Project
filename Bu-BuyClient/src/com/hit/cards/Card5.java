package com.hit.cards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.hit.model.Customer;
import com.hit.view.GraphicView;

public class Card5 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String newline = "\n";
	JTextArea searchFieldArea;
	JTextField searchedText=new JTextField();
	GraphicView view;
	Customer customer;
	Customer searchedCustomer;

	public JPanel card5Show(GraphicView view) {
		this.view=view;
		customer=view.getSelectionCustomer();
			JButton button = new JButton("Search");
			button.addActionListener(this);
			searchedText = new JTextField("Enter customer id", 25);
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
 
        	searchedCustomer=new Customer();
        	int id = 0;
        	try {
        		id=Integer.parseInt(text);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	searchedCustomer=view.getCustomer(id);
        	if(searchedCustomer != null) {
        		searchFieldArea.setText("");
        		searchFieldArea.setText("Hello :"+searchedCustomer.getFirstname()+" "+searchedCustomer.getLastname()+newline
		+"Your information :"+newline+"Id:"+searchedCustomer.getId()+newline
		+"firstname:"+searchedCustomer.getFirstname()+newline
		+"lastname:"+searchedCustomer.getLastname()+newline
		+"age:"+searchedCustomer.getAge()+newline
		+"product I own :"+searchedCustomer.getProducts_own()+newline
		);
        		searchFieldArea.updateUI();
        		searchFieldArea.validate();
        		searchFieldArea.revalidate();
        }
	}

}
}