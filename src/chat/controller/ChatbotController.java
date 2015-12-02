package chat.controller;


import chat.view.ChatbotView;
import chat.model.ChatbotModel;
import chat.view.ChatbotFrame;
/**
 * 11/05/15
 * @author htha9587
 * Controller class for Chatbot Project.
 * Version 1.3
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
		String botResponse = "";
		
		if(harryBot.quitChecker(textFromUser))
		{
			shutDown();
		}
		
		
		botResponse = harryBot.processConversation(textFromUser);
		
		return botResponse;
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
		display.displayResponse("Goodbye " + harryBot.getUserName() + "it has been a pleasure to talk with you.");
		System.exit(0);
	}
	
}
