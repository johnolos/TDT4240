package pong.game;

import sheep.game.Sprite;
import sheep.graphics.Image;
import android.graphics.Canvas;

public class Ball extends Sprite{
	
	private float velocityX = -600.0f;
	private float velocityY = 150.0f;
	private boolean inMotion;
	private static Ball instance;
	
	public Ball(Image image){
		super(image);
		setPosition(TitleScreen.WIDTH/2, TitleScreen.HEIGHT/2);
		inMotion = false;
	}
	
	public static synchronized Ball getInstance() {
		return instance;
	}
	
	public void draw(Canvas can){
		super.draw(can);
	}
	
	public void changeDirX(){
		velocityX = -velocityX + 10.0f;
	}
	
	public void changeDirY(){
		velocityY = -velocityY;
	}
	
	public void update(float dt){
		super.update(dt);
		if(inMotion){
			float x = getX();
			float y = getY();
			float dx = dt * velocityX;
			float dy = dt * velocityY;
			setPosition(x-dx, y-dy);
		}
	}
	
	public void setMotion(boolean b){
		inMotion = b;
	}
}
