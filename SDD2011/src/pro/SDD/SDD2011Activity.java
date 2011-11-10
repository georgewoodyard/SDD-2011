/*
 * SDD2011Activity
 *
 */

package pro.SDD;

import pro.SDD.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 
 * @author Paul Ferguson
 * 
 * @version 1.0
 * 
 */
public class SDD2011Activity extends ListActivity {
	private TextView debugTv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] string = new String[] { "Campus Map", "Event Notifications",
				"Course Info", };
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, string));

		ListView listview = getListView();
		listview.setTextFilterEnabled(true);

		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				try {
					if (((TextView) view).getText() == "Campus Map") {
						startActivity(new Intent(SDD2011Activity.this, CampusMap.class));
					} else if (((TextView) view).getText() == "Event Notifications") {
						startActivity(new Intent(SDD2011Activity.this, EventView.class));
					} else if (((TextView) view).getText() == "Course Info") {
						startActivity(new Intent(SDD2011Activity.this, CourseInfo.class));
					} else
						finish();

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
	}
}