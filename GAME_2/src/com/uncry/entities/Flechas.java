package com.uncry.entities;

import java.awt.image.BufferedImage;

public class Flechas extends Entity{
	public int contador;
	public static int flechas=0;
	public void tick() {
	
	}
	public Flechas(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
	}

}
