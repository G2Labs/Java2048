package java2048;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameShifterTest {
	private GameShifter gc = new GameShifter();

	@Before
	public void setUp() {
		gc = new GameShifter();
	}

	@Test
	public void testEmpty() {
		assertEquals(asList(), gc.getList());
	}

	@Test
	public void testAddZero() throws Exception {
		gc.add(0);
		assertEquals(asList(), gc.getList());
	}

	@Test
	public void testAddTwoZeros() throws Exception {
		gc.add(0);
		gc.add(0);
		assertEquals(false, gc.hasChanged());
		assertEquals(asList(), gc.getList());
	}

	@Test
	public void testAddNumber() throws Exception {
		gc.add(2);
		assertEquals(asList(2), gc.getList());
	}

	@Test
	public void testAddMoreNumbers() throws Exception {
		gc.add(2);
		gc.add(8);
		gc.add(4);
		gc.add(2);
		gc.add(2);
		assertEquals(asList(2, 8, 4, 2, 2), gc.getList());
	}

	@Test
	public void testAddingNumbersWithZeros() throws Exception {
		gc.add(2);
		gc.add(0);
		assertEquals(false, gc.hasChanged());
		gc.add(4);
		assertEquals(true, gc.hasChanged());
		gc.add(2);
		gc.add(0);
		gc.add(0);
		gc.add(2);
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(2, 4, 2, 2), gc.getList());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(2, 4, 4), gc.getList());
		assertEquals(4, gc.getScore());
	}

	@Test
	public void testSimpleMove() throws Exception {
		gc.add(2);
		gc.add(2);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(4), gc.getList());
		assertEquals(4, gc.getScore());
	}

	@Test
	public void testOtherMove() throws Exception {
		gc.add(4);
		gc.add(4);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(8), gc.getList());
		assertEquals(8, gc.getScore());
	}

	@Test
	public void testOtherMove2() throws Exception {
		gc.add(4);
		gc.add(4);
		gc.add(4);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(8, 4), gc.getList());
		assertEquals(8, gc.getScore());
	}

	@Test
	public void testOtherMove3() throws Exception {
		gc.add(4);
		gc.add(4);
		gc.add(4);
		gc.add(4);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(8, 8), gc.getList());
		assertEquals(16, gc.getScore());
	}

	@Test
	public void testOtherMove4() throws Exception {
		gc.add(4);
		gc.add(4);
		gc.add(8);
		gc.add(2);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(8, 8, 2), gc.getList());
		assertEquals(8, gc.getScore());
	}

	@Test
	public void testOtherMove5() throws Exception {
		gc.add(2);
		gc.add(2);
		gc.add(4);
		gc.add(2);
		gc.add(4);
		assertEquals(false, gc.hasChanged());
		gc.move();
		assertEquals(true, gc.hasChanged());
		assertEquals(asList(4, 4, 2, 4), gc.getList());
		assertEquals(4, gc.get(0));
		assertEquals(4, gc.get(1));
		assertEquals(2, gc.get(2));
		assertEquals(4, gc.get(3));
		assertEquals(4, gc.size());
		assertEquals(4, gc.getScore());
	}

}
