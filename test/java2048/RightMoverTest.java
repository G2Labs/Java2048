package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightMoverTest {

	@Test
	public void test() {
		RightMover rm = new RightMover();
		assertEquals("RIGHT", rm.getName());
		assertEquals(false, rm.hasChanged());
		assertEquals(0, rm.getScore());
	}

	@Test
	public void testOtherMoves() throws Exception {
		RightMover rm = new RightMover();
		int[][] f = { { 0, 0, 2, 2 }, { 2, 0, 2, 4 }, { 2, 8, 4, 4 }, { 8, 8, 4, 2 } };
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, rm.move(f)[0]);
		assertEquals(true, rm.hasChanged());
		assertEquals(40, rm.getScore());
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, rm.getField()[0]);
		assertArrayEquals(new int[] { 0, 0, 0, 2 }, rm.getField()[1]);
		assertArrayEquals(new int[] { 4, 0, 4, 8 }, rm.getField()[2]);
		assertArrayEquals(new int[] { 8, 16, 8, 2 }, rm.getField()[3]);
	}

	@Test
	public void testSomeMove() throws Exception {
		RightMover rm = new RightMover();
		int[][] f = { { 0, 0, 2 }, { 2, 0, 2 }, { 2, 8, 4 } };
		rm.move(f);
		assertEquals(true, rm.hasChanged());
		assertEquals(8, rm.getScore());
		assertArrayEquals(new int[] { 0, 0, 0 }, rm.getField()[0]);
		assertArrayEquals(new int[] { 0, 0, 4 }, rm.getField()[1]);
		assertArrayEquals(new int[] { 4, 8, 4 }, rm.getField()[2]);
	}
}
