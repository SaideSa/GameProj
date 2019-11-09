package prototyp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Board extends JPanel {

	Timer timer;
	Cactus cactus;
	Player player;
	Key[] keys;
	Label label = new Label();
	Random rand = new Random();

	public Board() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		keys = new Key[3];
		this.setBackground(Color.ORANGE);
		this.add(label.keyCounter);

		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);

		gameInit();

	}

	public void gameInit() {
		// neuer Kaktus
		cactus = new Cactus();
		// drei Schl�ssel an Random Positionen
		for (int i = 0; i <= 2; i++) {
			keys[i] = new Key(rand.nextInt((740 - 2) + 1) + 2, rand.nextInt((490 - 2) + 1) + 2);
		}
		// neuer Spieler
		player = new Player();
	}

	public void paint(Graphics g) {
		super.paint(g);

		// Kaktus zeichnen
		g.drawImage(cactus.getImage(), cactus.getX(), cactus.getY(), cactus.getWidth(), cactus.getHeight(), this);
		// Spieler zeichnen
		g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
		// Schl�ssel nur zeichnen wenn er noch nicht eingesammelt wurde
		for (int i = 0; i <= 2; i++) {
			if (keys[i].isVisible()) {
				g.drawImage(keys[i].getImage(), keys[i].getX(), keys[i].getY(), keys[i].getWidth(), keys[i].getHeight(),
						this);
			}
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	private class TAdapter extends KeyAdapter {

		// Spieler soll sich nicht weiterbewegen wenn man von der Taste geht
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}

		// Spieler bewegt sich bei Tastendruck
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

	}

	class ScheduleTask extends TimerTask {
		public void run() {
			// Spielerbewegung
			player.move();
			// Kaktusbewegung
			cactusMove();
			// Kollusionscheck
			checkCollusion();
			//Win wenn man drei Schl�ssel gesammelt hat
			checkWin();
			repaint();

		}
	}

	public void checkCollusion() {

		// Schl�ssel verschwindet bei Kollision mit Spieler
		for (int i = 0; i <= 2; i++) {
			if (player.getRect().intersects(keys[i].getRect())) {
				// Schl�sselz�hler geht nach oben
				if (keys[i].isVisible()) {
					label.keys++;
					label.collectKey();
				}
				keys[i].setVisible(false);
			}
		}
		if (cactus.getRect().intersects(player.getRect())) {
			JOptionPane.showMessageDialog(null, "Game Over!");
			System.exit(0);
		}
	}

	public void cactusMove() {
		// Kaktus soll immer in die Richtung des Spielers laufen (funktioniert noch
		// nicht)
		cactus.setXDir((player.getX() - cactus.getX()) / 150);
		cactus.setYDir((player.getY() - cactus.getY()) / 150);
		cactus.move();
	}
	
	public void checkWin() {
		//Wenn man drei Schl�ssel gesammelt hat komm ein Pop up
		if(label.keys == 3) {
			JOptionPane.showMessageDialog(null, "You win!");
			System.exit(0);
		}
	}

}
