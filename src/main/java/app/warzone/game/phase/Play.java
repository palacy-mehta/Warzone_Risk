package app.warzone.game.phase;

import app.warzone.game.GameEngine;

/**
 *	ConcreteState of the State pattern. In this example, defines behavior 
 *  for commands that are valid in this state, and for the others signifies  
 *  that the command is invalid. 
 *  
 *  This state represents a group of states, and defines the behavior 
 *  that is common to all the states in its group. All the states in its 
 *  group need to extend this class. 
 *  
 */
public abstract class Play extends Phase {

	Play(GameEngine p_ge) {
		super(p_ge); 
	}
	
	public void showMap() {
		System.out.println("map is being displayed");		
	}

	public void editCountry() {
		printInvalidCommandMessage(); 
	}

	public void saveMap() {
		printInvalidCommandMessage(); 
	}
	public void endGame() {
		ge.setPhase(new End(ge));
	}
}
