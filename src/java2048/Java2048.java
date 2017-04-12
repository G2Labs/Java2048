package java2048;

public class Java2048 {

	private static int getGameFieldSize(String[] args) {
		int side = 4;
		if (args.length > 0) {
			try {
				side = Integer.parseInt(args[0]);
				side = (side < 1) ? 2 : side;
			} catch (NumberFormatException e) {
			}
		}
		return side;
	}

	public static void main(String[] args) {
		int side = getGameFieldSize(args);
		IGameView gv = new ConsoleView();// new GameView(side);
		IGameModel gm = new GameModel(side);
		new GameController(gv, gm);
	}

}
