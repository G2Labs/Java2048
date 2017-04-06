package java2048;

import java.util.List;
import java.util.Random;

public class GameModel implements IGameModel {
	private int SIDE = 4;
	private static final Random R = new Random();
	private int[][] gameField;
	private int score = 0;
	private int turn = 0;
	private boolean canStillPlay = true;
	private GameDecomposition gd = new GameDecomposition();

	public GameModel(int side) {
		SIDE = side;
		gameField = new int[SIDE][SIDE];
		restart();
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getTurn() {
		return turn;
	}

	@Override
	public int[][] getGameField() {
		return gameField;
	}

	@Override
	public void moveUp() {
		if (!canStillPlay)
			return;

		for (int x = 0; x < SIDE; x++) {
			gd.reset();
			for (int y = 0; y < SIDE; y++) {
				gd.add(gameField[x][y]);
				gameField[x][y] = 0;
			}
			score += gd.move();
			List<Integer> result = gd.getDecomposedList();

			for (int y = 0; y < result.size(); y++) {
				gameField[x][y] = result.get(y);
			}
		}
		if (gd.didChange())
			generateNewNumber();
	}

	@Override
	public void moveDown() {
		if (!canStillPlay)
			return;
		for (int x = 0; x < SIDE; x++) {
			gd.reset();
			for (int y = SIDE - 1; y >= 0; y--) {
				gd.add(gameField[x][y]);
				gameField[x][y] = 0;
			}
			score += gd.move();
			List<Integer> result = gd.getDecomposedList();

			for (int y = 0; y < result.size(); y++) {
				gameField[x][SIDE - y - 1] = result.get(y);
			}
		}
		if (gd.didChange())
			generateNewNumber();
	}

	@Override
	public void moveLeft() {
		if (!canStillPlay)
			return;
		for (int y = 0; y < SIDE; y++) {
			gd.reset();
			for (int x = 0; x < SIDE; x++) {
				gd.add(gameField[x][y]);
				gameField[x][y] = 0;
			}
			score += gd.move();
			List<Integer> result = gd.getDecomposedList();

			for (int x = 0; x < result.size(); x++) {
				gameField[x][y] = result.get(x);
			}
		}
		if (gd.didChange())
			generateNewNumber();
	}

	@Override
	public void moveRight() {
		if (!canStillPlay)
			return;
		for (int y = 0; y < SIDE; y++) {
			gd.reset();
			for (int x = SIDE - 1; x >= 0; x--) {
				gd.add(gameField[x][y]);
				gameField[x][y] = 0;
			}
			score += gd.move();
			List<Integer> result = gd.getDecomposedList();

			for (int x = 0; x < result.size(); x++) {
				gameField[SIDE - x - 1][y] = result.get(x);
			}
		}
		if (gd.didChange())
			generateNewNumber();
	}

	@Override
	public void restart() {
		clearTheField();
		generateTwoStartingNumbers();
		setInitialConditions();
	}

	private void clearTheField() {
		for (int i = 0; i < SIDE; i++)
			for (int j = 0; j < SIDE; j++)
				gameField[j][i] = 0;
	}

	private void generateNewNumber() {
		int cnt = 0;
		for (int x = 0; x < SIDE; x++) {
			for (int y = 0; y < SIDE; y++) {
				if (gameField[x][y] == 0)
					cnt++;
			}
		}
		if (cnt == 0) {
			canStillPlay = false;
			return;
		}

		int x;
		int y;
		do {
			cnt--;
			x = R.nextInt(SIDE);
			y = R.nextInt(SIDE);
		} while (gameField[x][y] != 0 && cnt > 0);
		gameField[x][y] = (R.nextDouble() < 0.001) ? 4 : 2;
		turn++;
	}

	private void generateTwoStartingNumbers() {
		generateNewNumber();
		generateNewNumber();
	}

	private void setInitialConditions() {
		score = 0;
		turn = 0;
		canStillPlay = true;
	}

}
