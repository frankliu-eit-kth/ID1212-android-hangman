package client.view;

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

public class ConnectionActivity extends Activity {
	public final static String EXTRA_CONTROLLER = "com.example.connectionActivity.CONTROLLERE";
	public final static String EXTRA_USERNAME = "com.example.connectionActivity.USERNAME";
	private ProgressBar mProgress;
	//private NetworkController netController;
	private static final int PORT=8080;
	private static final String HOST="localhost";
	//private static final OutputHandler messageListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 System.out.println("1");
		setContentView(R.layout.activity_connection);
		 System.out.println("11");
		
		
		 try {
			 String username=(String)getIntent().getSerializableExtra(MainActivity.EXTRA_MESSAGE);
			 
			 mProgress = (ProgressBar) findViewById(R.id.progressBar1);
			 
			 mProgress.setVisibility(View.VISIBLE);
			 
			 if (android.os.Build.VERSION.SDK_INT > 9) {
				    StrictMode.ThreadPolicy policy =
				       new StrictMode.ThreadPolicy.Builder().permitAll().build();
				    StrictMode.setThreadPolicy(policy);
				}
			//netController=new NetworkController();
			try {
					NetworkController.connect("192.168.31.202",8080);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.e("Exception", "Exception: "+Log.getStackTraceString(e));
				}
			
			 Intent intent = new Intent(ConnectionActivity.this, StartActivity.class);
			 
			 //intent.putExtra(EXTRA_CONTROLLER, (Serializable)netController);
			 
			 intent.putExtra(EXTRA_USERNAME, username);
			 
			 startActivity(intent);
			
			 mProgress.setVisibility(View.GONE);
			 
			 finish();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			  Log.e("Exception", "Exception: "+Log.getStackTraceString(e));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.connection, menu);
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
