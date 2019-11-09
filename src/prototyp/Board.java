package prototyp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Board extends JPanel{
	
	Timer timer;
	Cactus cactus;
	Player player;
	Key key;
	Label label = new Label();
	
	public Board() {
		
		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.ORANGE);
		this.add(label.keyCounter);
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
		
		gameInit();

		
	}
	
	public void gameInit() {
		//neuer Kaktus
		cactus = new Cactus();
		//neuer Schlüssel an der Position 700 / 500
		key = new Key(700, 500);
		//neuer Spieler
		player = new Player();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//Kaktus zeichnen
		g.drawImage(cactus.getImage(), cactus.getX(), cactus.getY(), cactus.getWidth(), cactus.getHeight(), this);
		//Spieler zeichnen
		g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
		//Schlüssel nur zeichnen wenn er noch nicht eingesammelt wurde
		if(key.isVisible()) {
			g.drawImage(key.getImage(), key.getX(), key.getY(), key.getWidth(), key.getHeight(), this);
		}
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	private class TAdapter extends KeyAdapter {
		
		//Spieler soll sich nicht weiterbewegen wenn man von der Taste geht
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
		//Spieler bewegt sich bei Tastendruck
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
	}
	
	class ScheduleTask extends TimerTask{
		public void run() {
			//Spielerbewegung
			player.move();
			//Kaktusbewegung
			cactusMove();
			//Kollusionscheck
			checkCollusion();
			repaint();
			
		}
	}
	
	public void checkCollusion() {
		
		//Schlüssel verschwindet bei Kollision mit Spieler
		if(player.getRect().intersects(key.getRect())) {
			//Schlüsselzähler geht nach oben
			if(key.isVisible()) {
				label.keys++;
				label.collectKey();
			}
			key.setVisible(false);
			
			//checkCollusion mit Kaktus fehlt noch
		}
	}
	
	public void cactusMove() {
		//Kaktus soll immer in die Richtung des Spielers laufen (funktioniert noch nicht)
		cactus.setXDir((player.getX()-cactus.getX())/100);
		cactus.setYDir((player.getY()-cactus.getY())/100);
		cactus.move();
	}

}
