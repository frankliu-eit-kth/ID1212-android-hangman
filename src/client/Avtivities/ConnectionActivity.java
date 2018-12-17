package client.Avtivities;

import java.io.Serializable;

import com.example.hangman.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import client.controller.NetworkController;
/**
 * 
 * @author Liming Liu
 * @role  build connection to server, initialize the static field of serverConnection in NetworkController
 * 			then pass user name to StartActivity for game start-up
 * @debug: the HOST address must be the IPv4 address of local machine, since the emulator will have another internet address
 * @robustness: in Android the better practice to start a thread is by creating AsyncThread or use Handler class
 * 				in this project I suppressed this strict policy for simplicity, but this will cause frame loss since the network listener thread is not running in background
 * 				better to implement the standard way as shown in example-android-work-reverser-client
 *
 */
public class ConnectionActivity extends Activity {
	
	public final static String EXTRA_USERNAME = "com.example.connectionActivity.USERNAME";
	private static final int PORT=8080;
	private static final String HOST="192.168.31.202";
	private ProgressBar mProgress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//system auto
		super.onCreate(savedInstanceState);		 
		setContentView(R.layout.activity_connection);	
		
		try {
			
			 String username=(String)getIntent().getSerializableExtra(MainActivity.EXTRA_MESSAGE);
			 
			 mProgress = (ProgressBar) findViewById(R.id.progressBar1);
			 mProgress.setVisibility(View.VISIBLE);
			 //supress the strict policy on banning thread in UI thread
			 if (android.os.Build.VERSION.SDK_INT > 9) {
				    StrictMode.ThreadPolicy policy =
				       new StrictMode.ThreadPolicy.Builder().permitAll().build();
				    StrictMode.setThreadPolicy(policy);
				}
			 //build connection, initialize static variable serverConnection in network controller class
			 NetworkController.connect(HOST,PORT);
				
			 //pass user name to start activity
			 Intent intent = new Intent(ConnectionActivity.this, StartActivity.class);
			 intent.putExtra(EXTRA_USERNAME, username); 
			 startActivity(intent);
			 mProgress.setVisibility(View.GONE);
			 finish();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			  Log.e("Exception", "Exception: "+Log.getStackTraceString(e));
		}
	}
	//system auto
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.connection, menu);
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
}
