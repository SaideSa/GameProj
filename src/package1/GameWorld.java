package package1;

public class GameWorld extends A_World {
	
	protected void init()
	{
//	gameObjects.add(new Gam03_Avatar(400,500));
//	for(int i=0; i<20; i++)
//	{
	double x = 1000*Math.random();
	double y = 800*Math.random();
	double a = Math.PI*2*Math.random();
	double s = 100+100*Math.random();
//	Gam03_Dot dot = new Gam03_Dot(x,y,a,s);
	Cactus cactus = new Cactus(x, y, a, s);
	gameObjects.add(cactus);
//	}
	}
}
//	private Game_Panel gamePanel;
//	private Cactus cactus;
//	
//	public void init() {
//		cactus = new Cactus(100, 400); //x- and y-position
//	}
//	
//	public void run() {
//		long lastTick = System.currentTimeMillis();
//		while(true) {
//			//calculate elapsed time
//			long currentTick = System.currentTimeMillis();
//			double diffSeconds = (currentTick-lastTick)/1000.0;
//			lastTick = currentTick;
//			
////			long start = System.currentTimeMillis();
//			cactus.move(diffSeconds);
//			gamePanel.clear();
//			gamePanel.draw(cactus);
//			gamePanel.redraw();
//			
////			long diff = System.currentTimeMillis()-start;
////			//Timer inside the game loop for a constant FPS (so it doesn't depend on the computers performance
////			//20 ms - time for calculating and display drawing
////			if(diff < 20) {
////				try { 
////					Thread.sleep(20-diff); //ohne diff wäre es 20 ms + time for Dot moving & display drawing
////				}catch(Exception ex) {
////					
////				}
////			}
//			
//		}
//	}
//
//	public void setGraphicSystem(Game_Panel panel) {
//		this.gamePanel = panel;
//	}
//	
//	
//}
