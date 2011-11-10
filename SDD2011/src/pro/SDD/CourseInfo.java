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
		setDebugTv((TextView) this.findViewById(R.id.courses));

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

	public TextView getDebugTv() {
		return debugTv;
	}

}
