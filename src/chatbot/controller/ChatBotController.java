package chatbot.controller;
import chatbot.view.ChatotDisplay;
import chatbot.model.Chatbot;
public class ChatBotController
{
	private Chatbot chatbot;
	private ChatotDisplay display;
//	private Chatframe appFrame;
	
	public ChatBotController()
	{
		chatbot = new Chatbot("Noah Uffens");
		display = new ChatotDisplay();
	}
		public void start()
		{
			String response = display.collectResponse("What do you want to talk about?");
			
			while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
			{
				response = popupChat(response);
				response = display.collectResponse(response);
			}
		}
	
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
//   public static void main(String [] args)
//   {
//	   ChatotDisplay test = new ChatotDisplay();
//	   test.displayText("words go here");
//	   test.displayText("ask a question here");
//	   
//   }
}