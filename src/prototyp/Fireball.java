package prototyp;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Fireball extends Sprite{
	
	int xdir;
	int ydir;
	boolean shot;
	
	public Fireball() {
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource("fireball.png"));
		image = ii.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		shot = false;
		
//		resetState();
	}
	
	public void move() {
		x+=xdir;
		y+=ydir;
	}
	
	public void setXDir(int x) {
		xdir = x;
	}
	public void setYDir(int y) {
		//Festlegen Y-Richtung
		ydir = y;
	}

	public int getYDir() {
		return ydir;
	}

	public int getXDir() {
		return xdir;
	}
	
	public boolean isShot() {
		return shot;
	}
	
	public void setShot(boolean shot) {
		this.shot = shot;
	}
	
	public void shot(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			this.shot = true;
		}
	}
//	public void resetState() {
//		x = 100;
//		y = 100;	
//	}

}
