/*
 * EventView
 * 
 * Version 0.8
 *
 */

package pro.SDD;

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
	int n = 0;
	ArrayList<String> events = new ArrayList<String>();
	ArrayList<String> eventinfo = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setDebugTv((TextView) this.findViewById(R.id.events));
		try {
			EventViewParser eventviewparser = new EventViewParser();
			eventviewparser.readFromWebsite();
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.getevents()));
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, eventviewparser.geteventinfo()));
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
