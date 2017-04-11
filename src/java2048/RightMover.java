package java2048;

public class RightMover extends GameMover {
	@Override
	public String getName() {
		return "RIGHT";
	}

	@Override
	public int[][] move(int[][] field) {
		int size = field.length;

		changed = false;
		score = 0;
		result = new int[size][size];

		for (int y = 0; y < size; y++) {
			GameShifter gs = new GameShifter();
			for (int x = size - 1; x >= 0; x--)
				gs.add(field[x][y]);

			gs.move();

			for (int x = 0; x < gs.size(); x++)
				result[size - 1 - x][y] = gs.get(x);

			changed |= gs.hasChanged();
			score += gs.getScore();
		}
		return result;
	}
}
