package prototyp;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	int keys = 0;
	JLabel keyCounter;
	int win = 0;
	int loss = 0;
	JLabel winLoss;
	
	public Label() {
		keyCounter = new JLabel("Schlüssel: " + keys);
		winLoss = new JLabel("Wins: " + win + " Losses: " + loss);
	}
	
	public void collectKey() {
		keyCounter.setText("Schlüssel: " + keys);;
	}
	
	public void restart() {
		keys = 0;
		keyCounter.setText("Schlüssel: " + keys);
	}
	
	public void win() {
		win++;
		winLoss.setText("Wins: " + win + " Losses: " + loss);
	}
	
	public void lose() {
		loss++;
		winLoss.setText("Wins: " + win + " Losses: " + loss);
	}
	
	

}
