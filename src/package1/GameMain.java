package package1;

public class GameMain {

	 private GameWorld world = null;
	 
	  public GameMain()
	  {
	    GameFrame frame = new GameFrame(); //the game's window
	    frame.setVisible(true);
	   
	    world = new GameWorld(); //contains all gaming objects
	    world.setGraphicSystem(frame.getPanel()); //implemented by panel and assigned to the Frame
//	    world.setInputSystem(frame.getPanel());
	    world.init();
	    world.run();
	  }
	  public static void main(String[] args)
	  { 
		  new GameMain();
	  } 
	

}
