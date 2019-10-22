package package1;

import java.util.ArrayList;

public abstract class A_World {
	 private A_GraphicSystem graphicSystem;
	// private A_InputSystem inputSystem;
	// private A_PhysicsSystem physicsSystem; //for collision detection
	// private A_UserInput userInput;
	// contains the games objects
	protected ArrayList<A_GameObject> gameObjects = new ArrayList<A_GameObject>();

	// demanded from actual implementation
	protected abstract void init();

	// protected abstract void processUserInput(A_UserInput input);
	//
	// public A_World() {
	// physicsSystem = new A_PhysicsSystem(this);
	// }

	public void run() {
		long lastTick = System.currentTimeMillis();
		//double diff_average = 0;
		while(true) {
			// calculate elapsed time
			//
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick-lastTick)/1000.0;
			lastTick = currentTick;
		/**
		int numObjects = gameObjects.size();
		diff_average = 0.98*diff_average+0.02*diffSeconds;
		System.out.print("fps: "+(int)(1.0/diff_average));
		System.out.print(" obj: "+numObjects);
		System.out.println();
		**/

			
			// process User Input
//			userInput = inputSystem.getUserInput();
//			if(userInput!=null) { 
//				processUserInput(userInput);
//			}
// move all Objects
		for(int i=0; i<gameObjects.size(); i++) {
			gameObjects.get(i).move(diffSeconds);
		}
		// draw all Objects
		graphicSystem.clear();
		if(gameObjects.size() > 1) { //wenn Objekte auﬂer Avatar da sind dann
			for(int i=1; i<gameObjects.size(); i++) {
				graphicSystem.draw(gameObjects.get(i));
			}
		}
		// draw Avatar zuletzt weil Avatar vor den Objekten
		graphicSystem.draw(gameObjects.get(0));
		// redraw everything
		graphicSystem.redraw();
		}
		
	}

	public void setGraphicSystem(A_GraphicSystem p) {
		graphicSystem = p;
	}

//	public void setInputSystem(A_InputSystem p) {
//		inputSystem = p;
//	}
//	
//	public A_PhysicsSystem getPhysicsSystem() { return physicsSystem; }
//	}
}
