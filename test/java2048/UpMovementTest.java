package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UpMovementTest {

	@Test
	public void test() {
		int[][] field = new int[0][0];
		UpMovement um = new UpMovement(field);
		assertEquals(false, um.hasChanged());

		int[][] res = um.getField();
		assertEquals(0, res.length);
		field = new int[1][1];
		um = new UpMovement(field);
		assertEquals(false, um.hasChanged());

		res = um.getField();
		assertEquals(1, res.length);
		assertEquals(1, res[0].length);

		field = new int[2][2];
		um = new UpMovement(field);
		res = um.getField();
		assertEquals(2, res.length);
		assertEquals(2, res[0].length);
	}

	@Test
	public void testSomeMoves() throws Exception {
		int[][] f = { { 2, 0 }, { 2, 0 } };
		UpMovement up = new UpMovement();
		up.move(f);
		assertEquals(false, up.hasChanged());
		assertEquals(0, up.getScore());

		int[][] f2 = { { 0, 2 }, { 0, 2 } };
		up = new UpMovement();
		up.move(f2);
		assertEquals(true, up.hasChanged());
		assertEquals(0, up.getScore());
		assertArrayEquals(new int[] { 2, 0 }, up.getField()[0]);
		assertArrayEquals(new int[] { 2, 0 }, up.getField()[1]);
	}

	@Test
	public void testMoreMoves() throws Exception {
		int[][] f = { { 0, 2, 0 }, { 4, 0, 4 }, { 2, 2, 2 } };
		UpMovement up = new UpMovement();
		up.move(f);
		assertEquals(true, up.hasChanged());
		assertEquals(12, up.getScore());
		assertArrayEquals(new int[] { 2, 0, 0 }, up.getField()[0]);
		assertArrayEquals(new int[] { 8, 0, 0 }, up.getField()[1]);
		assertArrayEquals(new int[] { 4, 2, 0 }, up.getField()[2]);
	}
}
