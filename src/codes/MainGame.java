package codes;

import codes.GameBase;

import javax.swing.JFrame;

public class MainGame {
	
	public static void main (String[] args){
		
		GameBase gb = new GameBase();
		
		JFrame window = new JFrame();
		window.add(gb);
		window.setSize(1024,764);
		window.setLocation(250,0);
		window.setTitle("Puzzle Adventure");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		
	}

}
