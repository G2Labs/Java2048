package java2048;

public interface IGameView {
	public void setGameField(String[] numbers);

	public void setScore(int score);

	public void setTurn(int turn);

	public void attatchInputListener(IGameControllerFeedback feedback);
}
