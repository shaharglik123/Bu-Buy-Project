package com.hit.controller;

import java.util.Observable;
import com.hit.model.Model;
import com.hit.view.GraphicView;
import com.hit.view.Login;

@SuppressWarnings("deprecation")
public class Controller implements IController{
	Model model;
	GraphicView view;
	public Login startPanel;
	
	public Controller(Model model,GraphicView view ) {
		this.model=model;
		this.view=view;
	}
	
	@Override
	public void update( Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
