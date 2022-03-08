package com.hit.cards;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.hit.model.Customer;
import com.hit.view.GraphicView;

public class Card1 extends JPanel{
	final String newline = "\n";
	Customer customer;
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField searchedText=new JTextField();
	public JPanel card1Show(GraphicView view) {
		JPanel card=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		JTextArea textField1 = new JTextArea(30, 60);
		textField1.setFont(new Font("Serif", Font.BOLD, 15));
		textField1.setEditable(false);	
		customer=new Customer();
		customer.setId(view.getLogin().getidlogin());
		customer= view.getCustomer(customer.getId());
		textField1.append("Hello :"+customer.getFirstname()+" "+customer.getLastname()+newline
				+"Your information :"+newline+"Id:"+customer.getId()+newline
				+"firstname:"+customer.getFirstname()+newline
				+"lastname:"+customer.getLastname()+newline
				+"age:"+customer.getAge()+newline
				+"product I own :"+customer.getProducts_own()+newline+newline+newline+newline+newline+"Have a nice day :)"
				);
		card.add(textField1);
		return card;
	}

	
}
