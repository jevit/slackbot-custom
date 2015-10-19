package slack.data;

public class EndPoint {
	private String URL;
	private String type;

	public EndPoint() {

	}

	public EndPoint(String URL, String type) {
		this.URL = URL;
		this.type = type;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
