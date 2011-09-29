package pro.SDD;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SDD2011Activity extends Activity {
		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			debugTv = (TextView) this.findViewById(R.id.tv);
			this.registerForContextMenu(debugTv);
		}

		public boolean onCreateOptionsMenu(Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.my_menu, menu);
			return true;
		}

		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
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

		private TextView debugTv;
	}