package main.DataTypes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.layers.LayerAndInputHandler;

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
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
	}

}
