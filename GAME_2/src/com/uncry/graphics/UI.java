package com.uncry.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;

public class UI {
	
	public BufferedImage[]lifePoint;
	int life=6;
	public int x,y;
	public BufferedImage FLECHAS;
	public void tick() {
		if(Game.player.life>50 && Game.player.life<=60) {
			life=6;
		}else if(Game.player.life>40 && Game.player.life<=50) {
			life=5;
		}else if(Game.player.life>30 && Game.player.life<=40) {
			life=4;
		}else if(Game.player.life>20 && Game.player.life<=30) {
			life=3;
		}else if(Game.player.life>10 && Game.player.life<=20) {
			life=2;
		}else if(Game.player.life>0 && Game.player.life<=10) {
			life=1;
		}else {
			life=0;
		}
		
	}
	public void render(Graphics g) {
		if(life==6) {
			g.drawImage(lifePoint[0],x,y,null);
		}else if(life==5) {
			g.drawImage(lifePoint[1],x,y,null);
		}else if(life==4) {
			g.drawImage(lifePoint[2],x,y,null);
		}else if(life==3) {
			g.drawImage(lifePoint[3],x,y,null);
		}else if(life==2) {
			g.drawImage(lifePoint[4],x,y,null);
		}else if(life==1) {
			g.drawImage(lifePoint[5],x,y,null);
		}
		if(Game.player.arco==true) {
			g.drawImage(FLECHAS,Game.WIDTH-64,-6,64,64,null);
		}
	}
	public UI(int x,int y) {
		
		this.x=x;
		this.y=y;
		
		lifePoint=new BufferedImage[6];
		FLECHAS=Game.sheetUI.getSprite(3*64, 0,64,64);
		for(int i=0;i<lifePoint.length;i++) {
			lifePoint[i]=Game.sheetUI.getSprite(0, i*64, 64*3,64);
		}
	}
}
