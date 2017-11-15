package chatbot.view;

import chatbot.controller.ChatBotController;
import javax.swing.JFrame;
import chatbot.view.ChatPanel;
public class ChatFrame extends JFrame
{
	private ChatBotController appController;
	private ChatPanel appPanel;
	public ChatFrame(ChatBotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
{
		
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setTitle("Chatting with chuck");
		this.setResizable(false);
		this.setSize(700, 700);
		this.setVisible(true);
}
}
