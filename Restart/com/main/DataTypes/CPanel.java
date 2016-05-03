package com.main.DataTypes;

import java.awt.Color;

import javax.swing.JPanel;

import com.main.layers.LayerAndInputHandler;

public class CPanel extends JPanel {
	private LayerAndInputHandler IN;

	public CPanel() {
		setOpaque(true);
		setBackground(Color.GRAY);
	}
	
	public CPanel(LayerAndInputHandler Input){
		setOpaque(true);
		setBackground(Color.GRAY);
		IN=Input;
	}

	public void setInputHandler(LayerAndInputHandler input) {
		IN = input;
//		System.out.println("SetInput " + IN.toString()+ " "  + new Exception().getStackTrace()[1]);
	}

	public LayerAndInputHandler getInputHandler() {
//		System.out.println("GetInput: " + new Exception().getStackTrace()[0] + " " + IN.toString());
		return IN;

	}
	public void CRun(){
		
	}

}
