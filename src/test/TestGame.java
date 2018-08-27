package test;

import static org.junit.Assert.*;

import org.junit.*;

import game.*;

public class TestGame {
	private Game game;

	@Before
	public void setUp() {
		game = new Game(50, 50);
	}

	@Test
	public void TestCellUnderPopulation() {
		Board board = game.getBoard();
		board.getCell(10, 10).alive();
		game.trick();
		assertFalse(board.getCell(10, 10).isAlive());

		board.getCell(15, 15).alive();
		board.getCell(15, 16).alive();
		game.trick();
		assertFalse(board.getCell(15, 15).isAlive());
		assertFalse(board.getCell(15, 16).isAlive());
	}

	@Test
	public void TestCellAliveNextGeneration() {
		Board board = game.getBoard();
		board.getCell(10, 10).alive();
		board.getCell(10, 11).alive();
		board.getCell(9, 10).alive();
		game.trick();
		assertTrue(board.getCell(10, 11).isAlive());
	}

	@Test
	public void TestCellDeadOverPopulation() {
		Board board = game.getBoard();
		board.getCell(10, 10).alive();
		board.getCell(10, 11).alive();
		board.getCell(11, 11).alive();
		board.getCell(11, 10).alive();
		board.getCell(11, 9).alive();
		game.trick();
		assertFalse(board.getCell(10, 10).isAlive());
	}

	@Test
	public void TestRespawnWithThreeAliveCells() {
		Board board = game.getBoard();
		board.getCell(10, 10).alive();
		board.getCell(10, 11).alive();
		board.getCell(10, 9).alive();
		game.trick();

		assertTrue(board.getCell(9, 10).isAlive());
		assertTrue(board.getCell(11, 10).isAlive());
	}
}
