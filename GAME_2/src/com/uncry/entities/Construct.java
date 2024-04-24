package com.uncry.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class Construct extends Entity {
	public static int TILE_SIZE=64;
	
	public static BufferedImage HOUSE2_1=Game.sheetConstruct.getSprite(0, 0, TILE_SIZE,TILE_SIZE);
	
	
	public BufferedImage sheet;
	public void render(Graphics g) {
		g.drawImage(sheet,getX()-Camera.x,getY()-Camera.y,null);
	}
	public Construct(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		this.sheet=sheet;
	}

}
