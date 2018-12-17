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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import client.controller.NetworkController;
import client.net.OutputHandler;

public class MainActivity extends Activity {
	
/**
 * @role: the default entry point of the application
 * 		  provides a UI which reads username and pass it to ConnectionActivity through Intent
 * 		  does not involve any network operations or logic operations
 * 
 * @robustness: very robust
 */
	public final static String EXTRA_MESSAGE = "com.example.MainActivity.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/**
		 * default setup
		 */
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * UI setup
		 */
		setupActivity();
		
	}

	
	private void setupActivity() {
		/**
		 * get "start" buttion
		 */
		final Button startButton=(Button) findViewById(R.id.start_button);
		/**
		 * get "username" editable text field
		 */
		final EditText nameInput=(EditText) findViewById(R.id.enter_name_textview);
		/**
		 * 
		 * define the function of buttion
		 *  when click, pass username to start Activity then finish
		 */
		startButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
            	String username=nameInput.getText().toString();
                if(username!=null&&username.length()!=0) {
                	 
                      Intent intent = new Intent(MainActivity.this, ConnectionActivity.class);
                      intent.putExtra(EXTRA_MESSAGE, username);
                      startActivity(intent);
                      finish();
                }    
            }
        });
	}
	
	
	//system auto-generate
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//system auto-generate
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
