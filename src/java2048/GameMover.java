package java2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameMover {

	private class Point {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	protected int[][] result = new int[0][0];
	protected boolean changed = false;
	protected int score = 0;

	public int[][] generateNewNumber() {
		List<Point> points = new ArrayList<>();
		int size = result.length;
		changed = false;

		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++) {
				if (result[x][y] == 0)
					points.add(new Point(x, y));
			}

		if (points.size() < 1)
			return result;

		Random R = new Random();
		int num = R.nextInt(points.size());
		int val = (R.nextDouble() < 0.001) ? 4 : 2;
		int x = points.get(num).getX();
		int y = points.get(num).getY();
		result[x][y] = val;
		return result;
	}

	public int[][] getField() {
		return result;
	}

	public abstract String getName();

	public int getScore() {
		return score;
	}

	public boolean hasChanged() {
		return changed;
	}

	public abstract int[][] move(int[][] field);
}
