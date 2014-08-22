package pw.tjh.android.SCCNotifications.util;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

import pw.tjh.android.SCCNotifications.data.AtomItem;

/**
 * AtomReader.java -
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */
public class AtomReader {

    private String rssUrl;

    /**
     * Constructor
     *
     * @param rssUrl
     */
    public AtomReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    /**
     * Get RSS items.
     *
     * @return
     */
    public List<AtomItem> getItems() throws Exception {
        // SAX parse RSS data
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser saxParser = factory.newSAXParser();

        AtomParseHandler handler = new AtomParseHandler();

        InputSource is = new InputSource(rssUrl);
        is.setEncoding("UTF-8");

        saxParser.parse(is, handler);

        return handler.getItems();
    }
}

