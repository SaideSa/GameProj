package prototyp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Key extends Sprite{
	
	boolean visible;
	
	public Key(int x, int y) {
		//Position
		this.x = x;
		this.y = y;
		//Bild laden
		ImageIcon ii = new ImageIcon(this.getClass().getResource("key.png"));
		image = ii.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		visible = true;

	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
