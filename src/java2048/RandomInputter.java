package java2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputter extends GameMover {
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

	@Override
	public void move(int[][] field) {
		List<Point> points = new ArrayList<>();
		int size = field.length;
		result = new int[size][size];
		score = 0;
		changed = false;

		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++) {
				result[x][y] = field[x][y];
				if (field[x][y] == 0)
					points.add(new Point(x, y));
			}

		if (points.size() < 1)
			return;

		Random R = new Random();
		int num = R.nextInt(points.size());
		int val = (R.nextDouble() < 0.001) ? 4 : 2;
		int x = points.get(num).getX();
		int y = points.get(num).getY();
		result[x][y] = val;
	}
}
