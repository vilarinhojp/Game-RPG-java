package com.uncry.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;
import com.uncry.world.World;

public class Player extends Entity {
	
	public static boolean right,left,up,down,moved;
	public static boolean tiro;
	public static boolean tiroMouse;
	public static boolean dano;
	public boolean arco=false;
	public static int speed=2;
	
	public static int maskx=11;
	public static int masky=13;
	public static int w=40;
	public static int h=52;
	int TILE_SIZE=64;
	
	public double life=60;
	
	public static BufferedImage[]handArcoRight;
	public static BufferedImage[]handArcoLeft;
	public static BufferedImage[]arcos;
	
	public static BufferedImage handStaticArcoRight;
	public static BufferedImage handStaticArcoLeft;
	public static BufferedImage handStaticArcoUp;
	public static BufferedImage handStaticArcoDown;
	
	public static BufferedImage[]handStaticArcoRLUP;
	
	public static BufferedImage[]downPlayer;
	public static BufferedImage[]upPlayer;
	public static BufferedImage[]rightPlayer;
	public static BufferedImage[]leftPlayer;
	
	public static BufferedImage[]downArcoPlayer;
	public static BufferedImage[]upArcoPlayer;
	public static BufferedImage[]rightArcoPlayer;
	public static BufferedImage[]leftArcoPlayer;
	
	public static BufferedImage[]downArcoAtivoPlayer;
	public static BufferedImage[]upArcoAtivoPlayer;
	public static BufferedImage[]rightArcoAtivoPlayer;
	public static BufferedImage[]leftArcoAtivoPlayer;
	
	public static BufferedImage[]staticDownPlayer;
	public static BufferedImage[]staticRightPlayer;
	public static BufferedImage[]staticLeftPlayer;
	
	public static BufferedImage[]staticDownArcoPlayer;
	public static BufferedImage[]staticRightArcoPlayer;
	public static BufferedImage[]staticLeftArcoPlayer;
	
	public static BufferedImage[]staticDanoDownPlayer;
	public static BufferedImage[]staticDanoRightPlayer;
	public static BufferedImage[]staticDanoLeftPlayer;
	public static BufferedImage staticDanoUpPlayer;

	public static BufferedImage[]staticDanoDownArcoPlayer;
	public static BufferedImage[]staticDanoRightArcoPlayer;
	public static BufferedImage[]staticDanoLeftArcoPlayer;
	public static BufferedImage staticDanoUpArcoPlayer;
	
	public static BufferedImage[]danoDownPlayer;
	public static BufferedImage[]danoUpPlayer;
	public static BufferedImage[]danoRightPlayer;
	public static BufferedImage[]danoLeftPlayer;
	
	public static BufferedImage[]danoDownArcoPlayer;
	public static BufferedImage[]danoUpArcoPlayer;
	public static BufferedImage[]danoRightArcoPlayer;
	public static BufferedImage[]danoLeftArcoPlayer;

	//walk:max frames=4,speed=1
	public int frames=0;
	public int maxFrames=3;
	public int index=0;
	public int maxIndex=15;
	
	public int framesS=-20;
	public int maxFramesS=4;
	public int indexS=0;
	public int maxIndexS=11;
	
	int framesDano;
	int cont=0;
	
	public static int mx=0;
	public static int my=0;
	
	public char posi='D';
	public void tick() {
		moved=false;
		if(life<=0) {
			Game.ESTADO="GAME_OVER";
		}
		if(right && Game.world.isFree(((int)this.x+speed)+maskx,(int)(this.y)+masky,40,52)) {
			posi='R';
			moved=true;
			x+=speed;
			//&& Game.world.isFree((((int)(this.x-speed))+maskx),getY())
		}else if(left && Game.world.isFree(((int)this.x-speed)+maskx,(int)(this.y)+masky,40,52)) {
			posi='L';
			moved=true;
			x-=speed;
		
		}
		if(up && Game.world.isFree((int)(this.x)+maskx,(int)((this.y-speed))+masky,40,52)) {
			posi='U';
			moved=true;
			y-=speed;
			
		}else if(down && Game.world.isFree((int)(this.x)+maskx,(int)(y+speed)+masky,40,52)) {
			posi='D';
			moved=true;
			y+=speed;
			
		}
		if(moved) {
			frames++;
			if(frames==maxFrames) {
				frames=0;
				index++;
				if(index>maxIndex) {
					index=0;
				}
			}
		}
		if(moved==false) {
			framesS++;
			if(framesS==maxFramesS) {
				framesS=0;
				indexS++;
				if(indexS>maxIndexS) {
					indexS=0;
					if(Game.rand.nextInt(100)<25) {
						framesS=-100;
					}else if(Game.rand.nextInt(100)>=25 && Game.rand.nextInt(100)<50) {
						framesS=-150;
					}else if(Game.rand.nextInt(100)>=50 && Game.rand.nextInt(100)<75) {
						framesS=-70;
					}else if(Game.rand.nextInt(100)>=75 && Game.rand.nextInt(100)<100) {
						framesS=-200;
					}
				}
			}
		}
		if(dano) {
			framesDano++;
			if(framesDano>=20) {
				dano=false;
				if(framesDano>=21) {
					framesDano=0;
				}
			}
		}
		//tiro
		if(tiro&&arco&Slime.dano==false&&Flechas.flechas>0) {
		
			int px=0;
			int py=0;
			int dx=0;
			int dy=0;
			
			if(posi=='R') {
				px=3;
				py=18;
				dx=1;
			}else if(posi=='L') {
				px=4;
				py=18;
				dx=-1;
			}else if(posi=='D') {
				px=4;
				py=20;
				dy=1;
			}else if(posi=='U') {
				px=-8;
				py=-18;
				dy=-1;
			}
			if(posi=='R') {
			if(cont==0) {
				FlechaShoot shootF=new FlechaShoot(getX()+px,getY()+py,64,64,Entity.FLECHA_RIGHT,dx,dy);
				Game.shoot.add(shootF);
				cont=1;
				Flechas.flechas--;
			}else {
				cont++;
				if(cont>20) {
					cont=0;
				}
			}
			}else if(posi=='L') {
				if(cont==0) {
					FlechaShoot shootF=new FlechaShoot(getX()+px,getY()+py,64,64,Entity.FLECHA_LEFT,dx,dy);
					Game.shoot.add(shootF);
					Flechas.flechas--;
					cont=1;
				}else {
					cont++;
					if(cont>20) {
						cont=0;
					}
				}
			}else if(posi=='U') {
				if(cont==0) {
					FlechaShoot shootF=new FlechaShoot(getX()+px,getY()+py,64,64,Entity.FLECHA_UP,dx,dy);
					Game.shoot.add(shootF);
					Flechas.flechas--;
					cont=1;
				}else {
					cont++;
					if(cont>20) {
						cont=0;
					}
				}
			}else if(posi=='D') {
				if(cont==0) {
					FlechaShoot shootF=new FlechaShoot(getX()+px,getY()+py,64,64,Entity.FLECHA_DOWN,dx,dy);
					Game.shoot.add(shootF);
					Flechas.flechas--;
					cont=1;
				}else {
					cont++;
					if(cont>20) {
						cont=0;
					}
				}
			}
				
		}else {
			cont=0;
		}
		checkisCollidingFlecha();
		checkIsCollidingLife();
		checkIsCollidingArco();

		Camera.x=Camera.Clamp(getX()-(Game.WIDTH/2)+(getW()/2), 0, World.WIDTH*64-Game.WIDTH );
		Camera.y=Camera.Clamp(getY()-(Game.HEIGHT/2)+(getH()/2), 0, World.HEIGHT*64-Game.HEIGHT );
		//System.out.println(life);

	}
	public void checkisCollidingFlecha() {
		for(int i=0;i<Game.entities.size();i++) {
			Entity e=Game.entities.get(i);
			if(e instanceof Flechas) {
				if(Entity.isColliding(this, e)) {
					Flechas.flechas+=100;
					Game.entities.remove(i);
				}
			}
		}
	}
	public void checkIsCollidingArco(){
		for(int i=0;i<Game.entities.size();i++) {
			Entity e=Game.entities.get(i);
			if(e instanceof Arco) {
				if(Entity.isColliding(this,e)) {	
					//recebe arco
					Game.entities.remove(i);
					arco=true;
				}
			}
		}
	}
	public void checkIsCollidingLife(){
		for(int i=0;i<Game.entities.size();i++) {
			Entity e=Game.entities.get(i);
			if(e instanceof Life) {
				if(Entity.isColliding(this,e)) {	
					life=life+10;
					Game.entities.remove(i);
					if(life>60) {
						life=60;
					}
				}
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(new Color(0,0,0,25));
		g.fillOval((getX()+16)-Camera.x,(getY()+(64-12))-Camera.y,30,15);
		if(arco==false) {
			
			if(!dano) {
				if(down) {
					g.drawImage(downPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(upPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(rightPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					
				}else if(left) {
					g.drawImage(leftPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
		
				}
				//static player
				else {
					if(posi=='D') {
						g.drawImage(staticDownPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(upPlayer[0],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(staticRightPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='L') {
						g.drawImage(staticLeftPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
		
					}
					
				}
				//fim
			}else if(dano==true) {
				//inicio
				if(down) {
					g.drawImage(danoDownPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(danoUpPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(danoRightPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					
				}else if(left) {
					g.drawImage(danoLeftPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
		
				}
				else {
					if(posi=='D') {
						g.drawImage(staticDanoDownPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(staticDanoUpPlayer,getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(staticDanoRightPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='L') {
						g.drawImage(staticDanoLeftPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
		
					}
					
				}
			}
		}else {
			if(tiro==false ) {
			if(!dano) {
				if(down) {
					g.drawImage(downArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(upArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(rightArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					
				}else if(left) {
					g.drawImage(leftArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
		
				}
				//static player
				else {
					if(posi=='D') {
						g.drawImage(staticDownArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(upArcoPlayer[0],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(staticRightArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='L') {
						g.drawImage(staticLeftArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
		
					}
					
				}
				//fim
			}else if(dano==true) {
				//inicio
				if(down) {
					g.drawImage(danoDownArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(danoUpArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(danoRightArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					
				}else if(left) {
					g.drawImage(danoLeftArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
		
				}
				//static player
				else {
					if(posi=='D') {
						g.drawImage(staticDanoDownArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(staticDanoUpArcoPlayer,getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(staticDanoRightArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='L') {
						g.drawImage(staticDanoLeftArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
		
					}
					
				}
			}
		}else if(tiro==true) {
			if(!dano) {
				if(down) {
					g.drawImage(downArcoAtivoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(upArcoAtivoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(arcos[0], getX()-Camera.x,getY()-Camera.y,null);
					g.drawImage(rightArcoAtivoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					g.drawImage(handArcoRight[0],getX()-Camera.x,getY()-Camera.y,null);

					
				}else if(left) {
					g.drawImage(leftArcoAtivoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					g.drawImage(handArcoLeft[0],getX()-Camera.x,getY()-Camera.y,null);
				}
				//static player
				else {
					if(posi=='D') {
						g.drawImage(this.handStaticArcoRLUP[3],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(handStaticArcoRLUP[2],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(arcos[0], getX()-Camera.x,getY()-Camera.y,null);
						g.drawImage(handStaticArcoRLUP[0],getX()-Camera.x, getY()-Camera.y, null);
						g.drawImage(handArcoRight[0],getX()-Camera.x,getY()-Camera.y,null);
						
					}else if(posi=='L') {
						g.drawImage(handStaticArcoRLUP[1],getX()-Camera.x, getY()-Camera.y, null);
						g.drawImage(handArcoLeft[0],getX()-Camera.x,getY()-Camera.y,null);
		
					}
					
				}
				//fim
			}else if(dano==true) {
				//inicio
				if(down) {
					g.drawImage(danoDownArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
					
				}else if(up) {
					g.drawImage(danoUpArcoPlayer[index],getX()-Camera.x, getY()-Camera.y, null);
		
				}
				else if(right) {
					g.drawImage(danoRightArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
					
				}else if(left) {
					g.drawImage(danoLeftArcoPlayer[index], getX()-Camera.x,getY()-Camera.y,null);
		
				}
				//static player
				else {
					if(posi=='D') {
						g.drawImage(staticDanoDownArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='U') {
						g.drawImage(staticDanoUpArcoPlayer,getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='R') {
						g.drawImage(staticDanoRightArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
						
					}else if(posi=='L') {
						g.drawImage(staticDanoLeftArcoPlayer[indexS],getX()-Camera.x, getY()-Camera.y, null);
		
					}
					
				}
			}
		}
		
		}
	}
	public Player(int x, int y, int w, int h, BufferedImage sheet) {
		
		super(x, y, w, h, sheet);
		
		handStaticArcoRight=Game.sheetArcoAtivoPlayer.getSprite(64,64*8, 64,64);
		handStaticArcoLeft=Game.sheetArcoAtivoPlayer.getSprite(128,64*8,64,64);
		handStaticArcoUp=Game.sheetArcoAtivoPlayer.getSprite(128+64,64*8, 64,64);
		handStaticArcoDown=Game.sheetArcoAtivoPlayer.getSprite(0,64*8, 64,64);

		downPlayer=new BufferedImage[16];
		rightPlayer=new BufferedImage[16];
		leftPlayer=new BufferedImage[16];
		upPlayer=new BufferedImage[16];
		
		handStaticArcoRLUP=new BufferedImage[4];
		
		handStaticArcoRLUP[0]=Game.sheetArcoAtivoPlayer.getSprite(64,64*8, 64,64);
		handStaticArcoRLUP[1]=Game.sheetArcoAtivoPlayer.getSprite(128,64*8,64,64);
		handStaticArcoRLUP[2]=Game.sheetArcoAtivoPlayer.getSprite(128+64,64*8, 64,64);
		handStaticArcoRLUP[3]=Game.sheetArcoAtivoPlayer.getSprite(0,64*8, 64,64);
						
		downArcoPlayer=new BufferedImage[16];
		rightArcoPlayer=new BufferedImage[16];
		leftArcoPlayer=new BufferedImage[16];
		upArcoPlayer=new BufferedImage[16];
		
		downArcoAtivoPlayer=new BufferedImage[16];
		rightArcoAtivoPlayer=new BufferedImage[16];
		leftArcoAtivoPlayer=new BufferedImage[16];
		upArcoAtivoPlayer=new BufferedImage[16];
		
		
		staticDownPlayer=new BufferedImage[12];
		staticRightPlayer=new BufferedImage[12];
		staticLeftPlayer=new BufferedImage[12];
		
		staticDownArcoPlayer=new BufferedImage[12];
		staticRightArcoPlayer=new BufferedImage[12];
		staticLeftArcoPlayer=new BufferedImage[12];
		
		staticDanoDownPlayer=new BufferedImage[12];
		staticDanoRightPlayer=new BufferedImage[12];
		staticDanoLeftPlayer=new BufferedImage[12];
		
		staticDanoDownArcoPlayer=new BufferedImage[12];
		staticDanoRightArcoPlayer=new BufferedImage[12];
		staticDanoLeftArcoPlayer=new BufferedImage[12];
		
		danoDownPlayer=new BufferedImage[16];
		danoRightPlayer=new BufferedImage[16];
		danoLeftPlayer=new BufferedImage[16];
		danoUpPlayer=new BufferedImage[16];
		
		danoDownArcoPlayer=new BufferedImage[16];
		danoRightArcoPlayer=new BufferedImage[16];
		danoLeftArcoPlayer=new BufferedImage[16];
		danoUpArcoPlayer=new BufferedImage[16];
		
		arcos=new BufferedImage[2];
		
		staticDanoUpPlayer=Game.sheetPlayer.getSprite(0, 28*64, 64, 64);
		staticDanoUpArcoPlayer=Game.arcoPlayer.getSprite(0, 28*64, 64, 64);
		
		handArcoRight=new BufferedImage[1];
		handArcoLeft=new BufferedImage[1];
		arcos[0]=Game.sheetArcoAtivoPlayer.getSprite(64*3, 1152, 64,64);
		arcos[1]=Game.sheetArcoAtivoPlayer.getSprite(64*3, 1152+64, 64,64);

		//hand
		handArcoRight[0]=Game.sheetArcoAtivoPlayer.getSprite(0, 1152, 64,64);
		handArcoLeft[0]=Game.sheetArcoAtivoPlayer.getSprite(0, 1152+64, 64,64);

		for(int i=0;i<2;i++) {
			for(int ii=0;ii<downPlayer.length/2;ii++) {
				downPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,i*64, 64, 64);
				rightPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*2)+(i*64), 64, 64);
				leftPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*4)+(i*64), 64, 64);
				upPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*6)+(i*64), 64, 64);
				
				downArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,i*64, 64, 64);
				rightArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*2)+(i*64), 64, 64);
				leftArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*4)+(i*64), 64, 64);
				upArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*6)+(i*64), 64, 64);
				
				downArcoAtivoPlayer[ii+(i*8)]=Game.sheetArcoAtivoPlayer.getSprite(ii*64,i*64, 64, 64);
				rightArcoAtivoPlayer[ii+(i*8)]=Game.sheetArcoAtivoPlayer.getSprite(ii*64,(64*2)+(i*64), 64, 64);
				leftArcoAtivoPlayer[ii+(i*8)]=Game.sheetArcoAtivoPlayer.getSprite(ii*64,(64*4)+(i*64), 64, 64);
				upArcoAtivoPlayer[ii+(i*8)]=Game.sheetArcoAtivoPlayer.getSprite(ii*64,(64*6)+(i*64), 64, 64);
				
				danoDownPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*14)+i*64, 64, 64);
				danoRightPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*16)+(i*64), 64, 64);
				danoLeftPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*18)+(i*64), 64, 64);
				danoUpPlayer[ii+(i*8)]=Game.sheetPlayer.getSprite(ii*64,(64*20)+(i*64), 64, 64);
				
				danoDownArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*14)+i*64, 64, 64);
				danoRightArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*16)+(i*64), 64, 64);
				danoLeftArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*18)+(i*64), 64, 64);
				danoUpArcoPlayer[ii+(i*8)]=Game.arcoPlayer.getSprite(ii*64,(64*20)+(i*64), 64, 64);

			}
		}
		for(int i=0;i<2;i++) {
			for(int ii=0;ii<staticDownPlayer.length/2;ii++) {
				staticDownPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*8)+(i*64), 64, 64);
				staticRightPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*10)+(i*64), 64, 64);
				staticLeftPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*12)+(i*64), 64, 64);
				
				staticDownArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*8)+(i*64), 64, 64);
				staticRightArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*10)+(i*64), 64, 64);
				staticLeftArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*12)+(i*64), 64, 64);
				
				staticDanoDownPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*22)+(i*64), 64, 64);
				staticDanoRightPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*24)+(i*64), 64, 64);
				staticDanoLeftPlayer[ii+(i*6)]=Game.sheetPlayer.getSprite(ii*64,(64*26)+(i*64), 64, 64);
				
				staticDanoDownArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*22)+(i*64), 64, 64);
				staticDanoRightArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*24)+(i*64), 64, 64);
				staticDanoLeftArcoPlayer[ii+(i*6)]=Game.arcoPlayer.getSprite(ii*64,(64*26)+(i*64), 64, 64);
				
			}
		}
		
	}

}
