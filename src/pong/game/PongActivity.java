package pong.game;

import sheep.game.Game;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class PongActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pong);
        Game game = new Game(this,null);
        game.pushState(new TitleScreen());
        setContentView(game);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pong, menu);
        return true;
    }
    
}
