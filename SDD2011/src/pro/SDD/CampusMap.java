/*
 * CampusMap
 *
 * Version 0.6
 *
 */

package pro.SDD;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

/**
 * 
 * @author Paul Ferguson
 * 
 */
public class CampusMap extends MapActivity {
	private MapView mapView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		mapView.setClickable(true);
		Drawable marker = getResources().getDrawable(R.drawable.icon);
		marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
		InterestingLocations funPlaces = new InterestingLocations(marker);
		mapView.getOverlays().add(funPlaces);
		GeoPoint pt = funPlaces.getCenter(); // get the first-ranked point
		mapView.getController().setCenter(pt);
		mapView.getController().setZoom(17);
		mapView.setSatellite(true);
	}

	public void myClickHandler(View target) {
		switch (target.getId()) {
		case R.id.zoomin:
			mapView.getController().zoomIn();
			break;
		case R.id.zoomout:
			mapView.getController().zoomOut();
			break;
		case R.id.sat:
			mapView.setSatellite(true);
			break;
		case R.id.street:
			mapView.setStreetView(true);
			break;
		case R.id.traffic:
			mapView.setTraffic(true);
			break;
		case R.id.normal:
			mapView.setSatellite(false);
			mapView.setStreetView(false);
			mapView.setTraffic(false);
			break;
		}
	}

	protected boolean isLocationDisplayed() {
		return false;
	}

	protected boolean isRouteDisplayed() {
		return false;
	}

	class InterestingLocations extends ItemizedOverlay<OverlayItem> {
		private List<OverlayItem> locations = new ArrayList<OverlayItem>();
		private Drawable marker;

		public InterestingLocations(Drawable marker) {
			super(marker);
			this.marker = marker;
			// a sub menu to select categories of buildings
			// different icons for different types of buildings
			GeoPoint mcs = new GeoPoint((int) (35.654097 * 1000000), (int) (-97.472790 * 1000000));
			GeoPoint coynerhealthscience = new GeoPoint((int) (35.653546 * 1000000), (int) (-97.473530 * 1000000));
			GeoPoint mitchellhall = new GeoPoint((int) (35.655221 * 1000000), (int) (-97.474238 * 1000000));
			GeoPoint hpe = new GeoPoint((int) (35.655228 * 1000000), (int) (-97.473841 * 1000000));
			GeoPoint wantlandhall = new GeoPoint((int) (35.655195 * 1000000), (int) (-97.473477 * 1000000));
			GeoPoint hh = new GeoPoint((int) (35.655047 * 1000000), (int) (-97.472645 * 1000000));
			GeoPoint sciencelab = new GeoPoint((int) (35.654770 * 1000000), (int) (-97.472634 * 1000000));
			GeoPoint music = new GeoPoint((int) (35.655540 * 1000000), (int) (-97.472999 * 1000000));
			GeoPoint ychapel = new GeoPoint((int) (35.655603 * 1000000), (int) (-97.473514 * 1000000));
			GeoPoint hes = new GeoPoint((int) (35.656256 * 1000000), (int) (-97.472211 * 1000000));
			GeoPoint evanshall = new GeoPoint((int) (35.656353 * 1000000), (int) (-97.473825 * 1000000));
			GeoPoint lilliard = new GeoPoint((int) (35.656264 * 1000000), (int) (-97.474313 * 1000000));
			GeoPoint oldnorth = new GeoPoint((int) (35.656831 * 1000000), (int) (-97.473643 * 1000000));
			GeoPoint artanddesign = new GeoPoint((int) (35.656816 * 1000000), (int) (-97.472699 * 1000000));
			GeoPoint meltongallery = new GeoPoint((int) (35.656760 * 1000000), (int) (-97.472275 * 1000000));
			GeoPoint education = new GeoPoint((int) (35.657395 * 1000000), (int) (-97.473637 * 1000000));
			GeoPoint murdaughhall = new GeoPoint((int) (35.657454 * 1000000), (int) (-97.472607 * 1000000));
			GeoPoint policeservices = new GeoPoint((int) (35.657546 * 1000000), (int) (-97.474743 * 1000000));
			GeoPoint housing = new GeoPoint((int) (35.657891 * 1000000), (int) (-97.472779 * 1000000));
			GeoPoint maxchamberslibrary = new GeoPoint((int) (35.658347 * 1000000), (int) (-97.473729 * 1000000));
			GeoPoint westhall = new GeoPoint((int) (35.658530 * 1000000), (int) (-97.472463 * 1000000));
			GeoPoint uc1000 = new GeoPoint((int) (35.659203 * 1000000), (int) (-97.474163 * 1000000));
			GeoPoint uc2000 = new GeoPoint((int) (35.659589 * 1000000), (int) (-97.473230 * 1000000));
			GeoPoint us = new GeoPoint((int) (35.659915 * 1000000), (int) (-97.474281 * 1000000));
			GeoPoint uc3000 = new GeoPoint((int) (35.659528 * 1000000), (int) (-97.472624 * 1000000));
			GeoPoint ucclubhouse = new GeoPoint((int) (35.660279 * 1000000), (int) (-97.472763 * 1000000));
			GeoPoint softballfield = new GeoPoint((int) (35.660937 * 1000000), (int) (-97.472613 * 1000000));
			GeoPoint wellnesscenter = new GeoPoint((int) (35.661343 * 1000000), (int) (-97.474211 * 1000000));
			GeoPoint facilitiesmanagement = new GeoPoint((int) (35.662301 * 1000000), (int) (-97.473412 * 1000000));
			GeoPoint baseballfield = new GeoPoint((int) (35.662620 * 1000000), (int) (-97.472463 * 1000000));
			GeoPoint bronchoappartmentsno4 = new GeoPoint((int) (35.664056 * 1000000), (int) (-97.472747 * 1000000));
			GeoPoint constitutionhall = new GeoPoint((int) (35.654646 * 1000000), (int) (-97.471443 * 1000000));
			GeoPoint nuc = new GeoPoint((int) (35.655565 * 1000000), (int) (-97.471443 * 1000000));
			GeoPoint broncholake = new GeoPoint((int) (35.656139 * 1000000), (int) (-97.471454 * 1000000));
			GeoPoint communicationscenter = new GeoPoint((int) (35.657194 * 1000000), (int) (-97.471545 * 1000000));
			GeoPoint buddyscentralcafeteria = new GeoPoint((int) (35.658430 * 1000000), (int) (-97.471561 * 1000000));
			GeoPoint dalehamiltonfieldhouse = new GeoPoint((int) (35.660267 * 1000000), (int) (-97.471599 * 1000000));
			GeoPoint wantlandstadium = new GeoPoint((int) (35.661578 * 1000000), (int) (-97.470821 * 1000000));
			GeoPoint soccerfield = new GeoPoint((int) (35.659568 * 1000000), (int) (-97.470344 * 1000000));
			GeoPoint tenniscourts = new GeoPoint((int) (35.660196 * 1000000), (int) (-97.470328 * 1000000));
			GeoPoint centralplant = new GeoPoint((int) (35.658203 * 1000000), (int) (-97.469646 * 1000000));
			GeoPoint business = new GeoPoint((int) (35.657475 * 1000000), (int) (-97.470467 * 1000000));
			GeoPoint ctl = new GeoPoint((int) (35.656218 * 1000000), (int) (-97.469577 * 1000000));
			GeoPoint lar = new GeoPoint((int) (35.656581 * 1000000), (int) (-97.468681 * 1000000));
			GeoPoint thatcher = new GeoPoint((int) (35.655928 * 1000000), (int) (-97.470601 * 1000000));
			GeoPoint fsi = new GeoPoint((int) (35.653291 * 1000000), (int) (-97.470381 * 1000000));
			GeoPoint edmondchambercommerce = new GeoPoint((int) (35.653316 * 1000000), (int) (-97.468724 * 1000000));
			GeoPoint edmondfirestation = new GeoPoint((int) (35.653260 * 1000000), (int) (-97.467361 * 1000000));
			GeoPoint centralplaza = new GeoPoint((int) (35.652267 * 1000000), (int) (-97.467624 * 1000000));

			locations.add(new OverlayItem(mcs, "Math And Computer Science", "Math And Computer Science"));
			locations.add(new OverlayItem(coynerhealthscience, "Coyner Health Science", "Coyner Health Science"));
			locations.add(new OverlayItem(mitchellhall, "Mitchell Hall", "Mitchell Hall"));
			locations.add(new OverlayItem(hpe, "Health & Physical Education", "Health & Physical Education"));
			locations.add(new OverlayItem(wantlandhall, "Wantland Hall", "Wantland Hall"));
			locations.add(new OverlayItem(hh, "Howell Hall", "Howell Hall"));
			locations.add(new OverlayItem(sciencelab, "Science Lab", "Science Lab"));
			locations.add(new OverlayItem(music, "Music", "Music"));
			locations.add(new OverlayItem(ychapel, "Y Chapel", "Y Chapel"));
			locations.add(new OverlayItem(hes, "Human Environmental Sciences", "Human Environmental Sciences"));
			locations.add(new OverlayItem(evanshall, "Evans Hall", "Evans Hall"));
			locations.add(new OverlayItem(lilliard, "Lilliard Administration", "Lilliard Administration"));
			locations.add(new OverlayItem(oldnorth, "Old North", "Old North"));
			locations.add(new OverlayItem(artanddesign, "Art & Design", "Art & Design"));
			locations.add(new OverlayItem(meltongallery, "Melton Gallery", "Melton Gallery"));
			locations.add(new OverlayItem(education, "Education", "Education"));
			locations.add(new OverlayItem(murdaughhall, "Murdaugh Hall", "Murdaugh Hall"));
			locations.add(new OverlayItem(policeservices, "Police Services", "Police Services"));
			locations.add(new OverlayItem(housing, "Housing", "Housing"));
			locations.add(new OverlayItem(maxchamberslibrary, "Max Chambers Library", "Max Chambers Library"));
			locations.add(new OverlayItem(westhall, "West Hall", "West Hall"));
			locations.add(new OverlayItem(uc1000, "University Commons 1000", "University Commons 1000"));
			locations.add(new OverlayItem(uc2000, "University Commons 2000", "University Commons 2000"));
			locations.add(new OverlayItem(us, "University Suites", "University Suites"));
			locations.add(new OverlayItem(uc3000, "University Commons 3000", "University Commons 3000"));
			locations.add(new OverlayItem(ucclubhouse, "University Commons Clubhouse", "University Commons Clubhouse"));
			locations.add(new OverlayItem(softballfield, "Softball Field", "Softball Field"));
			locations.add(new OverlayItem(wellnesscenter, "Wellness Center", "Wellness Center"));
			locations.add(new OverlayItem(facilitiesmanagement, "Facilities Management", "Facilities Management"));
			locations.add(new OverlayItem(baseballfield, "Baseball Field", "Baseball Field"));
			locations.add(new OverlayItem(bronchoappartmentsno4, "Broncho Appartments No. 4", "Broncho Appartments No. 4"));
			locations.add(new OverlayItem(constitutionhall, "Constitution Hall", "Constitution Hall"));
			locations.add(new OverlayItem(nuc, "Nigh University Center", "Nigh University Center"));
			locations.add(new OverlayItem(broncholake, "Broncho Lake", "Broncho Lake"));
			locations.add(new OverlayItem(communicationscenter, "Communications Center", "Communications Center"));
			locations.add(new OverlayItem(buddyscentralcafeteria, "Buddy's Central Cafeteria", "Buddy's Central Cafeteria"));
			locations.add(new OverlayItem(dalehamiltonfieldhouse, "Dale Hamilton Field House", "Dale Hamilton Field House"));
			locations.add(new OverlayItem(wantlandstadium, "Wantland Stadium", "Wantland Stadium"));
			locations.add(new OverlayItem(soccerfield, "Soccer Field", "Soccer Field"));
			locations.add(new OverlayItem(tenniscourts, "Tennis Courts", "Tennis Courts"));
			locations.add(new OverlayItem(centralplant, "Central Plant", "Central Plant"));
			locations.add(new OverlayItem(business, "Business", "Business"));
			locations.add(new OverlayItem(ctl, "Center for Transformative Learning", "Center for Transformative Learning"));
			locations.add(new OverlayItem(lar, "Liberal Arts Building", "Liberal Arts Building"));
			locations.add(new OverlayItem(thatcher, "Thatcher Hall", "Thatcher Hall"));
			locations.add(new OverlayItem(fsi, "Forensic Science Institute", "Forensic Science Institute"));
			locations.add(new OverlayItem(edmondchambercommerce, "Edmond Chamber of Commerce", "Edmond Chamber of Commerce"));
			locations.add(new OverlayItem(edmondfirestation, "Edmond Fire Station No 1", "Edmond Fire Station No 1"));
			locations.add(new OverlayItem(centralplaza, "Central Plaza", "Central Plaza"));
			populate();
		}

		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			super.draw(canvas, mapView, shadow);
			boundCenterBottom(marker);
		}

		@Override
		protected OverlayItem createItem(int i) {
			return locations.get(i);
		}

		@Override
		public int size() {
			return locations.size();
		}
	}
}