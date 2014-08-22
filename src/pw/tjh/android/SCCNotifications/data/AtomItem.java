package pw.tjh.android.SCCNotifications.data;

import java.util.regex.Pattern;

/**
 * AtomItem.java - Holds atom feed data.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */
public class AtomItem {

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    	title = title.replaceAll(Pattern.quote("&amp;"), "&");
    	title = title.replaceAll(Pattern.quote("&amp"), "&");
        title = title.replaceAll(Pattern.quote("&quot;"), "\"");
        title = title.replaceAll(Pattern.quote("&quot"), "\"");
        title = title.replaceAll(Pattern.quote("&#39;"), "'");
        title = title.replaceAll(Pattern.quote("&#39"), "'");
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return title;
    }
}
