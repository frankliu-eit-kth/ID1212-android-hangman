package client.activities;

import java.io.Serializable;

import com.example.hangman.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import client.controller.NetworkController;
import client.net.OutputHandler;
import client.util.GameStatus;
/**
 * 
 * @author Liming Liu
 * @role send start message to server for game initialization then send username to update it
 * 		 when sending start this activity will also pass MessageHandler to ServerConnection class for the purpose of handling game message
 * 		 after start game and send user name, this activity will act as the server message handler, its MessageHandler field will staty still to parse server message and start new game activity
 * @robustness: There's not any clear logical mistake, but I don't feel this is the best practice to handle message. A utility class might be more appropriate
 *
 */
public class StartActivity extends Activity {
	
	private MessageHandler msgHandler;
	public final static String EXTRA_GAMESTATUS="com.example.startActivity.GAMESTATUS";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		String username=(String)getIntent().getSerializableExtra(ConnectionActivity.EXTRA_USERNAME);
		msgHandler=new MessageHandler();
		NetworkController.start();
		NetworkController.sendUsername(username, msgHandler);
	}
	//system auto
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}
	//system auto
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
	
	
	private class MessageHandler implements OutputHandler {
		@Override
		public void handleMsg(String msg) {
			// handles "lost connection" message
			if(msg.contains(" ")) {
				AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setMessage(getString(R.string.lost_connection))
                        .setTitle(getString(R.string.no_connection));
                AlertDialog dialog = builder.create();
                dialog.show();
        	}
			//parse to game status and pass the game status to GameActivity to show the user
        	GameStatus gameStatus=new GameStatus(msg);
        	Intent intent=new Intent(StartActivity.this,GameActivity.class);
        	intent.putExtra(EXTRA_GAMESTATUS,(Serializable)gameStatus);
        	startActivity(intent);
		}
	}
}
