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
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Board extends JPanel {

	Timer timer;
	Cactus cactus;
	Player player;
	Key[] keys;
//	Fireball fireball;
	Bomb bomb;
	Label label = new Label();
	Random rand = new Random();

	public Board() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		keys = new Key[3];
		this.setBackground(Color.ORANGE);
		this.add(label.keyCounter);
		this.add(label.winLoss);
		

		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);

		gameInit();

	}

	public void gameInit() {
		// neuer Kaktus
		cactus = new Cactus();
		// drei Schlüssel an Random Positionen
		for (int i = 0; i <= 2; i++) {
			keys[i] = new Key(rand.nextInt((1326 - 2) + 1) + 2, rand.nextInt((658 - 2) + 1) + 2);
//			keys[i] = new Key(rand.nextInt((740 - 2) + 1) + 2, rand.nextInt((490 - 2) + 1) + 2);
		}
		// neuer Spieler
		player = new Player();
//		fireball = new Fireball();
		bomb = new Bomb();
		label.restart();

	}

	public void paint(Graphics g) {
		super.paint(g);

		// Kaktus zeichnen
		if (!cactus.isDestroyed()) {
			g.drawImage(cactus.getImage(), cactus.getX(), cactus.getY(), cactus.getWidth(), cactus.getHeight(), this);
		}
		// Spieler zeichnen
		g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
		// Schlüssel nur zeichnen wenn er noch nicht eingesammelt wurde
		for (int i = 0; i <= 2; i++) {
			if (keys[i].isVisible()) {
				g.drawImage(keys[i].getImage(), keys[i].getX(), keys[i].getY(), keys[i].getWidth(), keys[i].getHeight(),
						this);
			}
		}
		
//		if(fireball.shot) {
//			g.drawImage(fireball.getImage(), fireball.getX(), fireball.getY(), fireball.getWidth(), fireball.getHeight(), this);
//			
//		}
		
		//Bombe zeichnen
		if(bomb.dropped){
			g.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight(), this);
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
//			fireball.shot(e, player.getX(), player.getY());
			bomb.keyPressed(e, player.getX(), player.getY());
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
			// Win wenn man drei Schlüssel gesammelt hat
			checkWin();
			repaint();

		}
	}

	public void checkCollusion() {

		// Schlüssel verschwindet bei Kollision mit Spieler
		for (int i = 0; i <= 2; i++) {
			if (player.getRect().intersects(keys[i].getRect())) {
				// Schlüsselzähler geht nach oben
				if (keys[i].isVisible()) {
					label.keys++;
					label.collectKey();
				}
				keys[i].setVisible(false);
			}
		}
		if (!cactus.isDestroyed()) {
			//zwei kleine Rechtecke unten an den Figuren
			Rectangle p = new Rectangle(player.getX()+20, player.getY()+75, 10, 10);
			Rectangle c = new Rectangle(cactus.getX()+43, cactus.getY()+115, 10, 10);
			//wenn die Rechtecke sich überschneiden = Kollusion --> Kaktus & Player
			//können "hintereinander" laufen
			if(p.intersects(c)) {
				if (JOptionPane.showConfirmDialog(null, "Game Over! Restart?", "WARNING",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					label.lose();
					gameInit();
				} else {
					System.exit(0);
				}
			}
		}
		
//		if(fireball.shot) {
//			if(fireball.getRect().intersects(cactus.getRect())) {
//				cactus.setDestroyed(true);
//				fireball.setShot(false);
//			}
//		}
		
		if(bomb.dropped) {
			if(cactus.getRect().intersects(bomb.getRect())) {
				cactus.setDestroyed(true);
				bomb.dropped = false;
			}
		}
	}

	public void cactusMove() {
		// Kaktus soll immer in die Richtung des Spielers laufen
		int X = player.getX() - cactus.getX() - 15;
		int Y = (player.getY()+player.getHeight()) - (cactus.getY()+cactus.getHeight());
		
		if (X != 0) {
			cactus.setXDir(X / Math.abs(X));
		} else {
			cactus.setXDir(0);
		}
		if (Y != 0) {
			cactus.setYDir(Y / Math.abs(Y));
		} else {
			cactus.setYDir(0);
		}
		cactus.move();
	}

	public void checkWin() {
		// Wenn man drei Schlüssel gesammelt hat komm ein Pop up
		if (label.keys == 3) {
			if (JOptionPane.showConfirmDialog(null, "You Win! Restart?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				label.win();
				gameInit();
			} else {
				System.exit(0);
			}
		}
	}

}
