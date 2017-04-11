package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DownMoverTest {

	@Test
	public void test() {
		DownMover dw = new DownMover();
		assertEquals(false, dw.hasChanged());
		assertEquals(0, dw.getScore());
		assertEquals("DOWN", dw.getName());
	}

	@Test
	public void testOtherMove() throws Exception {
		DownMover dw = new DownMover();
		int[][] f = { { 0, 2, 0, 0 }, { 2, 4, 4, 8 }, { 2, 0, 2, 2 }, { 2, 2, 8, 8 } };
		assertArrayEquals(new int[] { 0, 0, 0, 2 }, dw.move(f)[0]);
		assertEquals(true, dw.hasChanged());
		assertEquals(32, dw.getScore());
		assertArrayEquals(new int[] { 0, 0, 0, 2 }, dw.getField()[0]);
		assertArrayEquals(new int[] { 0, 2, 8, 8 }, dw.getField()[1]);
		assertArrayEquals(new int[] { 0, 0, 2, 4 }, dw.getField()[2]);
		assertArrayEquals(new int[] { 0, 0, 4, 16 }, dw.getField()[3]);

	}

	@Test
	public void testSimpleMove() throws Exception {
		DownMover dw = new DownMover();
		int[][] f = { { 0, 2, 0 }, { 2, 4, 4 }, { 2, 0, 2 } };
		dw.move(f);
		assertEquals(true, dw.hasChanged());
		assertEquals(12, dw.getScore());
		assertArrayEquals(new int[] { 0, 0, 2 }, dw.getField()[0]);
		assertArrayEquals(new int[] { 0, 2, 8 }, dw.getField()[1]);
		assertArrayEquals(new int[] { 0, 0, 4 }, dw.getField()[2]);
	}
}
