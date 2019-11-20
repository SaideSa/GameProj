package prototyp;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	
	int dx;	//x-Richtung
	int dy;	//y-Richtung
	
	public Player() {
		
		//Bild laden
		ImageIcon ii = new ImageIcon(this.getClass().getResource("spieler.png"));
		image = ii.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		//Startposition
		resetState();
	}
	
	
	public void move() {
		x+=dx;
		y+=dy;
		
		//Spieler soll Feld nicht verlassen können
		if( x<=2) {
			x = 2;
		}
		if(x>=1310) {
			x=1310;
		}
		if( y<=2) {
			y = 2;
		}
		if(y>=680) {
			y = 680;
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Spielerbewegung
		if(key == KeyEvent.VK_A) {
			dx = -3;
		}
		
		if(key == KeyEvent.VK_D) {
			dx = 3;
		}
		
		if(key == KeyEvent.VK_S) {
			dy = 3;
		}
		
		if(key == KeyEvent.VK_W) {
			dy = -3;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Spielerbewegung Stopp
		if(key == KeyEvent.VK_A) {
			dx = 0;
		}
		
		if(key == KeyEvent.VK_D) {
			dx = 0;
		}
		
		if(key == KeyEvent.VK_S) {
			dy = 0;
		}
		
		if(key == KeyEvent.VK_W) {
			dy = 0;
		}
	}
	
	public void resetState() {
		//Startposition
		x = 2;
		y = 2;
	}
	
}
