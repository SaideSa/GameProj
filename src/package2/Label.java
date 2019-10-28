package package2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Label extends JLabel {
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(Var.ih1, 0, Var.backgroundY1, 800, 600, null);
		g.drawImage(Var.ih2, 0, Var.backgroundY2, 800, 600, null);
		
		g.drawImage(Var.ispieler, Var.x, Var.y, 50, 80, null); //spieler hat Gr��e 50x80s
		
		repaint();
	}

}
