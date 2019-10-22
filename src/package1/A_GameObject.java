package package1;

public abstract class A_GameObject {

	public double x, y;
	public double speed;
	public double alfa = 0;
	//public Image image;
	
	public A_GameObject(double x, double y, double a, double s) {
		this.x = x;
		this.y = y;
		alfa = a;
		speed = s;
	}
	//move one step to direction <alfa>
	public void move (double diffSeconds) {
		x += Math.cos(alfa)*speed*diffSeconds;
		y += Math.sin(alfa)*speed*diffSeconds;
	}
	
	//for graphical output, we define an abstract class instead of a concrete JFrame; draw one or more GameObjects on the buffer and finally display it one the screen
}
