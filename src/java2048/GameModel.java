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
	public boolean canPlay() {
		return canStillPlay;
	}

	private boolean checkIfHasMembers() {
		int[][] f = history.get(turn).getField();
		boolean has = false;

		for (int x = 0; x < f.length; x++)
			for (int y = 0; y < f.length; y++) {
				if (0 == f[x][y])
					has |= true;
				if ((x > 0) && (f[x][y] == f[x - 1][y]))
					has |= true;
				if ((x < f.length - 1) && (f[x][y] == f[x + 1][y]))
					has |= true;
				if ((y > 0) && (f[x][y] == f[x][y - 1]))
					has |= true;
				if ((y < f.length - 1) && (f[x][y] == f[x][y + 1]))
					has |= true;
			}
		canStillPlay = has;
		return has;
	}

	@Override
	public int[][] getGameField() {
		if (history.isEmpty())
			return new int[SIDE][SIDE];
		return history.get(turn).getField();
	}

	@Override
	public String getLastMove() {
		if (history.isEmpty())
			return "";
		if (!canStillPlay)
			return "GAME OVER";
		return history.get(turn).getName();
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
		if (!checkIfHasMembers())
			return;

		gm.move(history.get(turn).getField());
		score += gm.getScore();
		if (gm.hasChanged()) {
			gm.generateNewNumber();

			history.add(gm);
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
	public void moveUndo() {
		if (history.size() < 2)
			return;

		score -= history.remove(turn--).getScore();
		checkIfHasMembers();
	}

	@Override
	public void moveUp() {
		makeMove(new UpMover());
	}

	@Override
	public void restart() {
		GameMover gm = new RandomInputter();
		gm.move(new int[SIDE][SIDE]);
		history.clear();
		history.add(gm);
		score = 0;
		turn = 0;
		canStillPlay = true;
	}
}
