package main.game.layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.S;

public class GamePause extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	JPanel p;
	JFrame f;
	JButton resume, options, quit;
	Box gr;

	public GamePause() {
		p = this;
		// p.setOpaque(false);
		f = S.frame;
		p.setBackground(new Color(f.getBackground().getRed(), f.getBackground().getGreen(), f.getBackground().getBlue(), 123));

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("GP", S.frame.getWidth()-27, S.frame.getHeight()-70);
	}

	private void run() {
		gr = new Box(BoxLayout.PAGE_AXIS);
		resume = new JButton("Resume");
		resume.addActionListener(al);
		options = new JButton("Options");
		options.addActionListener(al);
		quit = new JButton("Main-Menu");
		quit.addActionListener(al);
		gr.add(resume);
		gr.add(options);
		gr.add(quit);
		p.add(gr);
		this.setVisible(true);
		// p.add();
	}

	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Click: " + e.getActionCommand());
			if (resume.getActionCommand().equals(e.getActionCommand())) {

			}
		}
	};

	public void customRun() {
		f.add(this);
		p.setBackground(new Color(f.getBackground().getRed(), f.getBackground().getGreen(), f.getBackground().getBlue(), 123));
		run();
	}
}
