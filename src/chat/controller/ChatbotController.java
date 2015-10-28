package chat.controller;


import chat.view.ChatbotView;
import chat.model.ChatbotModel;

/**
 * 10/23/15
 * @author htha9587
 * Controller class for Chatbot Project.
 */
public class ChatbotController 
{
	private ChatbotView display;
	private ChatbotModel harryBot;
	
	
	public ChatbotController()
	{
		display = new ChatbotView();
		String user = display.collectUserText("What is your name?");
		harryBot = new ChatbotModel(user);
	}
	
	
	public void start()
	{
		display.displayResponse("Hello " + harryBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = display.collectUserText("What do you like?");
		while(harryBot.lengthChecker(textFromUser))
		{
			
			if(harryBot.contentChecker(textFromUser))
			{
				display.displayResponse("Woah, I didn't know you loved " + harryBot.getContent());
			}
			
			
			textFromUser = display.collectUserText(textFromUser);
		}
	}
	
}
