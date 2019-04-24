package learn.lc.display;

import java.awt.*;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ClassifierDisplay extends JFrame {
	
	protected Plot canvas;
	protected int lx, ly;
	public ClassifierDisplay(String title) {
		setTitle(title);
		canvas = new Plot();
		canvas.setPreferredSize(new Dimension(640, 480));
		add(canvas);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void addPoint(double x, double y) {
		int xpoint = (int)(x * getWidth());
		int ypoint = (int)((1.0-y) * getHeight());
		canvas.getGraphics().drawLine(lx, ly, xpoint, ypoint);
		lx = xpoint;
		ly = ypoint;
	}
	
	

}
