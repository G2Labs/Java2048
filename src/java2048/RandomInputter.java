package java2048;

public class RandomInputter extends GameMover {

	@Override
	public String getName() {
		return "RESET";
	}

	@Override
	public int[][] move(int[][] field) {
		int size = field.length;
		score = 0;
		changed = true;
		result = new int[size][size];

		generateNewNumber();
		generateNewNumber();
		return result;
	}
}
