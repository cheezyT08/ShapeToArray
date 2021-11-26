package io.github.cheezyT08;

//@author Torin

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShapeToArrayMain {


	public static void main(String[] args) {
		new Window();
	}
	
	private static class Window extends JFrame {
		private DrawPanel dp = new DrawPanel();
		private JPanel p = new JPanel();
		private JButton bP = new JButton("Print Array"), bU = new JButton("Undo");
		
		public Window() {
			setSize(600, 650);
			setLayout(new BorderLayout());
			setTitle("Shape To Array");
			setDefaultCloseOperation(3);
			bP.addActionListener(new PrintLstnr());
			bU.addActionListener(new UndoLstnr());
			bP.setBackground(new Color(230, 230, 4));
			bU.setBackground(new Color(230, 40, 40));
			bP.setFocusPainted(false);
			bU.setFocusPainted(false);
			p.setLayout(new GridLayout(1, 2));
			p.add(bP);
			p.add(bU);
			add(p, BorderLayout.NORTH);
			add(dp, BorderLayout.CENTER);
			setLocationRelativeTo(null);
			setVisible(true);
		}
		
		private class PrintLstnr implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				dp.printVals();
			}
			
		}
		
		private class UndoLstnr implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				dp.undo();
			}
			
		}
		
	}

}
