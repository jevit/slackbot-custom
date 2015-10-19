package slack.main;

import slack.data.EndPoint;
import slack.data.MessageSlack;
import slack.service.SendService;

public class Main {

	static String urlSlackBot_jevit = "https://jevit.slack.com/services/hooks/slackbot?token=7ybXJEi0nqkltx1tZw3qzei3&channel=%23general";
	static String urlCustomBot_jevit = "https://hooks.slack.com/services/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";

	public static void main(String[] args) {
		MessageSlack messageCustomBot = new MessageSlack(":skull:", "admin", "test", "#random", null);
		MessageSlack messageSlackBot = new MessageSlack("hello");
		EndPoint endpointSlackBot = new EndPoint(urlSlackBot_jevit, "POST");
		EndPoint endpointCustomBot = new EndPoint(urlCustomBot_jevit, "POST");
		SendService sendService = new SendService();
		try {
			sendService.sendPost(endpointCustomBot, messageCustomBot);
			// sendService.sendPost(endpointSlackBot, messageSlackBot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
