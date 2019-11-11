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
	Fireball fireball;
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
			keys[i] = new Key(rand.nextInt((740 - 2) + 1) + 2, rand.nextInt((490 - 2) + 1) + 2);
		}
		// neuer Spieler
		player = new Player();
		fireball = new Fireball();
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
		if (fireball.isShot()) {
			g.drawImage(fireball.getImage(), fireball.getX(), fireball.getY(), fireball.getWidth(),
					fireball.getHeight(), this);
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
			fireball.shot(e);
		}

		public void setFireball() {
			fireball.x = player.getX();
			fireball.y = player.getY();
		}

	}

	class ScheduleTask extends TimerTask {
		public void run() {
			// Spielerbewegung
			player.move();
			// Kaktusbewegung
			cactusMove();
//			// Schießen
			shoot();
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
			if (cactus.getRect().intersects(player.getRect())) {
				if (JOptionPane.showConfirmDialog(null, "Game Over! Restart?", "WARNING",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					label.lose();
					gameInit();
				} else {
					System.exit(0);
				}
			}
		}
		if (fireball.isShot()) {
			if (fireball.getRect().intersects(cactus.getRect())) {
				cactus.setDestroyed(true);
				fireball.setShot(false);
			}
		}
	}

	public void cactusMove() {
		// Kaktus soll immer in die Richtung des Spielers laufen
		int X = player.getX() - cactus.getX();
		int Y = player.getY() - cactus.getY();
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

	public void shoot() {
//		fireball.setXDir(2);
//		fireball.setYDir(2);
		int X = cactus.getX() - fireball.getX();
		int Y = cactus.getY() - fireball.getY();
		if (X != 0) {
			fireball.setXDir(X / Math.abs(X));
		} else {
			fireball.setXDir(0);
		}
		if (Y != 0) {
			fireball.setYDir(Y / Math.abs(Y));
		} else {
			fireball.setYDir(0);
		}
		fireball.move();
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
