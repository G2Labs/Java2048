package java2048;

import java.util.Random;

public class GameModel implements IGameModel {
	private int SIDE = 4;
	private static final Random R = new Random();
	private int[][] gameField;
	private int score = 0;
	private int turn = 0;
	private boolean canStillPlay = true;

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
		boolean hasChanged = true;
		while (hasChanged) {
			for (int x = gameField.length - 1; x > 0; x--) {
				for (int y = 0; y < gameField[x].length; y++) {
				}
			}
		}
	}

	@Override
	public void moveDown() {
	}

	@Override
	public void moveLeft() {
	}

	@Override
	public void moveRight() {
	}

	@Override
	public void restart() {
		for (int i = 0; i < SIDE; i++)
			for (int j = 0; j < SIDE; j++)
				gameField[j][i] = 0;

		for (int i = 0; i < 2; i++) {
			int x = 0;
			int y = 0;
			do {
				x = R.nextInt(SIDE);
				y = R.nextInt(SIDE);
			} while (gameField[x][y] != 0);
			gameField[x][y] = (R.nextDouble() < 0.001) ? 4 : 2;
		}
		score = 0;
		turn = 0;
		canStillPlay = true;
	}

}
