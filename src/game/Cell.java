package game;

import java.util.Random;

public class Cell {
	private boolean isAlive = false;
	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		 Random rand = new Random();
		 isAlive = rand.nextBoolean();
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void alive() {
		this.isAlive = true;
	}

	public void dead() {
		this.isAlive = false;
	}

	public int neighbors(Board board) {
		int[][] nearbyCell = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int count = 0;
		for (int i = 0; i < nearbyCell.length; i++) {
			if (isNeighborsAlive(board, nearbyCell, i)) {
				count++;
			}
		}
		return count;
	}

	private boolean isNeighborsAlive(Board board, int[][] nearbyCell, int i) {
		return board.getCell((this.x + nearbyCell[i][0] + board.getX()) % board.getX(),
				(this.y + nearbyCell[i][1] + board.getY()) % board.getY()).isAlive;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
