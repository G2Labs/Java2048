package java2048;

import java.util.ArrayList;
import java.util.List;

public class GameShifter {
	private List<Integer> list = new ArrayList<>();

	public List<Integer> getList() {
		return list;
	}

	public void add(int number) {
		if (number > 0)
			list.add(number);
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
					temp.add(i0 * 2);
					i++;
				} else
					temp.add(i0);
			}

		}
		list = temp;
	}

	public int[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
