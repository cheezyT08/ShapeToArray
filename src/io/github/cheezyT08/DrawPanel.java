package io.github.cheezyT08;

//@author Torin

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class DrawPanel extends JPanel {
	
	public ArrayList<Integer> arrX = new ArrayList<Integer>();
	public ArrayList<Integer> arrY = new ArrayList<Integer>();
	
	private Color backgroundColor = new Color(221, 225, 224), 
					lineColor = Color.BLACK, 
					dotColor = lineColor;
	
	public DrawPanel() {
		setSize(600, 600);
		setBackground(backgroundColor);
		addMouseListener(new ClickLstnr());
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < arrX.size(); i++) {
			int x = arrX.get(i), y = arrY.get(i);
			
			g.setColor(dotColor);
			g.fillRect(((int) x) - 1, ((int) y) - 1, 3, 3);
			g.setColor(lineColor);
			if(i > 0) {
				int px = arrX.get(i-1), py = arrY.get(i-1);
				g.drawLine((int) px, (int) py, (int) x, (int) y);
			}
		}
	}
	
	public void printVals() {
		String xStr = "X: {", yStr = "Y: {";
		
		//X values
		for(int i = 0; i < arrX.size(); i++) {
			xStr += arrX.get(i);
			if(i < arrX.size()-1) {
				xStr += ", ";
			}
		} xStr += "}";
		
		//Y values
		for(int i = 0; i < arrY.size(); i++) {
			yStr += arrY.get(i);
			if(i < arrY.size()-1) {
				yStr += ", ";
			}
		}yStr += "}";
		
		System.out.println(xStr+"\n"+yStr);
		JOptionPane.showMessageDialog(null, xStr+"\n"+yStr, "Shape To Array", 1);
	}
	
	public void undo() {
		if(arrX.size() > 0) {
			arrX.remove((arrX.size()-1));
			arrY.remove((arrY.size()-1));
			repaint();
		}
	}
	
	private class ClickLstnr extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			arrX.add(e.getX());
			arrY.add(e.getY());
			repaint();
		}
	}
}
