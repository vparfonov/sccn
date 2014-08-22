package pw.tjh.android.SCCNotifications.data;

/**
 * RssItem.java - Holds data from the rss feed as string variables.
 * @author Tyler Holmgren
 * TylerHolmgren@TJH.PW
 */

public class RssItem {
	
	// item title
	private String title;
	// item link
	private String link;
    // item date
    private String date;
    // item description
    private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    };

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return title;
	}	
}
