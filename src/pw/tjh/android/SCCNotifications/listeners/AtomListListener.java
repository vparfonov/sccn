package pw.tjh.android.SCCNotifications.listeners;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import pw.tjh.android.SCCNotifications.AtomDetail;
import pw.tjh.android.SCCNotifications.data.AtomItem;

import java.util.List;

/**
 * AtomListListener.java - Listens for clicks on ListView from AtomFeed.java
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class AtomListListener implements AdapterView.OnItemClickListener {

    // List item's reference
    List<AtomItem> listItems;
    // Calling activity reference
    Activity activity;

    public AtomListListener(List<AtomItem> aListItems, Activity anActivity) {
        listItems = aListItems;
        activity  = anActivity;
    }

    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        Intent i = new Intent(activity, AtomDetail.class);
        i.setData(Uri.parse(listItems.get(pos).getContent()));

        i.putExtra("title", listItems.get(pos).getTitle());
        i.putExtra("content", listItems.get(pos).getContent());

        activity.startActivity(i);

    }

}

