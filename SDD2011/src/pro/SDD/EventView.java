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

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

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
				eventinfo.add((string = bufferedreader.readLine()));
			}
			bufferedreader.close();

			// EventViewParser eventviewparser = new EventViewParser();
			// eventviewparser.readFromWebsite();
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, events));
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.getevent()));
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.geteventinfo()));

			this.setSelection(0);
			final ListView listview = getListView();
			listview.setTextFilterEnabled(true);
			listview.setOnItemClickListener(new OnItemClickListener() {
				// listen for click, pair event and event info (via parser, not present
				// at the moment
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					try {
						for (int k = 0; k < events.size(); k++) {
							if (((TextView) view).getText() == events.get(k)) {
								AlertDialog.Builder adb = new AlertDialog.Builder(EventView.this);
								adb.setTitle("Event Information");
								adb.setMessage(eventinfo.get(k));
								adb.setPositiveButton("Ok", null);
								adb.show();
							}
						}

					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
		}
	}

	private void refreshEventView() {
		// TODO Auto-generated method stub
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.eventview_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.refresh) {
			refreshEventView();
		}
		// should return true if the menu item is handled
		return true;
	}
	
	public void setDebugTv(TextView debugTv) {
		this.debugTv = debugTv;
	}

	public TextView getDebugTv() {
		return debugTv;
	}

}
