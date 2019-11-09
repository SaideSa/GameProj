package prototyp;

import javax.swing.JFrame;

public class Massaker extends JFrame{
	
	public Massaker() {
		
		this.add(new Board());
		this.setTitle("Wüsten Massaer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setIgnoreRepaint(true);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Massaker();
	}

}
