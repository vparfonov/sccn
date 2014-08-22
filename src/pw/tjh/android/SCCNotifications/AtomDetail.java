package pw.tjh.android.SCCNotifications;

import pw.tjh.android.SCCNotifications.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * AtomDetail.java - Displays details of atom feed selection
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */
public class AtomDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atomdetail);

        String title 	= (String)getIntent().getExtras().get("title");
        String content 	= (String)getIntent().getExtras().get("content");


        Log.d("DEBUG", "title:\t" + title);

        Log.d("DEBUG", "content:\t\t" + content);


        TextView titleTV = (TextView)findViewById(R.id.detailsTextView);
        WebView webView	 = (WebView)findViewById(R.id.detailsWebView);

        titleTV.setText(title);
        webView.loadData(content, "text/html", "UTF-8");

    }
}
