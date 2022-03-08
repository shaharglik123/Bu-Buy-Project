package com.hit.cards;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import com.hit.model.Product;
import com.hit.view.GraphicView;

public class Card4 extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
GraphicView view;
List<Product> products;
	public JPanel card4Show(GraphicView view) {
		this.view=view;
		products=new ArrayList<Product>();
		JPanel panel=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		JTextArea textField1 = new JTextArea(30, 50);
		final String newline = "\n";
		textField1.setFont(new Font("Serif", Font.BOLD, 15));
		textField1.setEditable(false);
		products=new ArrayList<Product>();
		products=view.getAllProducts();
		textField1.append("List of all the products :"+newline);
		for (int i=0; i<products.size();i++) {
			textField1.append("product :"+products.get(i)+newline);
		}
		panel.add(textField1);
		return panel;
	}

}
