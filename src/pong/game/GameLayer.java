package pong.game;

import sheep.game.Layer;
import sheep.graphics.Image;
import sheep.math.BoundingBox;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameLayer extends Layer {

	private Level level;
	private Ball ball;
	private Paddle paddleRight, paddleLeft;
	private Score rightScore, leftScore;
	private boolean playerHasWon, rightPlayerHasWon;
	private int goal = 5;

	public GameLayer() {
		playerHasWon = false;
		rightPlayerHasWon = false;
		paddleRight = new Paddle(TitleScreen.WIDTH-50, TitleScreen.HEIGHT/2);
		paddleLeft = new Paddle(50, TitleScreen.HEIGHT/2);
		rightScore = new Score(true,TitleScreen.WIDTH - 200, 50);
		leftScore = new Score(false, 100, 50);
		ball = Ball.getInstance();
		level = new Level();
	}

	@Override
	public void update(float dt) {
		if (ball.getX() >= paddleRight.getRect().left) {
			if (ball.getY() > paddleRight.getRect().top
					&& ball.getY() < paddleRight.getRect().bottom)
				ball.changeDirX();
			else {
				leftScore.incrementScore();
				if(leftScore.getScore() == this.goal) {
					this.playerHasWon = true;
					this.rightPlayerHasWon = false;
				}
				ball.setMotion(false);
				ball.setPosition(TitleScreen.WIDTH/2, TitleScreen.HEIGHT/2);
			}
		} else if (ball.getX() <= paddleLeft.getRect().right) {
			if (ball.getY() > paddleLeft.getRect().top
					&& ball.getY() < paddleLeft.getRect().bottom)
				ball.changeDirX();
			else {
				rightScore.incrementScore();
				if(rightScore.getScore() == this.goal) {
					this.playerHasWon = true;
					this.rightPlayerHasWon = true;
				}
				ball.setMotion(false);
				ball.setPosition(TitleScreen.WIDTH/2, TitleScreen.HEIGHT/2);
			}
		}
		if (ball.getY() < 15)
			ball.changeDirY();
		else if (ball.getY() > TitleScreen.HEIGHT-15)
			ball.changeDirY();
		ball.update(dt);
	}

	@Override
	public void draw(Canvas canvas, BoundingBox box) {
		if(this.playerHasWon) {
			this.gameEnd(canvas);
			return;
		}
		level.draw(canvas);
		ball.draw(canvas);
		paddleRight.draw(canvas);
		paddleLeft.draw(canvas);
		rightScore.draw(canvas);
		leftScore.draw(canvas);
	}

	public Level getLevel() {
		return this.level;
	}

	public Ball getBall() {
		return this.ball;
	}

	public Paddle getPaddle_touch(int x) {
		if (x > TitleScreen.WIDTH/2)
			return paddleRight;
		else {
			return paddleLeft;
		}
	}

	public Paddle getPaddle_ball() {
		if (ball.getSpeed().getX() < 0)
			return paddleLeft;
		else {
			return paddleRight;
		}
	}
	
	
	public void gameEnd(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(100);
		String string;
		if(this.rightPlayerHasWon) {
			string = "Player 2 wins!";
		} else {
			string = "Player 1 wins!";
		}
		canvas.drawText(string, TitleScreen.WIDTH / 2 - 300, TitleScreen.HEIGHT / 2 + 50, paint);
	}
}
