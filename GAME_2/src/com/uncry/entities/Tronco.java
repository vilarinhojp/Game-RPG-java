package com.uncry.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class Tronco extends Entity {
	
	public static BufferedImage[]troncoOlhos;
	int frames=0;
	int maxFrames=5;
	int index=0;
	int maxIndex=11;
	
	public void tick() {
		frames++;
		if(frames==maxFrames) {
			frames=0;
			index++;
			if(index>maxIndex) {
				index=0;
				frames=-60;
			}
		}
	}
	public void render(Graphics g) {
		g.drawImage(troncoOlhos[index], getX()-Camera.x,getY()-Camera.y,null);
	}
	public Tronco(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		troncoOlhos=new BufferedImage[12];
		for(int i=0;i<2;i++) {
			for(int ii=0;ii<troncoOlhos.length/2;ii++) {
				troncoOlhos[ii+(i*6)]=Game.sheetEntity.getSprite(ii*64, 64*6+(i*64),64,64);
			}
		}
	}

}
