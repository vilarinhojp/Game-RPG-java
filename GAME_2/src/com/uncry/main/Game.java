package com.uncry.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import com.uncry.entities.Construct;
import com.uncry.entities.Entity;
import com.uncry.entities.FlechaShoot;
import com.uncry.entities.Flechas;
import com.uncry.entities.Player;
import com.uncry.graphics.Spritesheetarcoativoplayer;
import com.uncry.graphics.Spritesheetarcoplayer;
import com.uncry.graphics.Spritesheetconstruction;
import com.uncry.graphics.Spritesheetenemies;
import com.uncry.graphics.Spritesheetentities;
import com.uncry.graphics.Spritesheetplayer;
import com.uncry.graphics.Spritesheetui;
import com.uncry.graphics.Spritesheetworld;
import com.uncry.graphics.UI;
import com.uncry.world.World;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static JFrame frame;
	public static final int WIDTH=360+50;
	public static final int HEIGHT=240+50;
	public static final int SCALE=2;
	
	public Thread thread;
	public static boolean isRunning;
	
	public static BufferedImage image;
	public static ArrayList<Entity>entities;
	public static ArrayList<Entity>enemies;
	public static ArrayList<Entity>elementos;
	public static ArrayList<FlechaShoot>shoot;
	
	public static Spritesheetplayer sheetPlayer;
	public static Spritesheetarcoativoplayer sheetArcoAtivoPlayer;
	public static Spritesheetworld sheetWorld;
	public static Spritesheetconstruction sheetConstruct;
	public static Spritesheetarcoplayer arcoPlayer;
	public static Spritesheetentities sheetEntity;
	public static Spritesheetenemies sheetEnemies;
	public static Spritesheetui sheetUI;
	public static Construct constr;
	public static Player player;
	public static World world;
	public static UI ui;
	public static Random rand;
	
	public static String ESTADO="NORMAL";
	//public static String ESTADO="GAME_OVER";
	private static int LEVEL=1,MAX_LEVEL=2;
	public void initFrame() {
		frame=new JFrame("Purple World");
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		addKeyListener(this);

		
	}
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		isRunning=true;
		
	}
	public synchronized void stop() {
		try {
			thread.join();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		isRunning=false;
		
	}
	public void tick() {
		
		if(ESTADO=="NORMAL") {
		for(int i=0;i<enemies.size();i++){
			Entity e=enemies.get(i);
			e.tick();
		}
		for(int i=0;i<entities.size();i++) {
			Entity e=entities.get(i);
			e.tick();
			
		}
		
		for(int i=0;i<elementos.size();i++) {
			Entity e=elementos.get(i);
			e.tick();
		}
		for(int i=0;i<shoot.size();i++) {
			shoot.get(i).tick();
		}
		if(Game.enemies.size()==0) {
			LEVEL++;
			if(LEVEL>MAX_LEVEL) {
				LEVEL=1;
			}
			String newWorld="fase"+LEVEL+".png";
			World.restart_1(newWorld);

		}
		ui.tick();
		}
		
	}
	public void render() {
		
		BufferStrategy bs=getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g=image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		world.render(g);
		
		
		for(int i=0;i<enemies.size();i++){
			Entity e=enemies.get(i);
			if(player.getY()>e.getY() ||player.getY()==e.getY()) {
				e.render(g);;
			}else {
				continue;
			}
		}
		for(int i=0;i<elementos.size();i++) {
			Entity a=elementos.get(i);
			a.render(g);
		}
		for(int i=0;i<entities.size();i++) {
			Entity e=entities.get(i);
			e.render(g);
		}
		for(int i=0;i<enemies.size();i++){
			Entity e=enemies.get(i);
			if(player.getY()<e.getY() ) {
				e.render(g);
			}else {
			    continue;
			}
		}
		for(int i=0;i<shoot.size();i++) {
			shoot.get(i).render(g);
		}
		ui.render(g);
		g.setColor(new Color(0,191,255,10));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(205,92,92,20));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		g=bs.getDrawGraphics();
		g.drawImage(image, 0, 0,WIDTH*SCALE,HEIGHT*SCALE,null);
		if(player.arco) {
		g.setFont(new Font("Hobo Std",Font.BOLD,23));
		g.setColor(new Color(239,253,255));
		g.drawString(""+Flechas.flechas,WIDTH*SCALE-64,70);
		}
		
		if(ESTADO=="GAME_OVER") {
			Graphics2D g2=(Graphics2D)g;
			g2.setColor(new Color(0,0,0,100));
			g2.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
			g2.setColor(new Color(242,143,101));
			g.fillRect((this.WIDTH/2-50),this.HEIGHT-75,550,94);
			g2.setColor(new Color(242,211,121));
			g.fillRect((this.WIDTH/2-50),this.HEIGHT-75,550,88);
			
			g2.setColor(new Color(242,143,101));
			g2.setFont(new Font("Pixel-Art",Font.BOLD,80));
			g2.drawString("GAME OVER",(this.WIDTH/2-40),this.HEIGHT+4);
			g2.setColor(Color.white);
			g2.setFont(new Font("Pixel-Art",Font.BOLD,80));
			g2.drawString("GAME OVER",(this.WIDTH/2-40),this.HEIGHT);
			

			g2.setColor(new Color(242,143,101));
			g2.setFont(new Font("Pixel-Art",Font.BOLD,18));
			g2.drawString("PRESS ENTER FOR CONTINUE",(this.WIDTH/2+65),this.HEIGHT+42);
			g2.setColor(Color.white);
			g2.setFont(new Font("Pixel-Art",Font.BOLD,18));
			g2.drawString("PRESS ENTER FOR CONTINUE",(this.WIDTH/2+65),this.HEIGHT+40);
			
		}
		
		bs.show();
		
	}
	public void run() {
		double lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double timer=System.currentTimeMillis();
		double delta=0;
		int frames=0;
		
		while(isRunning) {
			requestFocus();
			double now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			
			if(delta>=1) {
				tick();
				render();
				frames++;
				delta--;
				
			}
			if(System.currentTimeMillis()-timer>=1000) {
				timer+=1000;
				System.out.println("FPS: "+frames);
				frames=0;
						
			}
		}
		stop();
	}
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		entities=new ArrayList<Entity>();
		elementos=new ArrayList<Entity>();
		enemies=new ArrayList<Entity>();
		shoot=new ArrayList<FlechaShoot>();
		rand=new Random();
		sheetConstruct=new Spritesheetconstruction("/Spritesheetconstruction.png");
		sheetWorld=new Spritesheetworld("/Spritesheetworld.png");
		sheetPlayer=new Spritesheetplayer("/Spritesheetplayer.png");
		arcoPlayer=new Spritesheetarcoplayer("/Spritesheetplayerarco.png");
		sheetArcoAtivoPlayer=new Spritesheetarcoativoplayer("/Spritesheetplayerarcoati.png");
		sheetEntity=new Spritesheetentities("/Spritesheetentities.png");
		sheetEnemies=new Spritesheetenemies("/Spritesheetenemies.png");
		sheetUI=new Spritesheetui("/Spritesheetui.png");
		world=new World("/fase1.png");
		player=new Player(64*4,64*4,64,64,sheetPlayer.getSprite(0, 0, 64, 64));
		entities.add(player);
		ui=new UI(0,0);
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			player.tiro=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=true;
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=true;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=true;
			
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=true;
			
		}
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			player.tiro=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=false;
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=false;
			
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=false;
			
		}
	}

	public static void main(String[]args) {
		Game game=new Game();
		game.start();
		
	}

}
