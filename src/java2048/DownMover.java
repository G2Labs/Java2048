package java2048;

public class DownMover extends GameMover {

	@Override
	public void move(int[][] field) {
		int size = field.length;

		changed = false;
		score = 0;
		result = new int[size][size];

		for (int x = 0; x < size; x++) {
			GameShifter gs = new GameShifter();
			for (int y = size - 1; y >= 0; y--)
				gs.add(field[x][y]);

			gs.move();

			for (int y = 0; y < gs.size(); y++)
				result[x][size - 1 - y] = gs.get(y);

			changed |= gs.hasChanged();
			score += gs.getScore();
		}
	}
}
