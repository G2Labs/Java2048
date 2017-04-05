package java2048;

public class Java2048 {

	public static void main(String[] args) {
		int side = 8;
		IGameView gv = new GameView(side);
		IGameModel gm = new GameModel(side);
		GameController gc = new GameController(gv, gm);
		gv.attatchInputListener(gc);
	}

}
