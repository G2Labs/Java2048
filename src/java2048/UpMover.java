package java2048;

public class UpMover extends GameMover {

	public UpMover() {
	}

	public UpMover(int[][] field) {
		move(field);
	}

	@Override
	public void move(int[][] field) {
		int size = field.length;

		changed = false;
		score = 0;
		result = new int[size][size];

		for (int x = 0; x < size; x++) {
			GameShifter gs = new GameShifter();
			for (int y = 0; y < size; y++)
				gs.add(field[x][y]);

			gs.move();

			for (int y = 0; y < gs.size(); y++)
				result[x][y] = gs.get(y);

			changed |= gs.hasChanged();
			score += gs.getScore();
		}
	}
}
