package prototyp;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	int keys = 0;
	JLabel keyCounter;
	
	public Label() {
		keyCounter = new JLabel("Schlüssel: " + keys);
	}
	
	public void collectKey() {
		keyCounter.setText("Schlüssel: " + keys);;
	}
	
	public void restart() {
		keys = 0;
		keyCounter.setText("Schlüssel: " + keys);
	}
	
	

}
