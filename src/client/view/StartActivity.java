package client.view;

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

public class StartActivity extends Activity {
	private ProgressBar mProgress;
	//private NetworkController netController;
	private MessageHandler msgHandler;
	public final static String EXTRA_GAMESTATUS="com.example.startActivity.GAMESTATUS";
	//public final static String EXTRA_CONTROLLER="com.example.startActivity.CONTROLLER";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		
		mProgress = (ProgressBar) findViewById(R.id.progressBar1);
		mProgress.setVisibility(View.VISIBLE);
		
		//netController=(NetworkController)getIntent().getSerializableExtra(ConnectionActivity.EXTRA_CONTROLLER);
		String username=(String)getIntent().getSerializableExtra(ConnectionActivity.EXTRA_USERNAME);
		msgHandler=new MessageHandler();
		NetworkController.start();
		NetworkController.sendUsername(username, msgHandler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
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
	
	
	private class MessageHandler implements OutputHandler {
		@Override
		public void handleMsg(String msg) {
			// TODO Auto-generated method stub
			if(msg.contains(" ")) {
				AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setMessage(getString(R.string.lost_connection))
                        .setTitle(getString(R.string.no_connection));
                AlertDialog dialog = builder.create();
                dialog.show();
        	}
			
        	GameStatus gameStatus=new GameStatus(msg);
        	Intent intent=new Intent(StartActivity.this,GameActivity.class);
        	intent.putExtra(EXTRA_GAMESTATUS,(Serializable)gameStatus);
        	//intent.putExtra(EXTRA_CONTROLLER, (Serializable)netController);
        	startActivity(intent);
    		mProgress.setVisibility(View.GONE);
    		
		}
	}
}
