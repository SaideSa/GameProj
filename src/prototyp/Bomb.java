package prototyp;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Bomb extends Sprite{
	
	boolean dropped;
	
	public Bomb() {
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource("bomb.png"));
		image = ii.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		dropped = false;
		
	}
	
	public void drop(int x, int y) {
		this.dropped = true;
		this.x = x;
		this.y = y;
	}
	
	public void keyPressed(KeyEvent e, int x, int y) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_B) {
			this.drop(x, y);
		}
	}

}
