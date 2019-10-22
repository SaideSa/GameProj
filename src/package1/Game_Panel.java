package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Game_Panel extends JPanel implements MouseListener, A_GraphicSystem { //, A_InputSystem, MouseListener{

	private static final long serialVersionUID = 1L;
	
	//UserInput variables
	private boolean newInput = false;
	private int mousePressedX, mousePressedY, mouseMovedX, mouseMovedY, mouseButton;
	private char keyPressed;
	
	
	//for Double Buffering (classes used here are from the awt library):
	private GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	private BufferedImage imageBuffer;
	private Graphics graphics;
	
	private static final Color COLOR_obj = new Color(39, 40, 109);
	private static final int RADIUS_obj = 20;
	
	public Game_Panel() {
		this.setSize(1000, 800);
		imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(),  this.getHeight());
		
		graphics = imageBuffer.getGraphics();
		
		//initialize Listeners
		this.addMouseListener(this);
	}
	
	public void clear() { // for wiping the object
		Graphics gra = this.getGraphics();
		gra.setColor(Color.LIGHT_GRAY);
		gra.fillRect(0, 0, 1000, 800);
	}
	
	public void draw(A_GameObject obj) {
		Graphics gra = this.getGraphics();
		gra.setColor(COLOR_obj);
		gra.fillRect((int) obj.x-RADIUS_obj, (int)obj.y-RADIUS_obj, RADIUS_obj*2, RADIUS_obj*2);
	}

	public void redraw() { //redraw the whole updated screen
		this.getGraphics().drawImage(imageBuffer, 0, 0, this); //Image, int, int, ImageObserver
	}

//	@Override
//	public A_UserInput getUserInput() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void command(A_GameObject userObject, A_UserInput userInput) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
