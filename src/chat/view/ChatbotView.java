package chat.view;

import javax.swing.JOptionPane;

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
