package java2048;

public class Java2048 {

	public static void main(String[] args) {
		GameView gv = new GameView();
		Gamefeeback feedback = new Gamefeeback(gv);
		gv.attatchInputListener(feedback);
	}

	private static class Gamefeeback implements IGameControllerFeedback {
		private IGameView gv;

		public Gamefeeback(IGameView gv) {
			this.gv = gv;
		}

		@Override
		public void reactForUp() {
			int t[] = { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 1024 * 1024, 0, 1024 * 1024 * 2, 0 };
			gv.setScore(1);
			gv.setGameField(t);
		}

		@Override
		public void reactForDown() {
			gv.setScore(2);
		}

		@Override
		public void reactForLeft() {
			gv.setScore(3);
		}

		@Override
		public void reactForRight() {
			gv.setScore(4);
		}

		@Override
		public void reactForReset() {
			gv.setScore(0);
		}

	}

}
