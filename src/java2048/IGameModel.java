package java2048;

public interface IGameModel {
	public boolean canPlay();

	public int[][] getGameField();

	public String getLastMove();

	public int getScore();

	public int getTurn();

	public void moveDown();

	public void moveLeft();

	public void moveRight();

	public void moveUndo();

	public void moveUp();

	public void restart();
}
