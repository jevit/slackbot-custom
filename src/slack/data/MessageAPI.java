package slack.data;

public class MessageAPI extends Message {
	private String token;

	public MessageAPI() {

	}

	public MessageAPI(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {

		return token;
	}
}
