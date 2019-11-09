package prototyp;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	int keys = 0;
	JLabel keyCounter;
	
	public Label() {
		keyCounter = new JLabel("Schl�ssel: " + keys);
	}
	
	public void collectKey() {
		keyCounter.setText("Schl�ssel: " + keys);;
	}
	
	public void restart() {
		keys = 0;
		keyCounter.setText("Schl�ssel: " + keys);
	}
	
	

}
