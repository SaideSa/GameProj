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
		if(x>=740) {
			x=740;
		}
		if( y<=2) {
			y = 2;
		}
		if(y>=490) {
			y = 490;
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Spielerbewegung
		if(key == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy = 3;
		}
		
		if(key == KeyEvent.VK_UP) {
			dy = -3;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Spielerbewegung Stopp
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
	}
	
	public void resetState() {
		//Startposition
		x = 2;
		y = 2;
	}
	
}
