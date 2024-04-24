package com.uncry.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class Entity {
	
	protected double x,y;
	protected int width,height;
	protected BufferedImage sheet;
	public static BufferedImage FLECHA_RIGHT=Game.sheetEntity.getSprite(0, 64*9  ,64,64);
	public static BufferedImage FLECHA_LEFT=Game.sheetEntity.getSprite(64, 64*9,64,64);
	public static BufferedImage FLECHA_UP=Game.sheetEntity.getSprite(128, 64*9,64,64);
	public static BufferedImage FLECHA_DOWN=Game.sheetEntity.getSprite(128+64, 64*9,64,64);

	public static BufferedImage CAT_DEVIL=Game.sheetEntity.getSprite(0, 0, 64, 64);
	public static BufferedImage SLIME=Game.sheetEnemies.getSprite(0, 0, 64, 64);
	public static BufferedImage BANDEIRA=Game.sheetEntity.getSprite(0, 128, 64, 64);
	public static BufferedImage ABELHA=Game.sheetEntity.getSprite(0, 64*4, 64, 64);
	public static BufferedImage TROCO=Game.sheetEntity.getSprite(0, 64*6, 64, 64);
	public static BufferedImage HEART=Game.sheetEntity.getSprite(0, 64*8, 64, 64);
	public static BufferedImage FLECHA=Game.sheetEntity.getSprite(64, 64*8, 64, 64);
	public static BufferedImage ARCO=Game.sheetEntity.getSprite(64+64, 64*8, 64, 64);

	public int maskx,masky,maskw,maskh;
	public boolean dano;
	public void setMask(int mskx,int msky,int mskw,int mskh) {
		this.maskx=mskx;
		this.masky=msky;
		this.maskw=mskw;
		this.maskh=mskh;
	}
	public void setX(int newX) {
		this.x=newX;
		
	}
	public void setY(int newY) {
		this.y=newY;
		
	}
	public int getX() {
		return (int)this.x;
		
	}
	public int getY() {
		return (int)this.y;
		
	}
	public int getW() {
		return this.width;
		
	}
	public int getH() {
		return this.height;
		
	}
	public static boolean isColliding(Entity e1, Entity e2) {
		Rectangle entitie1=new Rectangle(e1.getX()+e1.maskx,e1.getY()+e1.masky,e1.maskw,e1.maskh);
		Rectangle entitie2=new Rectangle(e2.getX()+e2.maskx,e2.getY()+e2.masky,e2.maskw,e2.maskh);
		return entitie1.intersects(entitie2);
	}
	public Entity(int x,int y,int w,int h,BufferedImage sheet) {
		this.x=x;
		this.y=y;
		this.width=w;
		this.height=h;
		this.sheet=sheet;
		
		this.maskx=0;
		this.masky=0;
		this.maskw=64;
		this.maskh=64;
		
	}
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sheet, getX()-Camera.x, getY()-Camera.y,width,height, null);
	}
	
}
