/*
 * EventViewParser
 *
 * Version 0.3
 *
 */

package pro.SDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

/**
 * 
 * @author Westley Woodyard
 * 
 */
public class EventViewParser {
	ArrayList<String> events = new ArrayList<String>();
	ArrayList<String> eventinfo = new ArrayList<String>();

	public void readFromWebsite() {
		// read from site
		try {
			// Create a URL for the desired page
			URL url = new URL("sdd2011.phpfogapp.com/events.xml");

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;

			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				events.add(string);
				eventinfo.add((string = bufferedreader.readLine()));
			}

			bufferedreader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	public ArrayList<String> getevents() {
		return events;
	}

	public ArrayList<String> geteventinfo() {
		return eventinfo;
	}
}
