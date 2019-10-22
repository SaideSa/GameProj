package package1;

import java.awt.Color;

public class Cactus extends A_GameObject {
//
//	public double x;
//	public double y;
//	public double speed = 100;
//	public double alfa = -0.5; //represents the objects moving direction (angle alfa, between 0 and 2*PI)
	private Color color;
	public Cactus(double x, double y, double a, double s) {
		super(x, y, a, s);

		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		color = new Color(r,g,b);
	}
	
	
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	public double getSpeed() {
		return this.speed;
	}
	public double getAlfa() {
		return this.alfa;
	}

	
	public void move(double diffSeconds) {
	super.move(diffSeconds);
//	reflectOnBorders();
	}
	
}
