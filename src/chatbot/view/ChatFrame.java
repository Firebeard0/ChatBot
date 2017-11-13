package chatbot.view;

import chatbot.controller.ChatBotController;
import javax.swing.JFrame;
public class ChatFrame extends JFrame
{
	private ChatBotController appController;
	private ChatPanel appPane;
	public ChatFrame(ChatBotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
{
		this.setContentPane(appPane);
		this.setTitle("Chatting with chuck");
		this.setResizable(false);
		this.setSize(700, 700);
		this.setVisible(true);
}
}
