package java2048;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameView extends JFrame implements IGameView, KeyListener {
	private static final int DIMENSION = 50;
	private static final int SIDE = 4;

	IGameControllerFeedback feedback = null;

	JPanel gamePanel = new JPanel();
	JTextField[] gameField = new JTextField[SIDE * SIDE];
	JPanel statusPanel = new JPanel();
	JLabel scoreLabel = new JLabel("Score:");
	JLabel scoreResultLabel = new JLabel("");
	JLabel turnLabel = new JLabel("Turn:");
	JLabel turnResultLabel = new JLabel("");

	public GameView() {
		setLayout(new BorderLayout());
		configureGamePanel();
		configureStatusPanel();
		setMinimumSize(new Dimension(SIDE * DIMENSION, (SIDE + 1) * DIMENSION));
		setResizable(false);
		setVisible(true);
		addKeyListener(this);
	}

	private void configureGamePanel() {
		gamePanel.setPreferredSize(new Dimension(SIDE * DIMENSION, SIDE * DIMENSION));
		gamePanel.setLayout(new GridLayout(SIDE, SIDE));
		for (int i = 0; i < gameField.length; i++) {
			gameField[i] = new JTextField();
			gameField[i].setEnabled(false);
			gameField[i].setHorizontalAlignment(JTextField.CENTER);
			gameField[i].setText("");
			gamePanel.add(gameField[i]);
		}
		add(gamePanel, BorderLayout.CENTER);
	}

	private void configureStatusPanel() {
		statusPanel.setPreferredSize(new Dimension(SIDE * DIMENSION, DIMENSION));
		statusPanel.setLayout(new GridLayout(2, 2));
		statusPanel.add(scoreLabel);
		statusPanel.add(scoreResultLabel);
		statusPanel.add(turnLabel);
		statusPanel.add(turnResultLabel);
		add(statusPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void setGameField(int[] numbers) {
		for (int i = 0; (i < numbers.length) && (i < (SIDE * SIDE)); i++) {
			String text = "";
			int num = numbers[i];
			if (num > 1) {
				if (num > 512 * 1024) {
					num /= (1024 * 1024);
					text = num + "M";
				} else if (num > 512) {
					num /= 1024;
					text = num + "k";
				} else
					text = num + "";
			}
			gameField[i].setText(text);
		}
	}

	@Override
	public void setScore(int score) {
		scoreResultLabel.setText("" + score);
	}

	@Override
	public void setTurn(int turn) {
		turnResultLabel.setText("" + turn);
	}

	@Override
	public void attatchInputListener(IGameControllerFeedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (null == feedback)
			return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			feedback.reactForUp();
			break;
		case KeyEvent.VK_DOWN:
			feedback.reactForDown();
			break;
		case KeyEvent.VK_LEFT:
			feedback.reactForLeft();
			break;
		case KeyEvent.VK_RIGHT:
			feedback.reactForRight();
			break;
		case KeyEvent.VK_R:
			feedback.reactForReset();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
