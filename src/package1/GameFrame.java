package package1;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	private Game_Panel panel = null;
	
	public GameFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		
		panel = new Game_Panel();
		this.setContentPane(panel);
		
	}

	public Game_Panel getPanel() {
		return panel;
	}
	
	
}
