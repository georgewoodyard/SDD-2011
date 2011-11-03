/*
 * EventView
 * 
 * Version 0.8
 *
 */

package pro.SDD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * 
 * @author Westley Woodyard
 * 
 */
public class EventView extends ListActivity {
	private TextView debugTv;
	ArrayList<String> events = new ArrayList<String>();
	ArrayList<String> eventinfo = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setDebugTv((TextView) this.findViewById(R.id.events));
		
		try {

			// Create a URL for the desired page
			URL url = new URL("http://sdd2011.phpfogapp.com/events.xml");

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;

			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				events.add(string);
				//eventinfo.add((string = bufferedreader.readLine()));
			}
			bufferedreader.close();
			
			//EventViewParser eventviewparser = new EventViewParser();
			//eventviewparser.readFromWebsite();
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, events));
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.getevent()));
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.geteventinfo()));
		} catch (Exception e) {
		}
	}

	public void setDebugTv(TextView debugTv) {
		this.debugTv = debugTv;
	}

	public TextView getDebugTv() {
		return debugTv;
	}

}
