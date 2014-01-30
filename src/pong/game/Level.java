package pong.game;

import java.util.ArrayList;
import sheep.graphics.Color;
import android.graphics.Canvas;

public class Level {

	private ArrayList<Wall> walls;
	private int width, height;
	
	public Level(){
		walls = new ArrayList<Wall>();
		walls.add(new Wall(0,0,TitleScreen.WIDTH,10,Color.WHITE));
		walls.add(new Wall(0, TitleScreen.HEIGHT - 10, TitleScreen.WIDTH, TitleScreen.HEIGHT, Color.WHITE));
	}
	
	public void draw(Canvas can){
		for (Wall wall : walls) {
			wall.draw(can);
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
