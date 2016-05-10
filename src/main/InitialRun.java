package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.layers.LayerAndInputHandler;

public class InitialRun extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LayerAndInputHandler lc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialRun frame = new InitialRun();
					frame.setVisible(true);
					frame.setName("Game");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InitialRun() {

//		setSize(1000, 500);
		
//		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000,500);
		setLocationRelativeTo(null);
		setResizable(false);
		lc = new LayerAndInputHandler();
//		lc.setBorder(new EmptyBorder(5, 5, 5, 5));
		lc.setLayout(new BorderLayout(0, 0));
		setContentPane(lc);
//		LayerHandler lc= new LayerHandler();
//		add());
		lc.setHandler(lc);
		lc.createSubClasses();

		
	}

}
