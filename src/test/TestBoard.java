package test;

import game.Board;
import game.Cell;
import junit.framework.TestCase;

public class TestBoard extends TestCase {
	private Board board;
	private int[] size = { 50, 50 };

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(size[0], size[1]);
	}

	public void testDefaultBoardCreateAllDeadCell() {
		for (int i = 0; i < size[0]; i++) {
			for (int j = 0; j < size[1]; j++) {
				assertFalse(board.getCell(i, j).isAlive());
			}
		}
	}

	public void testCellWithZeroNeighbors() {
		Cell cell = board.getCell(10, 10);
		cell.alive();
		assertEquals(0, cell.neighbors(this.board));
	}

	public void testCellWithOneNeighbors() {
		Cell cell = board.getCell(10, 10);
		cell.alive();
		Cell cell1 = board.getCell(9, 9);
		cell1.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell1.dead();
		Cell cell2 = board.getCell(9, 10);
		cell2.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell2.dead();
		Cell cell3 = board.getCell(9, 11);
		cell3.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell3.dead();
		Cell cell4 = board.getCell(10, 9);
		cell4.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell4.dead();
		Cell cell5 = board.getCell(10, 11);
		cell5.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell5.dead();
		Cell cell6 = board.getCell(11, 9);
		cell6.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell6.dead();
		Cell cell7 = board.getCell(11, 10);
		cell7.alive();
		assertEquals(1, cell.neighbors(this.board));
		cell7.dead();
		Cell cell8 = board.getCell(11, 11);
		cell8.alive();
		assertEquals(1, cell.neighbors(this.board));
	}

	public void testCellWithTwoNeighbor() {
		Cell cell = board.getCell(10, 10);
		cell.alive();

		Cell cell2 = board.getCell(9, 10);
		cell2.alive();

		Cell cell3 = board.getCell(9, 11);
		cell3.alive();

		assertEquals(2, cell.neighbors(this.board));
	}

	public void testCellWithThreeNeighbor() {
		Cell cell = board.getCell(10, 10);
		cell.alive();

		Cell cell2 = board.getCell(9, 10);
		cell2.alive();

		Cell cell3 = board.getCell(9, 11);
		cell3.alive();

		Cell cell4 = board.getCell(9, 9);
		cell4.alive();

		assertEquals(3, cell.neighbors(this.board));
	}
}
