package package2;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Gui {

	public Gui() {
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth,Var.screenheight); //Fensterbreite/-höhe
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.setLocationRelativeTo(null); //Fenster erscheint mittig
		Var.jf1.setLayout(null); //kein bestimmtes Layout
		Var.jf1.setName("Wüsten Massaker");
		Var.jf1.setResizable(false); //dadurch kann man das Fenster nicht mehr vergrößern/verkleinern
		Var.jf1.requestFocus();
		Var.jf1.addKeyListener(new KeyHandler());
		Var.jf1.setVisible(true);
		
		Var.lbl1 = new Label();
		Var.lbl1.setBounds(0,0,Var.screenwidth,Var.screenheight);
		Var.lbl1.setVisible(true);
		Var.jf1.add(Var.lbl1);
	}

}
