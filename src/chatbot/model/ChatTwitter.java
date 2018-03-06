package chatbot.model;
import chatbot.controller.*;
import twitter4j.*;
import java.util.*;
import java.text.*;


public class ChatTwitter
{
	private ChatBotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private Long totalWordCount;


public ChatTwitter(ChatBotController appController){
	this.appController = appController;
	this.chatbotTwitter = TwitterFactory.getSingleton();
	this.searchedTweets = new ArrayList<Status>();
	this.tweetedWords = new ArrayList<String>();
	this.totalWordCount = 0;
}
	
public void sendTweet(String textToTweet) {
	try {
		chatbotTwitter.updateStatus(textToTweet + "@ChatbotCTEC");
	} catch(TwitterException tweetError)
	{
		appController.handleError(tweetError);
	}catch(Exception otherError)
	{
		appController.handleError(otherError);
	}	
}
public String getMostCommonWord(String username) {
	String mostCommon = "";
	collectTweets(username);
	turnStatusesToWords();
	String [] boring = createIgnoredWordArray();
	return mostCommon;
}
private void collectTweets(String username)
{
	searchedTweets.clear();
	tweetedWords.clear();
	
	Paging statusPage = new Paging(1, 100);
	int page = 1;
	long lastID = Long.MAX_VALUE;
	
	while (page <= 10)
	{
		statusPage.setPage(page);
		try
		{
			ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
		}
	}
}
private void turnStatusesToWords()
{
	for(Status currentStatus : searchedTweets)
	{
		String tweetText = currentStatus.getText();
		String [] tweetWords = tweetText.split(" ");
		for (int i = 0; i < tweetWords.length; i++)
		{
			tweetedWords.add(removePunctuation(tweetWords[index]).trim());
		}
	}
}

private String removePunctuation (String currentString)
{
	String punctuation = ".,!:;\"() {}^[]<>-";
	
	String scrubbedString = "";
	for(int i = 0; i < currentString.length(); i++)
	{
		
		if (punctuation.indexOf(currentString.charAt(i)) == -1)
		{
			scrubbedString += currentString.charAt(i);
		}
	}
	return scrubbedString;
}

private String [] createIgnoredWordArray()
{
	String [] boringWords;
	String fileText = IOController.loadFromFile(appController, "commonWords.txt");
	int wordCount = 0;
	
	Scanner wordScanner = new Scanner(fileText);
	
	while(wordSscanner.hasNextLine())
	{
		wordScanner.nextLine();
		wordCount++;
	}
	
	boringWords = new String [wordCount];
	wordScanner.close();
	
	wordScannner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
	for(int i = 0; i < boringWords.length; i++;)
	{
		boringWords[i] = wordScanner.nextLine();
	}
	
	wordScanner.close();
	return boringWords;
	}
}
