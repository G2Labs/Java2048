package java2048;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements IGameModel {
	private int SIDE = 4;
	private List<GameMover> history = new ArrayList<>();
	private int score = 0;
	private int turn = 0;
	private boolean canStillPlay = true;

	public GameModel(int side) {
		SIDE = side;
		restart();
	}

	@Override
	public int[][] getGameField() {
		return history.get(turn).getField();
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getTurn() {
		return turn;
	}

	private void makeMove(GameMover gm) {
		int[][] field = history.get(turn).getField();
		gm.move(field);
		field = gm.getField();
		score += gm.getScore();
		if (gm.hasChanged()) {
			field = gm.getField();
			GameMover r = new RandomInputter();
			r.move(field);

			history.add(r);
			turn++;
		}
	}

	@Override
	public void moveDown() {
		makeMove(new DownMover());
	}

	@Override
	public void moveLeft() {
		makeMove(new LeftMover());
	}

	@Override
	public void moveRight() {
		makeMove(new RightMover());
	}

	@Override
	public void moveUp() {
		makeMove(new UpMover());
	}

	@Override
	public void restart() {
		int[][] f = new int[SIDE][SIDE];
		GameMover gm = new RandomInputter();
		gm.move(f);
		f = gm.getField();
		gm.move(f);
		history.clear();
		history.add(gm);
		setInitialConditions();
	}

	private void setInitialConditions() {
		score = 0;
		turn = 0;
		canStillPlay = true;
	}

}
