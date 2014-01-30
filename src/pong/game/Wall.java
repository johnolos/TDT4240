package pong.game;

import sheep.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Wall{
	
	private Rect rectangle;
	private Color color;
	
	public Wall(int left, int top, int right, int bottom, Color color){
		rectangle = new Rect(left, top, right, bottom);
		this.color = color;
	}
	
	public void draw(Canvas can){
		can.drawRect(rectangle, color);
	}
}
