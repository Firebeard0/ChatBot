package chatbot.controller;
import chatbot.view.ChatotDisplay;
import chatbot.view.ChatFrame;
import chatbot.model.Chatbot;
public class ChatBotController
{
	private Chatbot chatbot;
	private ChatotDisplay display;
	private ChatFrame appFrame;

	public ChatBotController()
	{
		chatbot = new Chatbot("Noah Uffens");
		display = new ChatotDisplay();
		appFrame = new ChatFrame(this);
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
	
	private void close()
	{
		display.displayText("Later noob");
		System.exit(0);
	}
//   public static void main(String [] args)
//   {
//	   ChatotDisplay test = new ChatotDisplay();
//	   test.displayText("words go here");
//	   test.displayText("ask a question here");
//	   
//   }
}