package pw.tjh.android.sccn.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import pw.tjh.android.sccn.RssDetail;
import pw.tjh.android.sccn.data.RssItem;

import java.util.List;

/**
 * RssListListener.java - Listens for ListView clicks and handles them.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class RssListListener implements OnItemClickListener {

	// List item's reference
	final List<RssItem> listItems;
	// Calling activity reference
	final Activity activity;

	public RssListListener(List<RssItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity  = anActivity;
	}

	/**
	 * Start a browser with url from the rss item.
	 */
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

            Intent i = new Intent(activity, RssDetail.class);
            i.putExtra("TITLE", listItems.get(pos).getTitle());
            i.putExtra("DATE", listItems.get(pos).getDate());
            i.putExtra("DESCRIPTION", listItems.get(pos).getDescription());
            activity.startActivity(i);
	}
}
