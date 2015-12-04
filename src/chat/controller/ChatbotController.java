package chat.controller;


import chat.view.ChatbotView;
import chat.model.ChatbotModel;
import chat.view.ChatbotFrame;
/**
 * 12/04/15
 * @author htha9587
 * Controller class for Chatbot Project.
 * Version 1.5
 */
public class ChatbotController 
{
	private ChatbotView display;
	
	private ChatbotModel harryBot;
	
	private ChatbotFrame baseFrame;
	
	


	public ChatbotController()
	{
		display = new ChatbotView();
		String user = display.collectUserText("What is your name?");
		harryBot = new ChatbotModel(user);
		baseFrame = new ChatbotFrame(this);
	}
	
	
	public void start()
	{
		display.displayResponse("Hello " + harryBot.getUserName());
		//chat();
	}
	/**
	 * Starts the program.
	 */
			
	
	private void chat()
	{
		String textFromUser = display.collectUserText("What do you like?");
		while(harryBot.lengthChecker(textFromUser))
		{
		
			textFromUser = display.collectUserText(textFromUser);
			textFromUser = harryBot.processConversation(textFromUser);
			
		}
		
}
	
	
	public String fromUserToChatbot(String textFromUser)
	{
		String botResponse = "What do you like?";
		
		
		if(harryBot.quitChecker(textFromUser))
		{
			shutDown();
		}
		
		botResponse = harryBot.processConversation(textFromUser);
		
		return botResponse;
		
	/**
	 * 	Gets data from user to Chatbot.
	 */
		
		
	}
	
	
	
	public ChatbotView getChatbotView() 
	{
		return display;
	}


	public ChatbotModel getChatbotModel() 
	{
		return harryBot;
	}
	
	public ChatbotFrame getBaseFrame() 
	{
		return baseFrame;
	}
	
	private void shutDown()
	{
		display.displayResponse("Goodbye " + harryBot.getUserName() + " it has been a pleasure to talk with you.");
		System.exit(0);
	}
	/**
	 * Exits the program.
	 */
}
