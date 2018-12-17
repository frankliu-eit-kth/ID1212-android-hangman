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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import client.controller.NetworkController;
import client.net.OutputHandler;

public class GameActivity extends Activity {

    public final static String EXTRA_GAMESTATUS = "com.example.GameActivity.GameStatus";
	NetworkController netController;
	private GameStatus status;
	//private ProgressBar mProgress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		try {
			status=(GameStatus)getIntent().getSerializableExtra(StartActivity.EXTRA_GAMESTATUS);
			//NetworkController netController=(NetworkController)getIntent().getSerializableExtra(StartActivity.EXTRA_CONTROLLER);
			String username=status.getPlayerName();
			TextView tv1=(TextView)findViewById(R.id.userName);
			tv1.setText("username "+username);
			TextView tv2=(TextView)findViewById(R.id.Score);
			tv2.setText("current score " +status.getScore());
			TextView tv3=(TextView)findViewById(R.id.Attempts);
			tv3.setText("remaining attempts "+status.getAttempts());
			TextView tv4=(TextView)findViewById(R.id.Hintword);
			tv4.setText(status.getHintWord());
			
			final Button submitButton=(Button) findViewById(R.id.SubmitLetter);
			final EditText letterInput=(EditText) findViewById(R.id.next_letter_edit_text);
			
			//mProgress = (ProgressBar) findViewById(R.id.progressBar1);
			
			submitButton.setOnClickListener(new View.OnClickListener()
	        {
	            public void onClick(View v)
	            {
	            	String inputString=letterInput.getText().toString();
	                if(inputString!=null&&inputString.length()!=0) {
	                	  //mProgress.setVisibility(View.VISIBLE);
	                      NetworkController.sendInput(inputString);
	                      finish();
	                }    
	            }
	        });
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
