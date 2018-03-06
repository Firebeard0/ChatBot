package chatbot.controller;

/**
 * 
 * @author Noah Uffens
 * @version 21.11.17 added frame 1.3
 * Date and major revision
 **/
import chatbot.view.*;
import chatbot.model.*;

public class ChatBotController
{
	private Chatbot chatbot;
	private ChatotDisplay display;
	private ChatFrame appFrame;

	private ChatTwitter twitter;
	public ChatBotController()
	{
		chatbot = new Chatbot("Noah Uffens");
		display = new ChatotDisplay();
		appFrame = new ChatFrame(this);
		twitter = new ChatTwitter(this);
	}
		public void start()
		{
			display.displayText("welcome to Chatbot");
//			String response = display.collectResponse("What do you want to talk about?");
			
//			while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//			{
//				response = popupChat(response);
//				response = display.collectResponse(response);
//			}
		}
	
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String interactWithChabot(String input) {
		String chatbotSays = "";
		
		if (chatbot.quitChecker(input))
		{
			close();
		}
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
		
	}
	public String useCheckers(String text)
	{
		String response = "";
		
		if (chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
			
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "This is a good meme";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "You didn't keyboard mash";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response+= "The shopping list is yummy";
		}
		// continue with all checkers
		
		return response;
	}
	private void close()
	{
		display.displayText("Later noob");
		System.exit(0);
	}
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
//   public static void main(String [] args)
//   {
//	   ChatotDisplay test = new ChatotDisplay();
//	   test.displayText("words go here");
//	   test.displayText("ask a question here");
//	   
//   }
	public void handleError(Exception error)
	{
		display.displayText(error.getMessage());
	}
	public void tweet(String text)
	{
		twitter.sendTweet(text);
	}
	
	
	public String search(String text)
	{
		return twitter.getMostCommonWord(text);
	}
}