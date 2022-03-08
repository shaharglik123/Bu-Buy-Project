package com.hit.driver;

import com.hit.controller.Controller;
import com.hit.model.Model;
import com.hit.view.GraphicView;

public class MVCDriver {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Model model=new Model();
		GraphicView view=new GraphicView();
		Controller controller=new Controller(model,view);
		
		((Model)model).addObserver(controller);
		
		((GraphicView)view).addObserver(controller);
		
		view.start();
	}
}
