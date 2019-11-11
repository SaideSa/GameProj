package prototyp;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Fireball extends Sprite{
	
	int dx;
	boolean shot;
	
	public Fireball() {
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource("fireball.png"));
		image = ii.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		shot = false;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		x+=dx;
	}
	
	public void shot(KeyEvent e, int x, int y) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			this.setShot(true);
			dx = 2;
		}
		while(this.shot) {
			this.move(x, y);
		}
		
	}
	
	public boolean isShot() {
		return shot;
	}
	
	public void setShot(boolean shot) {
		this.shot = shot;
	}


}
