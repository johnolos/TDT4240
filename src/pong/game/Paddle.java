package pong.game;

import sheep.game.Sprite;
import sheep.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Paddle extends Sprite{
	
	private Rect rectangle;
	private Color color;
	private int height, width;
	
	public Paddle(int x, int y){
		height = 100;
		width = 10;
		rectangle = new Rect(x-width, y-height/2, x, y+height/2);
		this.color = Color.WHITE;
	}
	
	public void update(float dt){
		super.update(dt);
	}
	
	public void draw(Canvas canvas){
		canvas.drawRect(rectangle, color);
	}
	
	public void move(int y){
		if(y-height/2 < 0)
			y = height/2;
		if(y + height/2 > TitleScreen.HEIGHT)
			y = TitleScreen.HEIGHT - height/2;
		rectangle.top = y-height/2;
		rectangle.bottom = y + height/2;
	}
	
	public Rect getRect(){
		return rectangle;
	}
}
