package java2048;

public class LeftMover extends GameMover {

	@Override
	public void move(int[][] field) {
		int size = field.length;

		changed = false;
		score = 0;
		result = new int[size][size];

		for (int y = 0; y < size; y++) {
			GameShifter gs = new GameShifter();
			for (int x = 0; x < size; x++)
				gs.add(field[x][y]);

			gs.move();

			for (int x = 0; x < gs.size(); x++)
				result[x][y] = gs.get(x);

			changed |= gs.hasChanged();
			score += gs.getScore();
		}
	}
}
