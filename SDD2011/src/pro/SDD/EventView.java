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
import android.content.Intent;
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
			String compound = "";

			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				
				if(string.indexOf("<eventtitle>")>-1)
				{
					string = string.replace("<eventtitle>","");
					string = string.replace("</eventtitle>", "");
					string = string.trim();
					events.add(string);
				}
				if(string.indexOf("<eventinfo>")>-1)
				{
					string = string.replace("<eventinfo>","");
					
					//if </eventinfo> tag is missing, this indicates a new line
					//is present. Split into either compound or keep string.
					if(!(string.indexOf("</eventinfo>")>-1))
					{
					compound= string; //copy string into copound string
					while(!(compound.indexOf("</eventinfo>")>-1)) //check string
						{
						compound= compound+bufferedreader.readLine();
						}
					compound = compound.replace("</eventinfo>","");
					compound = compound.trim();
					eventinfo.add(compound);
					compound=""; //reset compound
					}
					else
					{
					string = string.replace("</eventinfo>","");
					string = string.trim();
					eventinfo.add(string);
					}
				}
				//throw away <event> and </event> tags
				string = string.replace("<event>","");
				string = string.replace("</event>","");
				string = string.trim();
			}
			bufferedreader.close();
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, events));
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
		Intent intent = getIntent();
		finish();
		startActivity(intent);
		
		AlertDialog.Builder adb = new AlertDialog.Builder(EventView.this);
		adb.setTitle("Refresh Information");
		adb.setMessage("This page is being refreshed");
		adb.setPositiveButton("Alright!", null);
		adb.show();

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
