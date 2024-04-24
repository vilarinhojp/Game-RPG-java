package com.uncry.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import com.uncry.graphics.Spritesheetconstruction;
import com.uncry.graphics.Spritesheetenemies;
import com.uncry.graphics.Spritesheetentities;
import com.uncry.graphics.Spritesheetplayer;
import com.uncry.graphics.Spritesheetui;
import com.uncry.graphics.Spritesheetworld;
import com.uncry.main.Game;
import com.uncry.world.Camera;
import com.uncry.world.World;

public class Slime extends Enemy{
	
	public static BufferedImage[]staticSlime;
	public static BufferedImage[]rightSlime;
	public static BufferedImage[]leftSlime;
	public static BufferedImage[]downSlime;
	public static BufferedImage[]upSlime;
	public static BufferedImage[]killSlime;


	public  boolean estatico=true,moved=false,right,left,up,down,slimedead=false;
 	public static boolean dano;
	int frames=0;
	int maxFrames=5;
	int index=0;
	int maxIndex=19;
	
	int framesM=0;
	int maxFramesM=5;
	int indexM=0;
	int maxIndexM=9;
	
	int framesK=0;
	int maxFramesK=2;
	int indexK=0;
	int maxIndexK=9;
	
	int offx;
	int offy;
	int w,h;
	int vida=5;
	public void tick() {
		moved=false;
		estatico=true;
		up=false;
		down=false;
		right=false;
		left=false;
		int speed=1;
		offx=16;
		offy=32;
		w=29;
		h=23;
		if(this.isCollidingWidthPlayer()==false) {
			dano=false;
			if(this.getX()<Game.player.getX() && getX()-Game.player.getX()>=-128
			&& Game.world.isFree((getX()+speed)+offx, getY()+offy,29, 23)
			&& !isColliding((getX()+speed)+offx, getY()+offy,29, 23)
			&& slimedead==false) {
			
			moved=true;
			estatico=false;
			right=true;
			this.x+=1;
			
		}else if(this.getX()>Game.player.getX() && (getX()-Game.player.getX())<=128
			&& Game.world.isFree((getX()-speed)+offx, getY()+offy,29, 23)
			&& !isColliding((getX()-speed)+offx, getY()+offy,29, 23)
			&& slimedead==false) {
			
			estatico=false;
			moved=true;
			left=true;
			this.x-=1;
			
		}
		if(this.getY()<Game.player.getY() && getY()-Game.player.getY()>=-128
			&& Game.world.isFree(getX()+offx,(getY()+speed)+offy,29, 23)
			&& !isColliding(getX()+offx,(getY()+speed)+offy,29, 23)
			&& slimedead==false) {
			
			estatico=false;
			moved=true;
			down=true;
			y+=1;
			
		}else if(this.getY()>Game.player.getY()&& getY()-Game.player.getY()<=128
			&& Game.world.isFree(getX()+offx,(getY()-speed)+offy,29, 23)
			&& !isColliding(getX()+offx,(getY()-speed)+offy,29, 23)
			&& slimedead==false) {
			
			estatico=false;
			moved=true;
			up=true;
			y-=1;
			
		}
		}else {
			//losing life
			dano=true;
			Game.player.life-=0.25;
			Game.player.dano=true;
			/*
			if(Game.player.life==0) {
				dano=false;
				Flechas.flechas=0;
				Game.entities.clear();
				Game.elementos.clear();
				Game.enemies.clear();
				Game.entities=new ArrayList<Entity>();
				Game.elementos=new ArrayList<Entity>();
				Game.enemies=new ArrayList<Entity>();
				Game.rand=new Random();
				Game.sheetConstruct=new Spritesheetconstruction("/Spritesheetconstruction.png");
				Game.sheetWorld=new Spritesheetworld("/Spritesheetworld.png");
				Game.sheetPlayer=new Spritesheetplayer("/Spritesheetplayer.png");
				Game.sheetEntity=new Spritesheetentities("/Spritesheetentities.png");
				Game.sheetEnemies=new Spritesheetenemies("/Spritesheetenemies.png");
				Game.sheetUI=new Spritesheetui("/Spritesheetui.png");
				Game.world=new World("/fase1.png");
				Game.player=new Player(64*4,64*4,64,64,Game.sheetPlayer.getSprite(0, 0, 64, 64));
				Game.entities.add(Game.player);
				return;
				
			}*/
		}
		if(estatico) {
			frames++;
			if(frames==maxFrames) {
				frames=0;
				index++;
				if(index>maxIndex) {
					index=0;
				}
			}
		}else if(moved) {
			framesM++;
			if(framesM==maxFramesM) {
				framesM=0;
				indexM++;
				if(indexM>maxIndexM) {
					indexM=0;
				}
			}
		}
		if(vida<=0) {
			slimedead=true;	
		}
		if(slimedead) {
			framesK++;
			if(framesK==maxFramesK) {
				framesK=0;
				indexK++;
				if(indexK>maxIndexK) {
					slimedead=false;
					destroySelf();
					return;
				}
			}
		}
		isDano();
	}
	public void destroySelf() {
		Game.enemies.remove(this);
	}
	public void isDano() {
		for(int i=0;i<Game.shoot.size();i++) {
			Entity e=Game.shoot.get(i);
			//obs: definir set mask de acordo com a direção
			if(Game.player.posi=='R') {
				e.setMask(26,31, 11,5);
			}else if(Game.player.posi=='L') {
				e.setMask(25,30, 11,5);
			}else if(Game.player.posi=='D') {
				e.setMask(30,26, 5,11);
			}else if(Game.player.posi=='U') {
				e.setMask(30,26, 5,11);
			}
			if(Entity.isColliding(this, e)) {
				vida--;
				System.out.println("COLIDIU");
				Game.shoot.remove(e);
				return;
			}
			
		}
	}
	public boolean isCollidingWidthPlayer() {
		Rectangle current=new Rectangle(this.getX()+offx,this.getY()+offy,w,h);
		Rectangle player=new Rectangle(Game.player.getX()+Game.player.maskx+10,Game.player.getY()+Game.player.masky+10,
		Game.player.w-10,Game.player.h-10);
		return current.intersects(player);
	}
	public boolean isColliding(int nextx,int nexty,int w,int h) {
		Rectangle current=new Rectangle(nextx,nexty,w,h);
		for(int i=0;i<Game.enemies.size();i++){
			Entity e= Game.enemies.get(i);
			if(e==this) {
				continue;
			}else {
			Rectangle enemy=new Rectangle(e.getX()+offx,e.getY()+offy,29,23);
			if(current.intersects(enemy)) {
				return true;
			}
			}
		}
		return false;
	}
	public void render(Graphics g) {
		if(slimedead) {
			g.drawImage(killSlime[indexK], getX()-Camera.x,getY()-Camera.y,null);
		}else {
			if(estatico) {
				g.drawImage(staticSlime[index], getX()-Camera.x,getY()-Camera.y,null);
			}else if(up) {
				g.drawImage(upSlime[indexM], getX()-Camera.x,getY()-Camera.y,null);
			}else if(down) {
				g.drawImage(downSlime[indexM], getX()-Camera.x,getY()-Camera.y,null);
			}
			else if(right) {
				g.drawImage(rightSlime[indexM], getX()-Camera.x,getY()-Camera.y,null);
			}else if(left) {
				g.drawImage(leftSlime[indexM], getX()-Camera.x,getY()-Camera.y,null);
			}
		}

		
	}
	public Slime(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		staticSlime=new BufferedImage[20];
		rightSlime=new BufferedImage[10];
		leftSlime=new BufferedImage[10];
		downSlime=new BufferedImage[10];
		upSlime=new BufferedImage[10];
		killSlime=new BufferedImage[10];
		
		for(int i=0;i<rightSlime.length;i++) {
			rightSlime[i]=Game.sheetEnemies.getSprite(i*64, 64*4, 64,64);
			leftSlime[i]=Game.sheetEnemies.getSprite(i*64, 64*3, 64,64);
			upSlime[i]=Game.sheetEnemies.getSprite(i*64, 64*5, 64,64);
			downSlime[i]=Game.sheetEnemies.getSprite(i*64, 64*2, 64,64);
			killSlime[i]=Game.sheetEnemies.getSprite(i*64, 6*64,64,64);
		}
		for(int i=0;i<2;i++) {
			for(int ii=0;ii<staticSlime.length/2;ii++) {
				staticSlime[ii+(i*10)]=Game.sheetEnemies.getSprite(ii*64, i*64, 64,64);
			}
		}
	}

}
