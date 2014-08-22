package pw.tjh.android.SCCNotifications;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pw.tjh.android.SCCNotifications.R;
import pw.tjh.android.SCCNotifications.data.AtomItem;
import pw.tjh.android.SCCNotifications.listeners.AtomListListener;
import pw.tjh.android.SCCNotifications.util.AtomReader;

/**
 * AtomFeed.java - Displays atom feed in a ListView.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */
public class AtomFeed extends Activity {

    // A reference to the local object
    private AtomFeed local;

    /**
     * This method creates main application view
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.atomfeed);

        // Set reference to this activity
        local = this;

        GetRSSDataTask task = new GetRSSDataTask();

        Intent i = getIntent();
        String link = i.getStringExtra("LINK");

        // Start download RSS task
        task.execute(link);

    }

    private class GetRSSDataTask extends AsyncTask<String, Void, List<AtomItem> > {
        @Override
        protected List<AtomItem> doInBackground(String... urls) {

            try {
                // Create RSS reader
                AtomReader atomReader = new AtomReader(urls[0]);

                // Parse RSS, get items
                return atomReader.getItems();

            } catch (Exception e) {
                Log.e("AtomReader", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<AtomItem> result) {

            // Get a ListView from main view
            ListView items = (ListView) findViewById(R.id.listMainView);

            // Create a list adapter
            ArrayAdapter<AtomItem> adapter = new ArrayAdapter<AtomItem>(local,android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
            items.setAdapter(adapter);

            // Set list view item click listener
            items.setOnItemClickListener(new AtomListListener(result, local));
        }
    }

}

