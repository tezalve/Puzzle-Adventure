package codes;

import java.awt.Graphics;

import javax.swing.*;

public class Character {
	
	private int x,y; 
	private String imagePath;
	private boolean isDead;
	
	public Character(int x, int y, String imagePath,boolean isDead) {
		super();
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.isDead = isDead;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	} 
	
    public void draw(Graphics g){
		
		ImageIcon character = new ImageIcon(imagePath);
		g.drawImage(character.getImage(),x,y,null);
		
	}
	
	
	
	

}
