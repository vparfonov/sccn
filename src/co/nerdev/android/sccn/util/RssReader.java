package co.nerdev.android.sccn.util;

import co.nerdev.android.sccn.data.RssItem;
import org.androidannotations.annotations.EBean;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * RssReader.java - Reads the rss feed.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */
@EBean
public class RssReader {

	final private String rssUrl;

	/**
	 * Constructor
	 * 
	 * @param rssUrl - Url of Rss Feed
	 */
	public RssReader(String rssUrl) { this.rssUrl = rssUrl; }

	/**
	 * Get RSS items.
	 * 
	 * @return
	 */
	public List<RssItem> getItems() throws Exception {
        // At first we need to get an SAX Parser Factory object
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // Using factory we create a new SAX Parser instance
        SAXParser saxParser = factory.newSAXParser();
        // We need the SAX parser handler object
        RssParseHandler handler = new RssParseHandler();
        // We call the method parsing our RSS Feed
        saxParser.parse(rssUrl, handler);
        // The result of the parsing process is being stored in the handler object
        return handler.getItems();
	}
}
