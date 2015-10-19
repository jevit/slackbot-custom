package slack.data;

import java.util.StringJoiner;

public class MessageSlack {

	private String emoji;

	private String name;
	// pour slackbot
	private String text;

	private String channel;

	// Pour custom bot
	private String payload;

	private final String CHAN_GENERAL = "#general";
	private final String CHAN_RANDOM = "#random";

	public MessageSlack() {
		super();
	}

	public MessageSlack(String payload) {
		super();
		this.payload = payload;
	}

	public MessageSlack(String emoji, String name, String text, String channel, String payload) {
		super();
		this.emoji = emoji;
		this.name = name;
		this.text = text;
		this.channel = channel;
		this.payload = payload;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		if (getPayload() != null) {
			return payload;
		} else {
			StringJoiner strJoin = new StringJoiner(",");
			if (this.getText() != null) {
				String text = "\"text\": \"" + this.getText() + "\"";
				strJoin.add(text);
			}
			if (this.getEmoji() != null) {
				String emoji = "\"icon_emoji\": \"" + this.getEmoji() + "\"";
				strJoin.add(emoji);
			}
			if (this.getEmoji() != null) {
				String name = "\"username\": \"" + this.getName() + "\"";
				strJoin.add(name);
			}
			if (this.getChannel() != null) {
				String channel = "\"channel\": \"" + this.getChannel() + "\"";
				strJoin.add(channel);
			}
			return "{" + strJoin.toString() + "}";
		}
	}

}
