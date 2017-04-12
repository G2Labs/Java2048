package java2048;

public class GameController implements IGameControllerFeedback {
	private IGameView view;
	private IGameModel model;

	public GameController(IGameView view, IGameModel model) {
		this.view = view;
		this.model = model;
		this.view.attatchInputListener(this);
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
	public void reactForReset() {
		model.restart();
		redisplay();
	}

	@Override
	public void reactForRight() {
		model.moveRight();
		redisplay();
	}

	@Override
	public void reactForUndo() {
		model.moveUndo();
		redisplay();
	}

	@Override
	public void reactForUp() {
		model.moveUp();
		redisplay();
	}

	private void redisplay() {
		view.setGameField(model.getGameField());
		view.setScore(model.getScore());
		view.setTurn(model.getTurn());
		view.setStatus(model.getLastMove());
	}

}
