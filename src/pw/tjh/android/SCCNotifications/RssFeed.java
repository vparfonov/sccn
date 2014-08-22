package pw.tjh.android.SCCNotifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import pw.tjh.android.SCCNotifications.R;
import pw.tjh.android.SCCNotifications.data.RssItem;
import pw.tjh.android.SCCNotifications.listeners.RssListListener;
import pw.tjh.android.SCCNotifications.util.RssReader;

/**
 * RssFeed.java - Displays RssFeeds in a ListView
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class RssFeed extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set view
		setContentView(R.layout.rssfeed);

		try {
            Intent i = getIntent();
            String link = i.getStringExtra("LINK");
			// Create RSS reader
			RssReader rssReader = new RssReader(link);
			// Get a ListView from main view
			ListView items = (ListView) findViewById(R.id.listMainView);
			
			// Create a list adapter
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(RssFeed.this,android.R.layout.simple_list_item_1, rssReader.getItems());
			// Set list adapter for the ListView
			items.setAdapter(adapter);
			
			// Set list view item click listener
            items.setOnItemClickListener(new RssListListener(rssReader.getItems(), RssFeed.this));

		} catch (Exception e) {
			Log.e("RssReader", e.getMessage());
		}
		
	}
}