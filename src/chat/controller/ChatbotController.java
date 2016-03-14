package chat.controller;

import chat.view.ChatbotView;
import chat.model.ChatbotModel;
import chat.model.CTECTwitter;
import chat.view.ChatbotFrame;

import java.io.*;

import javax.swing.JOptionPane;
/**
 * 3/14/16
 * @author htha9587
 * Controller class for Chatbot Project.
 * Version 1.9
 */
public class ChatbotController 
{
	private ChatbotView display;
	private ChatbotModel harryBot;
	private ChatbotFrame baseFrame;
	private CTECTwitter myTwitter;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String path;
	private String file;

	public ChatbotController()
	{
		display = new ChatbotView();
		String user = display.collectUserText("What is your name?");
		harryBot = new ChatbotModel(user);
		baseFrame = new ChatbotFrame(this);
		myTwitter = new CTECTwitter(this);
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
	
	public String fromChatbottoTwitter(String input)
	{
		String result = "";
		JOptionPane.showMessageDialog(this.baseFrame, "Sending your Tweet! ");
		myTwitter.sendTweet("");
		
		return result;
	}
	
/**
 * Writes text to a file, and reads from said file.
 */
	public void bufferedWriter(String input)
	{
		String fileName = "ChatbotFile.txt "; //Filename.
		
		try 
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Want me to save something of our conversation? ");
			bufferedWriter.write(input);
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
	
	/**
	 * Reads created file when load file button is pressed in the GUI.
	 * @param userText
	 */
	
	public void bufferedReader(String input)
	{
		BufferedReader bufferedReader = null;
		
		try
		{
			File file = new File("ChatbotFile.txt");
			bufferedReader = new BufferedReader(new FileReader(file));
		}
		
		catch (IOException ex)
		
		{
			ex.printStackTrace();
		}
		
		finally
		{
			try 
			{
				bufferedReader.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	
	public void openFile()
	{
		display.displayResponse("Opening our conversation!");
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
