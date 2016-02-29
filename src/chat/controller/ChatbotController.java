package chat.controller;

import chat.view.ChatbotView;
import chat.model.ChatbotModel;
import chat.view.ChatbotFrame;
import java.io.*;
/**
 * 2/29/1
 * @author htha9587
 * Controller class for Chatbot Project.
 * Version 1.6
 */
public class ChatbotController 
{
	private ChatbotView display;
	private ChatbotModel harryBot;
	private ChatbotFrame baseFrame;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private String fileName;

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
	
	
/**
 * Writes text to a file, and reads from said file.
 */
	public void FileWriter()
	{
		String fileName = "ChatbotFile.txt "; //Filename.
		
		try 
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Want me to save something of our conversation? ");
			bufferedWriter.newLine();
			bufferedWriter.write("Watch as I save to a file! ");
			
			//Closes file.
			bufferedWriter.close();
			
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
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
