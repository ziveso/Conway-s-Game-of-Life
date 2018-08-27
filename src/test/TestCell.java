package test;

import game.Cell;
import junit.framework.TestCase;

public class TestCell extends TestCase {
	private Cell cell;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		cell = new Cell(0,0);
	}
	
	public void testDefaultCellIsNotAlive() {
		assertEquals(false, cell.isAlive());
	}
	
	public void testSpawnCell() {
		cell.alive();
		assertEquals(true, cell.isAlive());
	}
	
	public void testDeadCell() {
		cell.alive();
		cell.dead();
		assertEquals(false, cell.isAlive());
	}
}
