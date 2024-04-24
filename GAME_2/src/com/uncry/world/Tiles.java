package com.uncry.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.uncry.main.Game;

public class Tiles {
	private int x,y,w,h;
	public BufferedImage sheet;
	public static int TILE_SIZE=64;
	//gramas sólidas
	public static BufferedImage FLOOR_GRASS_TILE_1=Game.sheetWorld.getSprite(0,0, 64,64);
	public static BufferedImage FLOOR_GRASS_TILE_2=Game.sheetWorld.getSprite(64,0, 64,64);
	public static BufferedImage FLOOR_GRASS_TILE_3=Game.sheetWorld.getSprite(64*2,0, 64,64);
	public static BufferedImage FLOOR_GRASS_TILE_4=Game.sheetWorld.getSprite(64*3,0, 64,64);
	//gramas de lado
	public static BufferedImage GRASS_LATERAL_RIGHT_TILE=Game.sheetWorld.getSprite(64*4,0, 64,64);
	public static BufferedImage GRASS_LATERAL_LEFT_TILE=Game.sheetWorld.getSprite(64*5,0, 64,64);
	public static BufferedImage GRASS_LATERAL_DOWN_TILE=Game.sheetWorld.getSprite(64*6,0, 64,64);
	public static BufferedImage GRASS_LATERAL_UP_TILE=Game.sheetWorld.getSprite(64*7,0, 64,64);
	//grames de canto
	public static BufferedImage GRASS_CANTO_LEFT_UP_TILE=Game.sheetWorld.getSprite(64*8,0, 64,64);
	public static BufferedImage GRASS_CANTO_RIGHT_UP_TILE=Game.sheetWorld.getSprite(64*9,0, 64,64);
	public static BufferedImage GRASS_CANTO_LEFT_DOWN_TILE=Game.sheetWorld.getSprite(0,64, 64,64);
	public static BufferedImage GRASS_CANTO_RIGHT_DOWN_TILE=Game.sheetWorld.getSprite(64,64, 64,64);
	//casa1
	public static BufferedImage HOUSE_1=Game.sheetConstruct.getSprite(0, 0, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_2=Game.sheetConstruct.getSprite(64, 0, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_3=Game.sheetConstruct.getSprite(0, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_4=Game.sheetConstruct.getSprite(64, 64, TILE_SIZE,TILE_SIZE);
	//casa2
	public static BufferedImage HOUSE_2_1=Game.sheetConstruct.getSprite(0, 64*2, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_2_2=Game.sheetConstruct.getSprite(64, 64*2, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_2_3=Game.sheetConstruct.getSprite(0, 64*3, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_2_4=Game.sheetConstruct.getSprite(64, 64*3, TILE_SIZE,TILE_SIZE);
	//casa3
	public static BufferedImage HOUSE_3_1=Game.sheetConstruct.getSprite(0, 64*4, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_3_2=Game.sheetConstruct.getSprite(64, 64*4, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_3_3=Game.sheetConstruct.getSprite(0, 64*5, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_3_4=Game.sheetConstruct.getSprite(64, 64*5, TILE_SIZE,TILE_SIZE);
	//casa4
	public static BufferedImage HOUSE_4_1=Game.sheetConstruct.getSprite(0, 64*6, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_4_2=Game.sheetConstruct.getSprite(64, 64*6, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_4_3=Game.sheetConstruct.getSprite(0, 64*7, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_4_4=Game.sheetConstruct.getSprite(64, 64*7, TILE_SIZE,TILE_SIZE);
	//casa back1
	public static BufferedImage HOUSE_BACK_1_1=Game.sheetConstruct.getSprite(0, 64*8, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_1_2=Game.sheetConstruct.getSprite(64, 64*8, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_1_3=Game.sheetConstruct.getSprite(0, 64*9, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_1_4=Game.sheetConstruct.getSprite(64, 64*9, TILE_SIZE,TILE_SIZE);
	//casa back2
	public static BufferedImage HOUSE_BACK_2_1=Game.sheetConstruct.getSprite(64*2, 64*4, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_2_2=Game.sheetConstruct.getSprite(64*3, 64*4, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_2_3=Game.sheetConstruct.getSprite(64*2, 64*5, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_2_4=Game.sheetConstruct.getSprite(64*3, 64*5, TILE_SIZE,TILE_SIZE);
	//casa back3
	public static BufferedImage HOUSE_BACK_3_1=Game.sheetConstruct.getSprite(64*2, 64*6, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_3_2=Game.sheetConstruct.getSprite(64*3, 64*6, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_3_3=Game.sheetConstruct.getSprite(64*2, 64*7, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_3_4=Game.sheetConstruct.getSprite(64*3, 64*7, TILE_SIZE,TILE_SIZE);
	//casa back4
	public static BufferedImage HOUSE_BACK_4_1=Game.sheetConstruct.getSprite(64*2, 64*8, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_4_2=Game.sheetConstruct.getSprite(64*3, 64*8, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_4_3=Game.sheetConstruct.getSprite(64*2, 64*9, TILE_SIZE,TILE_SIZE);
	public static BufferedImage HOUSE_BACK_4_4=Game.sheetConstruct.getSprite(64*3, 64*9, TILE_SIZE,TILE_SIZE);
	//taverna
	public static BufferedImage TAVERNA_1=Game.sheetConstruct.getSprite(64*2,0, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_2=Game.sheetConstruct.getSprite(64*3,0, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_3=Game.sheetConstruct.getSprite(64*4,0, TILE_SIZE,TILE_SIZE);
	
	public static BufferedImage TAVERNA_4=Game.sheetConstruct.getSprite(64*2,64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_5=Game.sheetConstruct.getSprite(64*3,64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_6=Game.sheetConstruct.getSprite(64*4,64, TILE_SIZE,TILE_SIZE);
	
	public static BufferedImage TAVERNA_7=Game.sheetConstruct.getSprite(64*2,64*2, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_8=Game.sheetConstruct.getSprite(64*3,64*2, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_9=Game.sheetConstruct.getSprite(64*4, 64*2, TILE_SIZE,TILE_SIZE);
	
	public static BufferedImage TAVERNA_10=Game.sheetConstruct.getSprite(64*2, 64*3, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_11=Game.sheetConstruct.getSprite(64*3, 64*3, TILE_SIZE,TILE_SIZE);
	public static BufferedImage TAVERNA_12=Game.sheetConstruct.getSprite(64*4, 64*3, TILE_SIZE,TILE_SIZE);
	
	//elevação
	public static BufferedImage ELEVACAO_CANTO_LEFT=Game.sheetWorld.getSprite(64*2, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_CANTO_RIGHT=Game.sheetWorld.getSprite(64*5, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_CANTO_LEFT_UP=Game.sheetWorld.getSprite(64*8, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_CANTO_RIGHT_UP=Game.sheetWorld.getSprite(64*9, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_FRONTAL=Game.sheetWorld.getSprite(64*3, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_UP=Game.sheetWorld.getSprite(64*4, 64*2, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_LATERAL_LEFT=Game.sheetWorld.getSprite(64*6, 64, TILE_SIZE,TILE_SIZE);
	public static BufferedImage ELEVACAO_LATERAL_RIGHT=Game.sheetWorld.getSprite(64*7, 64, TILE_SIZE,TILE_SIZE);
	//escada
	public static BufferedImage GRASS_ESCADA=Game.sheetWorld.getSprite(64*4, 64, TILE_SIZE,TILE_SIZE);
	//paredes de grama
	public static BufferedImage GRASS_WALL_1=Game.sheetWorld.getSprite(64,64*2, 64,64);
	public static BufferedImage GRASS_WALL_2=Game.sheetWorld.getSprite(64*2,64*2, 64,64);
	public static BufferedImage GRASS_WALL_3=Game.sheetWorld.getSprite(64*3,64*2, 64,64);

	public static BufferedImage FLOOR_WALL_TILE=Game.sheetWorld.getSprite(0,64*2, 64,64);

	public Tiles(int x,int y,int w,int h,BufferedImage sheet) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.sheet=sheet;
	}
	
	public void render(Graphics g) {
		g.drawImage(sheet, x-Camera.x, y-Camera.y,w,h, null);
	}
}
