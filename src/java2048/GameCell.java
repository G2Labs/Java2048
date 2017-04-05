package java2048;

public class GameCell {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	private int x, y, value;

	public GameCell(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getValue() {
		return value;
	}

	public boolean willCollide(GameCell gameCell, int direction) {
		if (this.value != gameCell.value)
			return false;
		switch (direction) {
		case UP:
			return ((this.x == gameCell.x) && (this.y + 1 == gameCell.y));
		case DOWN:
			return ((this.x == gameCell.x) && (this.y - 1 == gameCell.y));
		case LEFT:
			return ((this.x + 1 == gameCell.x) && (this.y == gameCell.y));
		case RIGHT:
			return ((this.x - 1 == gameCell.x) && (this.y == gameCell.y));
		default:
			return false;
		}
	}

	public GameCell collideWith(GameCell gc2, int direction) {
		if (!willCollide(gc2, direction))
			return null;
		int newX = x;
		int newY = y;
		switch (direction) {
		case UP:
			newY = (y > gc2.y) ? gc2.y : y;
			break;
		case DOWN:
			newY = (y < gc2.y) ? gc2.y : y;
			break;
		case LEFT:
			newX = (x > gc2.x) ? gc2.x : x;
			break;
		case RIGHT:
			newX = (x < gc2.x) ? gc2.x : x;
			break;
		default:
			break;
		}
		return new GameCell(newX, newY, value * 2);
	}

	@Override
	public boolean equals(Object obj) {
		GameCell other = (GameCell) obj;
		return ((x == other.x) && (y == other.y) && (value == other.value));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[x: ").append(x).append("; y: ").append(y).append("; val: ");
		sb.append(value).append("]");
		return sb.toString();
	}

}
