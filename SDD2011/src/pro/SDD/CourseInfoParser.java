/*
 /*
 * CourseInfoParser
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
 * @author Billy Welch
 * 
 */
public class CourseInfoParser {
	ArrayList<String> course = new ArrayList<String>();
	ArrayList<String> courseinfo = new ArrayList<String>();
	ArrayList<String> coursetime = new ArrayList<String>();

	public void readFromWebsite() {
		// read from site
		try {
			// Create a URL for the desired page
			URL url = new URL("http://sdd2011.phpfogapp.com/courseinfo.xml");

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;
			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				if(string.indexOf("<title>")>0)
				{
					string = string.replace("<title>","");
					string = string.replace("</title>", "");
					string = string.trim();
					course.add(string);
				}
				if(string.indexOf("<prefix>")>0)
				{
					string = string.replace("<prefix>","");
					string = string.replace("</prefix>","");
					string = string.trim();
					
					courseinfo.add(string);
					
				}
			}

			bufferedreader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	public ArrayList<String> getcourse() {
		return course;
	}

	public ArrayList<String> getcourseinfo() {
		return courseinfo;
	}
}
