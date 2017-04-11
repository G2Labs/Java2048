package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeftMoverTest {

	@Test
	public void test() {
		LeftMover lf = new LeftMover();
		assertEquals(false, lf.hasChanged());
		assertEquals(0, lf.getScore());
		assertEquals("LEFT", lf.getName());
	}

	@Test
	public void testMoreMoves() throws Exception {
		LeftMover lf = new LeftMover();
		int[][] f = { { 0, 0, 2 }, { 2, 0, 2 }, { 2, 8, 4 } };
		assertArrayEquals(new int[] { 4, 8, 4 }, lf.move(f)[0]);
		assertEquals(true, lf.hasChanged());
		assertEquals(8, lf.getScore());
		assertArrayEquals(new int[] { 4, 8, 4 }, lf.getField()[0]);
		assertArrayEquals(new int[] { 0, 0, 4 }, lf.getField()[1]);
		assertArrayEquals(new int[] { 0, 0, 0 }, lf.getField()[2]);
	}

	@Test
	public void testSomeMove() throws Exception {
		LeftMover lf = new LeftMover();
		int[][] f = { { 0, 0, 2, 2 }, { 2, 0, 2, 4 }, { 2, 8, 4, 4 }, { 8, 8, 4, 2 } };
		lf.move(f);
		assertEquals(true, lf.hasChanged());
		assertEquals(40, lf.getScore());
		assertArrayEquals(new int[] { 4, 16, 4, 2 }, lf.getField()[0]);
		assertArrayEquals(new int[] { 8, 0, 8, 8 }, lf.getField()[1]);
		assertArrayEquals(new int[] { 0, 0, 0, 2 }, lf.getField()[2]);
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, lf.getField()[3]);
	}
}
