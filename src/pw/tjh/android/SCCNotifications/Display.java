package pw.tjh.android.SCCNotifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

/**
 * Display.java - Main Activity & Displays buttons to redirect to correct feed ListView.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class Display extends Activity {

    String title;
    String date;
    String description;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        Button btn1 = (Button) findViewById(R.id.Button1);
        Button btn2 = (Button) findViewById(R.id.Button2);
        Button btn3 = (Button) findViewById(R.id.Button3);
        Button btn4 = (Button) findViewById(R.id.Button4);
        Button btn5 = (Button) findViewById(R.id.Button5);
        Button btn6 = (Button) findViewById(R.id.Button6);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, RssFeed.class);
                String link = getResources().getString(R.string.Link1);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, AtomFeed.class);
                String link = getResources().getString(R.string.Link2);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, AtomFeed.class);
                String link = getResources().getString(R.string.Link3);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, AtomFeed.class);
                String link = getResources().getString(R.string.Link4);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, RssFeed.class);
                String link = getResources().getString(R.string.Link5);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, AtomFeed.class);
                String link = getResources().getString(R.string.Link6);
                i.putExtra("LINK", link);
                startActivity(i);
            }
        });
    }
}


