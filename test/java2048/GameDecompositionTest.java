package java2048;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GameDecompositionTest {

	@Test
	public void testEmpty() {
		GameDecomposition gd = new GameDecomposition();
		gd.move();
		assertEquals(Arrays.asList(), gd.getDecomposedList());
	}

	@Test
	public void testOneElement() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(2);
		gd.move();
		assertEquals(false, gd.didChange());
		assertEquals(Arrays.asList(2), gd.getDecomposedList());
	}

	@Test
	public void testOneElement2() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(0);
		gd.add(2);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(2), gd.getDecomposedList());
	}

	@Test
	public void testOneElement3() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(0);
		gd.add(0);
		gd.add(2);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(2), gd.getDecomposedList());
	}

	@Test
	public void testOneElement4() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(0);
		gd.add(0);
		gd.add(4);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(4), gd.getDecomposedList());
	}

	@Test
	public void testTwoElements() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(2);
		gd.add(2);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(4), gd.getDecomposedList());
	}

	@Test
	public void testThreeElements() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(2);
		gd.add(2);
		gd.add(2);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(4, 2), gd.getDecomposedList());
	}

	@Test
	public void testThreeElements2() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(4);
		gd.add(2);
		gd.add(2);
		gd.move();
		assertEquals(true, gd.didChange());
		assertEquals(Arrays.asList(4, 4), gd.getDecomposedList());
	}

	@Test
	public void testThreeElements3() throws Exception {
		GameDecomposition gd = new GameDecomposition();
		gd.add(4);
		gd.add(8);
		gd.add(2);
		gd.move();
		assertEquals(false, gd.didChange());
		assertEquals(Arrays.asList(4, 8, 2), gd.getDecomposedList());
	}

}
