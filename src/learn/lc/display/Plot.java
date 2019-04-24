package learn.lc.display;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Plot extends JComponent {
	
	public Plot() {
		super();
		Dimension dim = new Dimension(640,480);
		setPreferredSize(dim);
	}
	
	protected int lx;
	protected int ly;
	
	public void addPoint(double x, double y) {
		int xpoint = (int) (x*getWidth());
		int ypoint = (int) ((1-y)*getHeight());
		getGraphics().drawLine(lx, ly, xpoint, ypoint);
		lx = xpoint;
		ly = ypoint;
	}
	
	public void paintComponent(Graphics g) {
		
	}

}
