package java2048;

public class GameController implements IGameControllerFeedback {
	private IGameView view;
	private IGameModel model;

	public GameController(IGameView view, IGameModel model) {
		this.view = view;
		this.model = model;
		redisplay();
	}

	@Override
	public void reactForUp() {
		model.moveUp();
		redisplay();
	}

	@Override
	public void reactForDown() {
		model.moveDown();
		redisplay();
	}

	@Override
	public void reactForLeft() {
		model.moveLeft();
		redisplay();
	}

	@Override
	public void reactForRight() {
		model.moveRight();
		redisplay();
	}

	@Override
	public void reactForReset() {
		model.restart();
		redisplay();
	}

	private void redisplay() {
		int[][] gameField = model.getGameField();
		int l = gameField.length;
		String[] texts = new String[l * l];

		for (int i = 0; i < l * l; i++) {
			String text = "";
			int num = gameField[i / l][i % l];
			if (num > 1) {
				if (num > 512 * 1024) {
					num /= (1024 * 1024);
					text = num + "M";
				} else if (num > 512) {
					num /= 1024;
					text = num + "k";
				} else
					text = num + "";
			}
			texts[i] = text;
		}

		view.setGameField(texts);
		view.setScore(model.getScore());
		view.setTurn(model.getTurn());
	}

}
