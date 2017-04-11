package java2048;

public interface IGameControllerFeedback {
	public void reactForDown();

	public void reactForLeft();

	public void reactForReset();

	public void reactForRight();

	public void reactForUndo();

	public void reactForUp();
}
