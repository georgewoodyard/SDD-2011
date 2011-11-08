/*
 * CourseInfo
 *
 * Version 0.8
 *
 */

package pro.SDD;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * @author Billy Welch
 * 
 */
public class CourseInfo extends ListActivity {
	private TextView debugTv;
	ArrayList<String> course = new ArrayList<String>();
	ArrayList<String> courseinfo = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setDebugTv((TextView) this.findViewById(R.id.events));

		try {
	
			CourseInfoParser courseinfoparser = new CourseInfoParser();
			courseinfoparser.readFromWebsite();
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, course));
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, courseinfoparser.getcourse()));
			//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, courseinfoparser.getcourseinfo()));
			this.setSelection(0);
			
			final ListView listview = getListView();
			listview.setTextFilterEnabled(true);

			
			listview.setOnItemClickListener(new OnItemClickListener() {
				// listen for click, pair course and course info (via parser, not present at the moment
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					try {
						for(int k=0;k<course.size();k++){
						if (((TextView) view).getText() == course.get(k)) {
							AlertDialog.Builder adb=new AlertDialog.Builder(CourseInfo.this);
							adb.setTitle("Course Information");
							adb.setMessage(courseinfo.get(k));
							adb.setPositiveButton("Ok", null);
							adb.show();
						} 
				        }
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			});
		} catch (Exception exception) {
		}
	}

	public void setDebugTv(TextView debugTv) {
		this.debugTv = debugTv;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.my_menu, menu);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Sample Context Menu");
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() >= 200) {
			this.appendMenuItemText(item);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.map) {
			appendText("\nCampus Map Service");
		} else if (item.getItemId() == R.id.events) {
			appendText("\nEvent Notifications");
		} else if (item.getItemId() == R.id.courses) {
			appendText("\nCourse Info");
		} else {
			this.appendMenuItemText(item);
		}
		// should return true if the menu item
		// is handled
		return true;
	}

	// Given a string of text append it to the TextView
	private void appendText(String text) {
		debugTv.setText(debugTv.getText() + text);
	}

	// Given a menu item append its title to the TextView
	private void appendMenuItemText(MenuItem menuItem) {
		String title = menuItem.getTitle().toString();
		debugTv.setText(debugTv.getText() + "\n" + title);
	}

	// Empty the TextView of its contents

}
