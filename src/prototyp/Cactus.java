package prototyp;

import javax.swing.ImageIcon;

public class Cactus extends Sprite {

	private int xdir;	//X-Richtung
	private int ydir;	//Y-Richtung

	boolean destroyed;

	public Cactus() {
		//Standard Bewegungsrichtung
		this.xdir = -1;
		this.ydir = 1;
		
		//Bild laden
		ImageIcon ii = new ImageIcon(this.getClass().getResource("cactus.png"));
		image = ii.getImage();

		width = image.getWidth(null);
		height = image.getHeight(null);
		
		//Startposition
		resetState();
		
		//noch nicht zerstört
		destroyed = false;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public void resetState() {
		//Startposition
		x = 700;
		y = 2;
	}

	public void move() {
		//Kaktusbewegung
		x += xdir;
		y += ydir;
		
		//eig unnötig
		System.out.println(xdir + " " +  ydir);
	}

	public void setXDir(int x) {
		//Festlegen X-Richtung
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

}
