package com.uncry.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import com.uncry.entities.Abelha;
import com.uncry.entities.Arco;
import com.uncry.entities.Bandeira;
import com.uncry.entities.CatDevil;
import com.uncry.entities.Entity;
import com.uncry.entities.Flechas;
import com.uncry.entities.Life;
import com.uncry.entities.Player;
import com.uncry.entities.Slime;
import com.uncry.entities.Tronco;
import com.uncry.graphics.Spritesheetconstruction;
import com.uncry.graphics.Spritesheetenemies;
import com.uncry.graphics.Spritesheetentities;
import com.uncry.graphics.Spritesheetplayer;
import com.uncry.graphics.Spritesheetui;
import com.uncry.graphics.Spritesheetworld;
import com.uncry.main.Game;

public class World {
	
	public static int WIDTH,HEIGHT;
	public Tiles[]tile;
	int TILE_SIZE=64;
	public World(String path) {
		try {
			BufferedImage map=ImageIO.read(getClass().getResource(path));
			WIDTH=map.getWidth();
			HEIGHT=map.getHeight();
			tile=new Tiles[WIDTH*HEIGHT];
			int[] pixels=new int[WIDTH*HEIGHT];
			map.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
			
			for(int xx=0;xx<WIDTH;xx++) {
				for(int yy=0;yy<HEIGHT;yy++) {
					
					int index=xx+(yy*WIDTH);
					int pixelAtual=pixels[index];
					
					switch(pixelAtual) {
					//grama sólida
					case(0xFF70D8A3):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_1);
					break;
					case(0xFF5AAD90):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_2);
					break;
					case(0xFFAAE2CF):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_3);
					break;
					case(0xFF70D8D4):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_4);
					break;
					
					//grama lateral
					case(0xFFB2FFD7):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_LATERAL_RIGHT_TILE);
					break;
					case(0xFF36DB86):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_LATERAL_LEFT_TILE);
					break;
					case(0xFF7FFFBD):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_LATERAL_DOWN_TILE);
					break;
					case(0xFF63FFAE):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_LATERAL_UP_TILE);
					break;
					
					//grama de canto
					case(0xFF00C15D):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_CANTO_LEFT_UP_TILE);
					break;
					case(0xFF00A04A):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_CANTO_RIGHT_UP_TILE);
					break;
					case(0xFF00823A):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_CANTO_LEFT_DOWN_TILE);
					break;
					case(0xFF00602B):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_CANTO_RIGHT_DOWN_TILE);
					break;
					//caminhos
					case(0xFF8E8E8E):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_WALL_TILE);
					break;
					//casa 1
					case(0xFFF226DD):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_1);

					break;
					case(0xFFEA25D6):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_2);
					    Game.entities.add(new CatDevil(xx*64,yy*64,64,64,Entity.CAT_DEVIL));
					break;
					case(0xFFE224CF):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_3);
					break;
					case(0xFFDD23CB):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_4);
					break;
					//casa 2
					case(0xFFC11FB4):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_2_1);
					break;
					case(0xFFBA1DAD):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_2_2);
					break;
					case(0xFFB21CA6):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_2_3);
					break;
					case(0xFFA81A9C):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_2_4);
					break;
					//casa 3
					case(0xFF911787):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_3_1);
					break;
					case(0xFF87157D):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_3_2);
					break;
					case(0xFF77136F):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_3_3);
					break;
					case(0xFF701168):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_3_4);
					break;
					//casa 4
					case(0xFF560D50):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_4_1);
					break;
					case(0xFF4F0C49):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_4_2);
					break;
					case(0xFF470B42):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_4_3);
					break;
					case(0xFF3F0A3B):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_4_4);
					break;
					//casa back 1
					case(0xFFB01EFF):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_1_1);
						Game.elementos.add(new Bandeira(xx*64,yy*64,64,64,Entity.BANDEIRA));
					break;
					case(0xFFA91DF4):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_1_2);
					break;
					case(0xFFA41CED):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_1_3);
					break;
					case(0xFF9E1BE5):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_1_4);
					break;
					//casa back 2
					case(0xFF921AD8):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_2_1);
					break;
					case(0xFF8D19D1):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_2_2);
					break;
					case(0xFF8818C9):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_2_3);
					break;
					case(0xFF8317C1):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_2_4);
					break;
					//casa back 3
					case(0xFF7E16BA):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_3_1);
					break;
					case(0xFF7815B2):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_3_2);
					break;
					case(0xFF7314AA):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_3_3);
					break;
					case(0xFF6E13A3):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_3_4);
					break;
					//casa back 4
					case(0xFF6F14A8):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_4_1);
					break;
					case(0xFF6A13A0):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_4_2);
					break;
					case(0xFF631296):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_4_3);
					break;
					case(0xFF5E118E):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.HOUSE_BACK_4_4);
					break;
					//taverna 1
					case(0xFFD3B8AD):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_1);
					break;
					case(0xFFD3A492):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_2);
					break;
					case(0xFFD3957C):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_3);
					break;
					case(0xFFD68968):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_4);
					break;
					case(0xFFCE8465):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_5);
					break;
					case(0xFFC67F61):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_6);
					break;
					case(0xFFBF7A5D):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_7);
					break;
					case(0xFFB77659):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_8);
					break;
					case(0xFFAF7156):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.TAVERNA_9);
					break;
					case(0xFFA86C52):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.TAVERNA_10);
					break;
					case(0xFFA0674E):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.TAVERNA_11);
					break;
					case(0xFF99624A):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.TAVERNA_12);
					break;
					//elevações
					case(0xFFACDD61):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_LATERAL_LEFT);
					break;
					case(0xFFA0CE5A):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_LATERAL_RIGHT);
					break;
					case(0xFF98C456):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_CANTO_LEFT);
					break;
					case(0xFF88AF4D):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_CANTO_RIGHT);
					break;
					case(0xFFD8FF6D):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_CANTO_LEFT_UP);
					break;
					case(0xFFD8FF9B):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_CANTO_RIGHT_UP);
					break;
					case(0xFF90BA51):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_FRONTAL);
					break;
					case(0xFFD8E06D):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.ELEVACAO_UP);
					break;
					case(0xFF5B7533):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_ESCADA);
					break;
					//paredes de grama
					case(0xFF003014):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.GRASS_WALL_1);
					break;
					case(0xFF003064):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.GRASS_WALL_2);
					break;
					case(0xFF002360):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.GRASS_WALL_3);
					break;
					//slime
					case(0xFFFF002A):
						//adicionar setmask do slime
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.GRASS_LATERAL_DOWN_TILE);
					    Slime slime=new Slime(xx*64,yy*64,64,64,Entity.SLIME);
					    slime.setMask(17, 41,29,9);
						Game.enemies.add(slime);
					break;
					//bee
					case(0xFF23CFFF):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.GRASS_WALL_2);
						Game.elementos.add(new Abelha(xx*64,yy*64,64,64,Entity.ABELHA));
					break;
					//tronco
					case(0xFFEA0027):
						tile[index]=new WallTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_1);
						Game.elementos.add(new Tronco(xx*64,yy*64,64,64,Entity.TROCO));
						Game.elementos.add(new Abelha(xx*64,yy*64,64,64,Entity.ABELHA));
					break;
					//flechas
					case(0xFFB2001D):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_2);
						Flechas flechas=new Flechas(xx*64,yy*64,64,64,Entity.FLECHA);
						flechas.setMask(30, 30,7,5);
						Game.entities.add(flechas);
					break;
					//arco
					case(0xFF7C0014):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_2);
						Arco arco=new Arco(xx*64,yy*64,64,64,Entity.ARCO);
						arco.setMask(30, 30,7,5);
						Game.entities.add(arco);
					break;
					//LifeTree
					case(0xFFCE0022):
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_1);
						Life life=new Life(xx*64,yy*64,64,64,Entity.HEART);
						life.setMask(23, 27,17,15);
						Game.entities.add(life);

					break;
					default:
						tile[index]=new FloorTile(xx*64,yy*64,64,64,Tiles.FLOOR_GRASS_TILE_1);

					break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean isFree(int nextx,int nexty,int width,int height) {
		int x1= nextx/TILE_SIZE;
		int y1= nexty/TILE_SIZE;
		
		int x2=(nextx+width-1)/TILE_SIZE;
		int y2=nexty/TILE_SIZE;
		
		int x3=nextx/TILE_SIZE;
		int y3=(nexty+height-1)/TILE_SIZE;
		
		int x4=(nextx+width-1)/TILE_SIZE;
		int y4=(nexty+height-1)/TILE_SIZE;
		
		return !(tile[x1+(y1*WIDTH)]instanceof WallTile || tile[x2+(y2*WIDTH)]instanceof WallTile || 
				tile[x3+(y3*WIDTH)]instanceof WallTile || tile[x4+(y4*WIDTH)]instanceof WallTile);
	}
	public static void restart_1(String level) {
			Slime.dano=false;
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
			Game.world=new World("/"+level);
			Game.player=new Player(64*4,64*4,64,64,Game.sheetPlayer.getSprite(0, 0, 64, 64));
			Game.entities.add(Game.player);
			return;

	}
	public void render(Graphics g) {
		
		int startx=Camera.x/64;
		int starty=Camera.y/64;
		int finalx=startx+(Game.WIDTH/64);
		int finaly=starty+(Game.HEIGHT/64);
		
		for(int xx=startx;xx<finalx+2;xx++) {
			for(int yy=starty;yy<finaly+2;yy++) {
				if(xx<0||yy<0||xx>=WIDTH||yy>=HEIGHT) {
					 continue;
				}else {
					Tiles tiles= tile[xx+(yy*WIDTH)];
					tiles.render(g);
				}
			}
		}
	}
}
