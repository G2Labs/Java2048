package java2048;

public abstract class GameMover {
	protected int[][] result = new int[0][0];
	protected boolean changed = false;
	protected int score = 0;

	public abstract void move(int[][] field);

	public boolean hasChanged() {
		return changed;
	}

	public int[][] getField() {
		return result;
	}

	public int getScore() {
		return score;
	}
}
