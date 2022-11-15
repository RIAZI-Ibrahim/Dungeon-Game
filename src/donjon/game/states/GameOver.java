package donjon.game.states;

import donjon.framework.gamestates.GameState;
import donjon.framework.gamestates.GameStateManager;
import donjon.framework.gui.WindowManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOver extends GameState {

	private String[] optionsMenu;
	private static final String START_GAME_EASY = "Start Game easy mode!";
	private static final String START_GAME_HARD = "Start Game hard mode!";
	private static final String QUIT_GAME = "Quit game";
	private int selected;

	public GameOver(GameStateManager manager) {
		super(manager);
	}

	@Override
	protected void loop() {
	}

	@Override
	protected void render(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
		graphics.setFont(new Font("Araial", Font.PLAIN, 25));
		graphics.setColor(Color.RED);
		graphics.drawString("Game over", 400, 225);
	}

	@Override
	protected void keyPressed(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_ENTER:
			super.gameStateManager.stackState(new MainMenu(gameStateManager));
			break;
		}
	}

	@Override
	protected void keyReleased(int keyCode) {}
}
