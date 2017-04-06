package java2048;

import java.util.ArrayList;
import java.util.List;

public class GameDecomposition {
	private List<Integer> list = new ArrayList<>();
	private boolean changed = false;

	public GameDecomposition() {
	}

	public void add(Integer gp) {
		list.add(gp);
	}

	public List<Integer> getDecomposedList() {
		return list;
	}

	public void reset() {
		changed = false;
		list = new ArrayList<>();
	}

	public boolean didChange() {
		return changed;
	}

	public int move() {
		int score = coalesce();
		reduceList();
		return score;
	}

	private int coalesce() {
		int score = 0;
		for (int i = 0; i < list.size(); i++) {
			int v1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				int v2 = list.get(j);
				if (v1 == v2) {
					list.set(j, 0);
					list.set(i, v1 * 2);
					score += v1 * 2;
					j = list.size();
					changed = true;
				}
			}
		}
		return score;
	}

	private void reduceList() {
		for (int i = list.size() - 1; i >= 0; i--)
			if (list.get(i) == 0) {
				if (i < list.size() - 1 && list.get(i + 1) != 0)
					changed = true;
				list.remove(i);
			}
	}
}
