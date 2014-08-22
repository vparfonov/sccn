package pw.tjh.android.SCCNotifications;

import pw.tjh.android.SCCNotifications.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * RssDetail.java - Displays title, date, and description of a single entry from an rss feed.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class RssDetail extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rssdetail);

        TextView tvTitle = (TextView) findViewById(R.id.RssTitle);
        TextView tvDate = (TextView) findViewById(R.id.RssDate);
        TextView tvDescription = (TextView) findViewById(R.id.RssDetail);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        String date = bundle.getString("DATE");
        String description = bundle.getString("DESCRIPTION");

        tvTitle.setText(title);
        tvDate.setText(date);
        tvDescription.setText(description);
    }
}
