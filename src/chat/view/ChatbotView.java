package chat.view;

import javax.swing.JOptionPane;
/**
 * Popup display class for GUI Interaction for Chatbot.
 * @author htha9587
 *version 1.3 10/23/15
 */
public class ChatbotView {

	public String collectUserText(String input) 
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, input);
		return answer;
	}

	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
	
}
