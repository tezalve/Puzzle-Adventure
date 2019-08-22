package codes;

import java.awt.Rectangle;

public class CharacterJumping extends Thread {
	
	private GameBase gamebase;
	private Ground ground;
	private Character character;
	
	public CharacterJumping(GameBase gamebase, Character character, Ground ground) {
		
		this.gamebase = gamebase;
		this.character = character;
		this.ground = ground;
	}
	
	public void run(){
		
		
		double velocity = 19, angle = 60, acceleration = -6;
		
		int steps = 50;
		
		double xVelocity = velocity/Math.cos(Math.toRadians(angle));
		double yVelocity = velocity/Math.sin(Math.toRadians(angle));
		
		double totalTime = -2 * yVelocity/acceleration;
		
		double timeIncrement = totalTime/steps;
		double xIncrement = xVelocity * timeIncrement;
		
		double x,y,t;
		
		x = character.getX();
		y = character.getY();
		t = 0;
		
		for(int i = 0; i <= steps; i++){
			
			t = t + timeIncrement;
			x = x + xIncrement;
			y = yVelocity * t + 0.5 * acceleration * t * t;
			
			
			
			character.setX((int)Math.round(x));
			character.setY(415 - (int)Math.round(y));
			
			
			try {
				Thread.sleep(15);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
			
			}
			
			gamebase.repaint();
		}
	}
	
}
