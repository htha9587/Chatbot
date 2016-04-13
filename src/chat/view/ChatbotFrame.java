package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatbotController;

/**
 * Creates JFrame GUI for Chatbot GUI.
 * Version 2.4
 * @author htha9587
 *3-24-16 Added GUI Reference.
 */



public class ChatbotFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatbotPanel basePanel;
	
	
	public ChatbotFrame(ChatbotController baseController)
	{
		this.baseController = baseController; //Assign data member parameter.
		basePanel = new ChatbotPanel(baseController); // Creates instance with controller reference.
		setUpFrame();
		
	}
	/**
	 * Helper method to setup JFrame and its structures.
	 */
	
	private void setUpFrame()
	{
		this.setContentPane(basePanel); ///Required for GUI Frame.
		this.setResizable(true); //Optional.
		this.setTitle("Chatbot 9000000000"); //Sets title.
		this.setSize(400,400);				//Sets size.
		this.setVisible(true); 				//Last line in method.
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}
}
