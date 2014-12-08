package co.nerdev.android.sccn;

import android.app.Activity;
import android.content.Intent;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.res.StringRes;

/**
 * Display.java - Main Activity & Displays buttons to redirect to correct feed ListView.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

@EActivity(R.layout.main)
public class Display extends Activity {

    @StringRes(R.string.Link1)
    String Link1;
    @StringRes(R.string.Link2)
    String Link2;
    @StringRes(R.string.Link3)
    String Link3;
    @StringRes(R.string.Link4)
    String Link4;
    @StringRes(R.string.Link5)
    String Link5;


    @Click(R.id.Button1)
    void clickButton1() {
        Intent i = new Intent(Display.this, RssFeed.class);
        i.putExtra("LINK", Link1);
        startActivity(i);
    }

    @Click(R.id.Button2)
    void clickButton2() {
        Intent i = new Intent(Display.this, RssFeed.class);
        i.putExtra("LINK", Link2);
        startActivity(i);
    }

    @Click(R.id.Button3)
    void clickButton3() {
        Intent i = new Intent(Display.this, RssFeed.class);
        i.putExtra("LINK", Link3);
        startActivity(i);
    }

    @Click(R.id.Button4)
    void clickButton4() {
        Intent i = new Intent(Display.this, RssFeed.class);
        i.putExtra("LINK", Link4);
        startActivity(i);
    }

    @Click(R.id.Button5)
    void clickButton5() {
        Intent i = new Intent(Display.this, RssFeed.class);
        i.putExtra("LINK", Link5);
        startActivity(i);
    }

}


