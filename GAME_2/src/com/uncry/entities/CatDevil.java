package com.uncry.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;
import com.uncry.world.Camera;

public class CatDevil extends Entity{
	
	public static BufferedImage[]CAT_DEVIL_DOWN;
	public static BufferedImage[]CAT_DEVIL_UP;
	
	public static boolean parado=false;
	
	public static int frames=0;
	public static int maxFrames=5;
	public static int index=0;
	public static int maxIndex=6;
	
	public void tick() {
		if(parado==false) {
			frames++;
			if(frames==maxFrames) {
				frames=0;
				index++;
				if(index>maxIndex) {
					int intervalo=Game.rand.nextInt(500);
					frames=0-(intervalo+100);
					parado=true;
					index=0;

				}
			}
		}else if(parado==true) {
			frames++;
			if(frames==maxFrames) {
				frames=0;
				index++;
				if(index>maxIndex) {
					int intervalo=Game.rand.nextInt(500);
					frames=0-(intervalo+100);
					parado=false;
					index=0;		

				}
			}
		}
		
	}
	public void render(Graphics g) {
		g.setColor(new Color(0,0,0,20));
		g.fillOval((getX()+17)-Camera.x,(getY()+40)-Camera.y, 30,10);
		if(parado==true) {
			g.drawImage(CAT_DEVIL_UP[index], getX()-Camera.x,getY()-Camera.y, null);
		}else if(parado==false) {
			g.drawImage(CAT_DEVIL_DOWN[index], getX()-Camera.x,getY()-Camera.y, null);

		}
	}
	public CatDevil(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		CAT_DEVIL_DOWN=new BufferedImage[7];
		CAT_DEVIL_UP=new BufferedImage[7];
		
		for(int i=0;i<CAT_DEVIL_DOWN.length;i++) {
			CAT_DEVIL_DOWN[i]=Game.sheetEntity.getSprite(i*64, 0,64,64);
			CAT_DEVIL_UP[i]=Game.sheetEntity.getSprite(i*64, 64,64,64);

		}
		
	}

}
