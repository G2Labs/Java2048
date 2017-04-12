package java2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView extends Thread implements IGameView {
	private IGameControllerFeedback feedback;

	public ConsoleView() {
		System.out.println("Welcome in the 2048 game - console mode");
		start();
	}

	@Override
	public void attatchInputListener(IGameControllerFeedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public void run() {
		BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = "";
			try {
				input = stream.readLine();
			} catch (IOException e) {
			}
			if (input.contains("w")) {
				feedback.reactForUp();
				continue;
			}
			if (input.contains("s")) {
				feedback.reactForDown();
				continue;
			}
			if (input.contains("a")) {
				feedback.reactForLeft();
				continue;
			}
			if (input.contains("d")) {
				feedback.reactForRight();
				continue;
			}
			if (input.contains("r")) {
				feedback.reactForReset();
				continue;
			}
			if (input.contains("u")) {
				feedback.reactForUndo();
				continue;
			}
			if (input.contains("q")) {
				break;
			}
		}
	}

	@Override
	public void setGameField(int[][] numbers) {
		StringBuilder sb = new StringBuilder();
		if (numbers.length > 0)
			for (int y = 0; y < numbers[0].length; y++) {
				sb.append("|");
				for (int x = 0; x < numbers.length; x++) {
					sb.append(String.format("%9d", numbers[x][y])).append("|");
				}
				sb.append("\n");
			}
		System.out.println("=========================================");
		System.out.print(sb.toString());
		System.out.println("=========================================");
	}

	@Override
	public void setScore(int score) {
		System.out.println(" Score: " + score);
	}

	@Override
	public void setStatus(String text) {
		System.out.println("Status: " + text);
	}

	@Override
	public void setTurn(int turn) {
		System.out.println("  Turn: " + turn);
	}
}
