package java2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameCellTest {

	@Test
	public void testSettingAndGetting() {
		GameCell gc = new GameCell(0, 1, 2);
		assertEquals(0, gc.getX());
		assertEquals(1, gc.getY());
		assertEquals(2, gc.getValue());

		gc = new GameCell(1, 5, 8);
		assertEquals(1, gc.getX());
		assertEquals(5, gc.getY());
		assertEquals(8, gc.getValue());
	}

	@Test
	public void testCheckCollideSamValues() throws Exception {
		GameCell gc1 = new GameCell(1, 2, 2);
		GameCell gc2 = new GameCell(1, 3, 2);
		GameCell gc3 = new GameCell(2, 2, 2);

		assertEquals(true, gc1.willCollide(gc2, GameCell.UP));
		assertEquals(false, gc2.willCollide(gc1, GameCell.UP));
		assertEquals(false, gc1.willCollide(gc2, GameCell.DOWN));
		assertEquals(true, gc2.willCollide(gc1, GameCell.DOWN));

		assertEquals(true, gc1.willCollide(gc3, GameCell.LEFT));
		assertEquals(false, gc3.willCollide(gc1, GameCell.LEFT));
		assertEquals(false, gc1.willCollide(gc3, GameCell.RIGHT));
		assertEquals(true, gc3.willCollide(gc1, GameCell.RIGHT));

		assertEquals(false, gc1.willCollide(gc3, GameCell.UP));
		assertEquals(false, gc3.willCollide(gc1, GameCell.UP));
		assertEquals(false, gc1.willCollide(gc3, GameCell.DOWN));
		assertEquals(false, gc3.willCollide(gc1, GameCell.DOWN));

		assertEquals(false, gc1.willCollide(gc2, GameCell.LEFT));
		assertEquals(false, gc2.willCollide(gc1, GameCell.LEFT));
		assertEquals(false, gc1.willCollide(gc2, GameCell.RIGHT));
		assertEquals(false, gc2.willCollide(gc1, GameCell.RIGHT));
	}

	@Test
	public void testDifferentCollisions() throws Exception {
		GameCell gc1 = new GameCell(1, 2, 2);
		GameCell gc2 = new GameCell(1, 3, 4);
		GameCell gc3 = new GameCell(2, 2, 4);
		assertEquals(false, gc1.willCollide(gc2, GameCell.UP));
		assertEquals(false, gc1.willCollide(gc2, GameCell.DOWN));
		assertEquals(false, gc1.willCollide(gc3, GameCell.LEFT));
		assertEquals(false, gc1.willCollide(gc3, GameCell.RIGHT));

		assertEquals(false, gc2.willCollide(gc1, GameCell.UP));
		assertEquals(false, gc2.willCollide(gc1, GameCell.DOWN));
		assertEquals(false, gc3.willCollide(gc1, GameCell.LEFT));
		assertEquals(false, gc3.willCollide(gc1, GameCell.RIGHT));
	}

	@Test
	public void testCollisions() throws Exception {
		GameCell gc1 = new GameCell(1, 2, 2);
		GameCell gc2 = new GameCell(1, 3, 2);
		GameCell gc3 = new GameCell(2, 3, 2);
		GameCell gc4 = new GameCell(3, 3, 2);

		assertEquals(new GameCell(1, 2, 4), gc1.collideWith(gc2, GameCell.UP));
		assertEquals(new GameCell(1, 3, 4), gc2.collideWith(gc1, GameCell.DOWN));

		assertEquals(new GameCell(1, 3, 4), gc2.collideWith(gc3, GameCell.LEFT));
		assertEquals(new GameCell(2, 3, 4), gc3.collideWith(gc2, GameCell.RIGHT));

		assertEquals(new GameCell(2, 3, 4), gc3.collideWith(gc4, GameCell.LEFT));
		assertEquals(new GameCell(3, 3, 4), gc4.collideWith(gc3, GameCell.RIGHT));

		GameCell gc5 = new GameCell(4, 5, 2);
		assertEquals(null, gc1.collideWith(gc5, GameCell.UP));
	}
}
