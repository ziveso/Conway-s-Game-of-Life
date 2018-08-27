package main;

import java.util.Observable;
import java.util.Observer;

import game.Board;
import game.Game;

public class App implements Observer {
	private Board board;
	private Game game;

	public App() {
		game = new Game(30,30);
		board = game.getBoard();
		board.getCell(4, 4).alive();

		board.getCell(4, 5).alive();

		board.getCell(4, 6).alive();

		board.getCell(3, 6).alive();
		
		board.getCell(2, 5).alive();

		game.addObserver(this);
		
		print();
		game.start();
	}

	public void print() {
		for(int i = 0 ; i< 30 ; i++) {
			for(int j = 0 ; j < 30 ; j++) {
				if(board.getCell(i, j).isAlive()) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		System.out.println("=================");
	}

	@Override
	public void update(Observable o, Object arg) {
//		System.out.println("updated");
		print();
	}

	public static void main(String[] args) {
		new App();
	}
}
