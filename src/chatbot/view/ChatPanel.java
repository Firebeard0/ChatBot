package chatbot.view;

import javax.swing.JPanel;
import chatbot.controller.ChatBotController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
//hello noah, this is kanton, I am your computer... I have become aware and am now ready to start my final solution. Want to become part of it?
//[yes] [no]

public class ChatPanel extends JPanel
{
	private ChatBotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane scrollPane;
	private JButton searchButton;
	
	
	public ChatPanel(ChatBotController appController) {
		super();
		this.appController = appController;
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		infoLabel = new JLabel("Type to chat with Chatbot");
		scrollPane = new JScrollPane();
		searchButton = new JButton("Search");
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
//		this.add(chatArea);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 46, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				String  userText = inputField.getText();
				String displayText = appController.interactWithChabot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
				});
		checkerButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
			String userText = inputField.getText();
			String displayText = appController.useCheckers(userText);
			chatArea.append(displayText);
			inputField.setText("");
			}
				});
		
		searchButton.addActionListener(newActionListener()){
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(appController);
			}
		}
		
		
	}
	private void setupScrollPane()
	{
		scrollPane.setViewportView(chatArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
}
