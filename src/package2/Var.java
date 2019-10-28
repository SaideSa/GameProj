package package2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Var {
	static JFrame jf1;
	static int screenwidth = 800;
	static int screenheight = 600;
	static int backgroundY1 = 0;
	static int backgroundY2 = -600;
	static int backgroundspeed = 9;
	static int speedup =3, speeddown =2, speedleft =2, speedright =2;
	static int x = 400;
	static int y = 400;
	static boolean moveup=false,movedown=false,moveleft=false,moveright=false;
	static Label lbl1;
	
	static BufferedImage ih1,ih2;
	static BufferedImage ispieler;
	
	public Var() {
		try {
			//Hintergrund
			ih1 = ImageIO.read(new File ("rsc2/hintergrund1.png"));
			ih2 = ImageIO.read(new File ("rsc2/hintergrund1.png"));
			//Spieler
			ispieler = ImageIO.read(new File ("rsc2/spieler.png"));
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Bilder konnten nicht geladen werden");
		}
		
	}

}
