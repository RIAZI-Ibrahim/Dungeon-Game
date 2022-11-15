package donjon.game.states;

import donjon.framework.gamestates.GameState;
import donjon.framework.gamestates.GameStateManager;
import donjon.framework.gui.WindowManager;
import donjon.framework.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends GameState {

	private String[] optionsMenu;
	private static final String START_GAME_EASY = "Start Game easy mode!";
	private static final String START_GAME_HARD = "Start Game hard mode!";
	private static final String QUIT_GAME = "Quit game";
	private int selected;
		
	public MainMenu(GameStateManager manager) {
		super(manager);
		this.optionsMenu = new String[] {START_GAME_EASY, START_GAME_HARD, QUIT_GAME};
		this.selected = 0;
	}

	@Override
	protected void loop() {
	}

	@Override
	protected void render(Graphics graphics) {
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
		graphics.drawImage(Resources.TEXTURES.get(21), 0, 5, 500, 500, null);
		graphics.setFont(new Font("Araial", Font.PLAIN, 25));
		for(int i=0;i<this.optionsMenu.length;i++) {
			if(i==this.selected) graphics.setColor(Color.WHITE);
			else graphics.setColor(Color.RED);
			graphics.drawString(this.optionsMenu[i], 480, 185 + i * 40);
		}
	}

	@Override
	protected void keyPressed(int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(this.selected > 0) this.selected--;
			break;
		case KeyEvent.VK_DOWN:
			if(this.selected < this.optionsMenu.length-1) this.selected++;
			break;
		case KeyEvent.VK_ENTER:
			switch(this.optionsMenu[selected]) {
			case START_GAME_EASY:
				super.gameStateManager.stackState(new PlayingStateEasyMode(gameStateManager));
				break;
				case START_GAME_HARD:
				super.gameStateManager.stackState(new PlayingStateHardMode(gameStateManager));
				break;
			case QUIT_GAME:
				System.exit(0);
				break;
			}
			break;
		}
	}

	@Override
	protected void keyReleased(int keyCode) {}
}
