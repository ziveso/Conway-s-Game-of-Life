package game;

public class Board {
	private Cell[][] cells;
	private int x;
	private int y;

	public Board(int x, int y) {
		this.x = x;
		this.y = y;
		initialCells(x, y);
	}

	private void initialCells(int x, int y) {
		cells = new Cell[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
