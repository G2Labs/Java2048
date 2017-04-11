package java2048;

public interface IGameView {
	public void attatchInputListener(IGameControllerFeedback feedback);

	public void setGameField(int[][] numbers);

	public void setStatus(String text);

	public void setScore(int score);

	public void setTurn(int turn);
}
