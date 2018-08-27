package game;

import java.util.Observable;

public class Game extends Observable {
	private boolean isPlay = false;
	private Board board;
	private int x;
	private int y;

	public Game(int x, int y) {
		this.x = x;
		this.y = y;
		board = new Board(x, y);
		this.loop();
	}

	public void start() {
		this.isPlay = true;
	}

	public void stop() {
		this.isPlay = false;
	}

	private void loop() {
		new Thread(() -> {
			while (true) {
				System.out.println("looping");
				if (this.isPlay) {
					try {
						this.trick();
						this.setChanged();
						this.notifyObservers();
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void trick() {
		boolean aliveNextTurn[][] = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (isAliveNextTrick(i, j)) {
					aliveNextTurn[i][j] = true;
				} else {
					aliveNextTurn[i][j] = false;
				}
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Cell cell = board.getCell(i, j);
				if (aliveNextTurn[i][j]) {
					cell.alive();
				} else {
					cell.dead();
				}
			}
		}
	}

	public boolean isAliveNextTrick(int x, int y) {
		Cell cell = this.board.getCell(x, y);
		if (cell.isAlive()) {
			if (cell.neighbors(this.board) < 2) {
				return false;
			}
			if (cell.neighbors(this.board) <= 3) {
				return true;
			} else {
				return false;
			}
		} else {
			if (cell.neighbors(this.board) == 3) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Board getBoard() {
		return board;
	}
}
