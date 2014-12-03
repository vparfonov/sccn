package co.nerdev.android.sccn.util;

import co.nerdev.android.sccn.data.RssItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * RssParseHandler.java - Tells RssReader how to handle the tags in the rss feed.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class RssParseHandler extends DefaultHandler {

	private final List<RssItem> rssItems;
	
	// Used to reference item while parsing
	private RssItem currentItem;
	
	// Parsing title indicator
	private boolean parsingTitle;
	// Parsing link indicator
	private boolean parsingLink;
    // Parsing date indicator
    private boolean parsingDate;
    // Parsing description indicator
    private boolean parsingDescription;
	
	public RssParseHandler() {
		rssItems = new ArrayList<RssItem>();
	}
	
	public List<RssItem> getItems() {
		return rssItems;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("item".equals(qName)) {
			currentItem = new RssItem();
		} else if ("title".equals(qName)) {
			parsingTitle = true;
		} else if ("link".equals(qName)) {
			parsingLink = true;
		} else if ("date".equals(qName)) {
            parsingDate = true;
        } else if ("description".equals(qName)) {
            parsingDescription = true;
        }
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
        if (parsingTitle) {
            if (currentItem != null)
                currentItem.setTitle(new String(ch, start, length));
        } else if (parsingLink) {
            if (currentItem != null) {
                currentItem.setLink(new String(ch, start, length));
                parsingLink = false;
            }
        } else if (parsingDate) {
            if (currentItem != null) {
                currentItem.setDate(new String(ch, start, length));
                parsingDate = false;
            }
        } else if (parsingDescription) {
            if (currentItem != null) {
                currentItem.setDescription(new String(ch, start, length));
                parsingDescription = false;
            }
        }
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("item".equals(qName)) {
			rssItems.add(currentItem);
			currentItem = null;
		} else if ("title".equals(qName)) {
			parsingTitle = false;
		} else if ("link".equals(qName)) {
			parsingLink = false;
		} else if ("date".equals(qName)) {
            parsingDate = false;
        } else if ("description".equals(qName)) {
            parsingDescription = false;
        }
	}
}
