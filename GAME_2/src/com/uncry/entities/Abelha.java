package com.uncry.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class Abelha extends Entity {
	
	public BufferedImage[]abelhaMoved;
	int frames=0;
	int maxFrames=3;
	int index=0;
	int maxIndex=11;
	int contador=0;
	
	public void tick() {
		contador++;
		frames++;
		if(frames==maxFrames) {
			frames=0;
			index++;
			if(index>maxIndex) {
				index=0;
			}
		}
		if(contador>=0 && contador<=20) {
			y--;
		}else if(contador>20 && contador<=40) {
			y++;
		}else {
			contador=0;
		}
	}
	public void render(Graphics g) {
		g.drawImage(abelhaMoved[index],getX()-Camera.x,this.getY()-Camera.y,null);
	}
	public Abelha(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		abelhaMoved=new BufferedImage[12];
		for(int i=0;i<2;i++) {
			for(int ii=0;ii<abelhaMoved.length/2;ii++) {
				abelhaMoved[ii+(i*6)]=Game.sheetEntity.getSprite(ii*64, 64*4+(i*64),64,64);
			}
		}
	}

}
