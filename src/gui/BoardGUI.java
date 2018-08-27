package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class BoardGUI extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoardGUI() {
		setSize(500, 500);
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
