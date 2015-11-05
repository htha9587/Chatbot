package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Popup display class for GUI Interaction for Chatbot.
 * @author htha9587
 *version 1.3 10/23/15
 */
public class ChatbotView 
{
/**
 * Displays popup for GUI.
 * @param input
 * @return user answer.
 */
	private String windowMessage;
	private ImageIcon chatIcon;
	public ChatbotView()
	
	{
		windowMessage = "This message brught to you by Senior Chatbot.";
		chatIcon = new ImageIcon(getClass().getResource("images/Chatbot90000000000000.jpg"));
	}
	public String collectUserText(String input) 
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, input);
		return answer;
	}
/**
 * Displays string to user with standard popup.
 * @param input The supplied text to be shown.
 */
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
	
}
