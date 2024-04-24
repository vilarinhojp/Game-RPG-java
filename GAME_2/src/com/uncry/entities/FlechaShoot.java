package com.uncry.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class FlechaShoot extends Entity {
	
	double dx=0;
	double dy=0;
	int speed=5;
	int contador=0;
	public BufferedImage sheet;
	int maxLife=35;
	int life=0;
	public FlechaShoot(int x, int y, int w, int h, BufferedImage sheet,double dx,double dy) {
		super(x, y, w, h, sheet);
		this.dx=dx;
		this.dy=dy;
		this.sheet=sheet;
	}
	public void tick() {
		x+=dx*speed;
		y+=dy*speed;
		life++;
		if(life==maxLife) {
			Game.shoot.remove(this);
		}
	}
	public void render(Graphics g) {
		
		g.drawImage(sheet,getX()-Camera.x,getY()-Camera.y,null);
	}

}
