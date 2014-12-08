package co.nerdev.android.sccn;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import co.nerdev.android.sccn.data.RssItem;
import co.nerdev.android.sccn.listeners.RssListListener;
import co.nerdev.android.sccn.util.RssReader;
import org.androidannotations.annotations.*;

/**
 * RssFeed.java - Displays RssFeeds in a ListView
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

@EActivity(R.layout.rssfeed)
public class RssFeed extends Activity {

	@Extra("LINK")
	String link;
	@Bean
	RssReader rssReader = new RssReader(link);
	@ViewById(R.id.listMainView)
	ListView items;
	@AfterViews
	void updateList() {
		try {
			ArrayAdapter<RssItem> adapter = null;
			adapter = new ArrayAdapter<RssItem>(RssFeed.this, android.R.layout.simple_list_item_1, rssReader.getItems());
			items.setAdapter(adapter);
			items.setOnItemClickListener(new RssListListener(rssReader.getItems(), RssFeed.this));
		}
		catch (Exception e) {
			Log.d("ERROR", String.valueOf(e));
		}
	}
}