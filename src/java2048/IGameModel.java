package java2048;

public interface IGameModel {
	public int getScore();

	public int getTurn();

	public int[][] getGameField();

	public void restart();

	public void moveUp();

	public void moveDown();

	public void moveLeft();

	public void moveRight();
}
