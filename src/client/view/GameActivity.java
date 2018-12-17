package client.view;

import com.example.hangman.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import client.controller.NetworkController;

public class GameActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.GameActivity.MESSAGE";
	static final String HOST="localhost";
	static final int PORT=8080;
	NetworkController netController;
	private GameStatus status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		try {
			status=(GameStatus)getIntent().getSerializableExtra(StartActivity.EXTRA_GAMESTATUS);
			//NetworkController netController=(NetworkController)getIntent().getSerializableExtra(StartActivity.EXTRA_CONTROLLER);
			String username=status.getPlayerName();
			TextView tv=(TextView)findViewById(R.id.userName);
			tv.setText(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    
}
