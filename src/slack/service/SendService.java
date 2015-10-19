package slack.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import slack.data.EndPoint;
import slack.data.MessageSlack;

public class SendService {
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 * Requete HTTP POST
	 * 
	 * @throws Exception
	 */
	public void sendPost(EndPoint endpoint, MessageSlack message) throws Exception {
		URL obj = new URL(endpoint.getURL());
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// Request header
		con.setRequestMethod(endpoint.getType());
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoInput(true);
		con.setDoOutput(true);

		OutputStream os = con.getOutputStream();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
		pw.write(message.toString());
		pw.close();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + endpoint.getURL());
		System.out.println("\nSending 'POST' request to payload : " + message.toString());
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

}
