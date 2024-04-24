package com.uncry.entities;

import java.awt.image.BufferedImage;

public class Life extends Entity {
	public int contador;
	
	public void tick() {
		contador++;
		if(contador<=10) {
			y++;
			
		}
		if(contador>=10 && contador<20) {
			y--;
			
		}else if(contador>=20){
			contador=0;
			
		}
	}

	public Life(int x, int y, int w, int h, BufferedImage sheet) {
		super(x, y, w, h, sheet);
		contador=0;
		
	}

}
