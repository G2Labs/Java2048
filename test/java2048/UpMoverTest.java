package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UpMoverTest {

	@Test
	public void test() {
		int[][] field = new int[0][0];
		UpMover um = new UpMover(field);
		assertEquals("UP", um.getName());
		assertEquals(false, um.hasChanged());

		int[][] res = um.getField();
		assertEquals(0, res.length);
		field = new int[1][1];
		um = new UpMover(field);
		assertEquals(false, um.hasChanged());

		res = um.getField();
		assertEquals(1, res.length);
		assertEquals(1, res[0].length);

		field = new int[2][2];
		um = new UpMover(field);
		res = um.getField();
		assertEquals(2, res.length);
		assertEquals(2, res[0].length);
	}

	@Test
	public void testMoreMoves() throws Exception {
		int[][] f = { { 0, 2, 0 }, { 4, 0, 4 }, { 2, 2, 2 } };
		UpMover up = new UpMover();
		up.move(f);
		assertEquals(true, up.hasChanged());
		assertEquals(12, up.getScore());
		assertArrayEquals(new int[] { 2, 0, 0 }, up.getField()[0]);
		assertArrayEquals(new int[] { 8, 0, 0 }, up.getField()[1]);
		assertArrayEquals(new int[] { 4, 2, 0 }, up.getField()[2]);
	}

	@Test
	public void testSomeMoves() throws Exception {
		int[][] f = { { 2, 0 }, { 2, 0 } };
		UpMover up = new UpMover();
		up.move(f);
		assertEquals(false, up.hasChanged());
		assertEquals(0, up.getScore());

		int[][] f2 = { { 0, 2 }, { 0, 2 } };
		up = new UpMover();
		up.move(f2);
		assertArrayEquals(new int[] { 2, 0 }, up.move(f2)[0]);
		assertEquals(true, up.hasChanged());
		assertEquals(0, up.getScore());
		assertArrayEquals(new int[] { 2, 0 }, up.getField()[0]);
		assertArrayEquals(new int[] { 2, 0 }, up.getField()[1]);
		up.generateNewNumber();

		int[][] result = { { 2, 0 }, { 2, 0 } };
		boolean areEqual = true;
		for (int x = 0; x < up.getField().length; x++) {
			for (int y = 0; y < up.getField().length; y++) {
				if (up.getField()[x][y] != result[x][y])
					areEqual = false;
			}
		}
		if (areEqual)
			fail("Dane nie powinny byc takie same");

		up = new UpMover(new int[0][0]);
		if (up.generateNewNumber().length > 0)
			fail("Tablica powinna by� pusta");
	}
}
