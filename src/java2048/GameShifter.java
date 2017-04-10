package java2048;

import java.util.ArrayList;
import java.util.List;

public class GameShifter {
	private List<Integer> list = new ArrayList<>();
	private int score = 0;
	private boolean wasZero = false;
	private boolean changed = false;

	public void add(int number) {
		if (number > 0) {
			changed |= wasZero;
			list.add(number);
		} else
			wasZero = true;
	}

	public void move() {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1)
				temp.add(list.get(i));
			else {
				int i0 = list.get(i).intValue();
				int i1 = list.get(i + 1).intValue();
				if (i0 == i1) {
					changed = true;
					temp.add(i0 * 2);
					score += i0 * 2;
					i++;
				} else
					temp.add(i0);
			}

		}
		list = temp;
	}

	public int get(int number) {
		return list.get(number);
	}

	public int size() {
		return list.size();
	}

	public boolean hasChanged() {
		return changed;
	}

	public List<Integer> getList() {
		return list;
	}

	public int getScore() {
		return score;
	}

}
