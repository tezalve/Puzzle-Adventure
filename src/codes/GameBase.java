package codes;

import codes.Ground;


import codes.Character;
import codes.GameSound;
import codes.Spike;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class GameBase extends JPanel implements KeyListener {

	static int c = 0;
	static int r = 1;
	static int j = 0;
	
	Character character;
	Ground ground;
	Ground ground2;
	Spike[] spike = new Spike[40];
	
	public GameBase(){
		
		character = new Character(5,420,"images//character2.png",false);
		
		ground = new Ground(-100,510,"images//LargePlatform4.png");
		
		ground2 = new Ground(810,510,"images//LargePlatform4.png");
	
		int xSpike = 5, ySpike = 650;
		
		for(int i = 0; i < spike.length; i++){
			
			spike[i] = new Spike(xSpike + 40 * i ,ySpike,"images//Spike2.png");
				
		}
		
		super.addKeyListener(this);
		super.setFocusable(true);

	
}
	
	public void changeSet(){
		
		character.setX(5);
		super.repaint();
	}
	
	public void paint(Graphics g){
		
		ImageIcon background = new ImageIcon("images//cvbnm.jpeg");
		g.drawImage(background.getImage(),0,0,null);
		
		for(int i = 1;i <= 5 ;i++){
			
			if(r==i){
				
				ImageIcon[] Round = new ImageIcon[6];
				Round[r] = new ImageIcon("images//Round"+r+".png");
				g.drawImage(Round[r].getImage(),300,250,null);
			}	
			
		}
		
		if(r>5){
			
			ImageIcon Round = new ImageIcon("images//Round.png");
			g.drawImage(Round.getImage(),100,150,null);
			
		}
		
		if(character.getY() == 630){
			
		ImageIcon gameover = new ImageIcon("images//GameOver.png");
		g.drawImage(gameover.getImage(),0,0,null);
		
		}
			
			ground.draw(g);
			ground2.draw(g);
			
			character.draw(g);
			
			for(int i = 0;i<spike.length;i++){
				
				spike[i].draw(g);
				
			}
		
		
			String s = Integer.toString(c);
			g.drawString(s,800,50);
			
			String a = "Invisible ground = 50 pixels";
			g.drawString(a,730,100);
		
	    
    }
	
	public void keyPressed(KeyEvent e) {

	    if(e.getKeyCode() == e.VK_LEFT)
		{
			if(character.getY() != 630)
				character.setX(character.getX() - 10);

			if(character.getX() > 490 && character.getX() < 740 ){ //to fall
				
				character.setY(630);
				GameSound.characterDyingSound();
				
			}
			
			j=0;
		}
		
	    if(e.getKeyCode() == e.VK_RIGHT)
		{
			if(character.getY() != 630)
				character.setX(character.getX() + 8);

			if(character.getX() > 490 && character.getX() < 740 ){ //to fall
				
				character.setY(630);
				GameSound.characterDyingSound();
				
			}
			if(character.getX() > 924)
			{
				changeSet();
				r++;
			}
			
			j=0;
			
		}
		
		else if(e.getKeyCode() == e.VK_UP && j < 1){
			
			if (character.getX() < 670 && character.getY() != 630){
			
			CharacterJumping charjump = new CharacterJumping(this,character, ground);
			charjump.start();
			
			j++;
			
			
			}
			
			if(character.getX() > 490 && character.getX() < 740 ){ //to fall
				
				character.setY(630);
				GameSound.characterDyingSound();
			
			}
			

			
			
			
		}
		
		super.repaint();
		
		if(character.getX() > 740 && character.getX() < 780){
			
			c++;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void checkPlatform(){	
		Rectangle charaRect = new Rectangle(character.getX(),character.getY(),100,100);
		
		for(int i = 0; i < ground.length; i++){
			
			Rectangle groRect = new Rectangle(ground[i].getX(),ground[i].getY(),300,300);
			
			if(charaRect.intersects(groRect) == true)
			{
				character.setDead(true);
				GameSound.characterDyingSound();
			}	
			
			
		}



	}*/
	
	public static int countScore(){
		
		return c;
		
	}
	
	public static int countRound(){
		
		return r;
		
	}
	
}