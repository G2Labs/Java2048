package java2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameFieldTest {

	@Test
	public void test() {
		GameField gf = new GameField(2);
		assertEquals(0, gf.getScore());
		assertEquals(false, gf.hasChanged());
		int[][] f = gf.getField();
		assertArrayEquals(new int[] { 0, 0 }, f[0]);
		assertArrayEquals(new int[] { 0, 0 }, f[1]);

		gf = new GameField(3);
		assertEquals(0, gf.getScore());
		f = gf.getField();
		assertArrayEquals(new int[] { 0, 0, 0 }, f[0]);
		assertArrayEquals(new int[] { 0, 0, 0 }, f[1]);
		assertArrayEquals(new int[] { 0, 0, 0 }, f[2]);
	}

}
