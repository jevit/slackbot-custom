package slack.main;

import slack.data.EndPoint;
import slack.data.MessageAPI;
import slack.data.MessageSlack;
import slack.service.SendService;

public class Main {

	final static String urlSlackBot_jevit = "https://jevit.slack.com/services/hooks/slackbot?token=7ybXJEi0nqkltx1tZw3qzei3&channel=%23general";
	final static String urlCustomBot_jevit = "https://hooks.slack.com/services/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";
	final static String urlbot_jevit_EmojiList = "https://slack.com/api/emoji.list";
	final static String urlbot_jevit_UsersList = "https://slack.com/api/users.list";

	public static void main(String[] args) {
		MessageSlack messageCustomBot = new MessageSlack(":skull:", "admin", "test", "#random", null);
		MessageSlack messageSlackBot = new MessageSlack("hello");
		MessageAPI messageEmojiList = new MessageAPI("token=xoxb-12797748961-KbQlKUGszP02TFjis3KlycG2");
		EndPoint endpointEmojiList = new EndPoint(urlbot_jevit_EmojiList, "GET");
		EndPoint endpointSlackBot = new EndPoint(urlSlackBot_jevit, "POST");
		EndPoint endpointCustomBot = new EndPoint(urlCustomBot_jevit, "POST");
		SendService sendService = new SendService();
		try {
			// sendService.sendPost(endpointCustomBot, messageCustomBot);
			// sendService.sendPost(endpointSlackBot, messageSlackBot);
			sendService.sendPost(endpointEmojiList, messageEmojiList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
