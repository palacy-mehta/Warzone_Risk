package app.warzone.game;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.warzone.Main.Phase;

/**
 * Test class for the GameEngine class, which is responsible for game
 * management. This class contains test cases for the initialization of the game
 * and user input handling.
 */
public class GameEngineTest {

	private GameEngine gameEngine;
	private InputStream originalSystemIn;

	/**
	 * Setup method to initialize the GameEngine and store the original System.in
	 * stream.
	 */
	@Before
	public void setUp() {
		gameEngine = new GameEngine();
		originalSystemIn = System.in;
	}

	/**
	 * Test the initialization of the game with invalid user input. To check that
	 * the game phase is not set to STARTUP when invalid input is provided.
	 */
	@Test
	public void testInitializeInvalidChoice() {
		String userInput = "invalid\n";
		InputStream userInputInputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(userInputInputStream);
		gameEngine.initialize();
		assertNotEquals(Phase.STARTUP, gameEngine.getD_currPhase());
	}

	/**
	 * Test the initialization of the game when the user quits. To ensure that the
	 * game phase is not set to STARTUP when the user quits.
	 */
	@Test
	public void testInitializeQuit() {
		String userInput = "3\n";
		InputStream userInputInputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(userInputInputStream);
		gameEngine.initialize();
		assertNotEquals(Phase.STARTUP, gameEngine.getD_currPhase());
	}

	/**
	 * To restore the original System.in stream after testing.
	 */
	@After
	public void tearDown() {
		System.setIn(originalSystemIn);
	}
}
