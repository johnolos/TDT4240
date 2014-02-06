package pong.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Score implements Observer{
	private float x;
	private float y;
	private int score = 0;
	private Paint paint;
	private String player;
	private boolean isRight;
	
	
	public Score(boolean b,float x, float y) {
		if(b) {
			player = "Player 2: ";
		} else {
			player = "Player 1: ";
		}
		paint = new Paint();
		this.x = x;
		this.y = y;
		paint.setTextSize(20);
		paint.setColor(Color.WHITE);
		isRight = b; 
	}
	
	public void draw(Canvas canvas) {
		// True means right
		canvas.drawText(this.player + String.valueOf(score), x, y, this.paint);
	}
	

	public int getScore() {
		return this.score;
	}


	@Override
	public void update(int home, int away) {
		if(this.isRight)
			score = away;
		else
			score = home;
	}

}
