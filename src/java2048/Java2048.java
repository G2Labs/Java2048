package java2048;

public class Java2048 {

	public static void main(String[] args) {
		int side = 5;
		IGameView gv = new GameView(side);
		IGameModel gm = new GameModel(side);
		new GameController(gv, gm);
	}

}
