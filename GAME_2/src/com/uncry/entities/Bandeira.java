package com.uncry.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class Bandeira extends Entity{
	
	int frames=0;
	int maxFrames=4;
	int index=0;
	int maxIndex=11;
	public BufferedImage[]movedBandeira;
	
	public void tick() {
		frames++;
		if(frames==maxFrames) {
			frames=0;
			index++;
			if(index>maxIndex) {
				index=0;
			}
		}
	}
	public void render(Graphics g) {
		g.drawImage(movedBandeira[index],getX()-Camera.x,getY()-Camera.y, null);
	}
	public Bandeira(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		movedBandeira=new BufferedImage[12];
		for(int i=0;i<2;i++) {
			for(int ii=0;ii<movedBandeira.length/2;ii++) {	
				movedBandeira[ii+(i*6)]=Game.sheetEntity.getSprite(ii*64, 128+(i*64), 64,64);

			}
		}
	}
	
}
