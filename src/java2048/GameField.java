package java2048;

public class GameField {
	private int size;

	public GameField(int size) {
		this.size = size;
	}

	public int[][] getField() {
		// TODO Auto-generated method stub
		return new int[size][size];
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasChanged() {
		// TODO Auto-generated method stub
		return false;
	}

}
