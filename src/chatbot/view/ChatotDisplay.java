package chatbot.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class ChatotDisplay
{

	private ImageIcon icon;
	private String windowTitle;
	
    public ChatotDisplay()
    {
    	icon = new ImageIcon(getClass().getResource("images/chuck norris.png"));
    	windowTitle =  "chatbot says";
    }
    
    public void displayText(String message)
    {
    	JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
    	
    }
    
    public String collectResponse(String question)
    {
    	String answer = "";
    	
    	answer += JOptionPane.showInputDialog(null,  question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
    	
    	return answer;
    }
} 
