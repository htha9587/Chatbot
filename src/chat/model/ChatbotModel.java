package chat.model;

import java.util.ArrayList;
/**
 * Makes up the framework for the Chatbot program.
 * @author htha9587
 *version 1.3. 10/23/15
 */

public class ChatbotModel 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates instances of Chatbot with included username.
	 * @param username is Chatbot username.
	 */
	
	public ChatbotModel(String userName)
	{
		this.userName = userName;
		this.content = "";
		this.politicalTopicList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
	}
	
	private void buildMemesList()
	{
	
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	/**
	 * Checks string length, returns false if string is empty or null.
	 * @return Whether it matches the content area.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
	if(currentInput != null)
	{
		if(currentInput.length() >= 1)
		{
			hasLength = true;
		}
	}
	
	return hasLength;
	}
	
	
	public boolean contentChecker(String currentInput)
	{
		return false;
	}
	
	/**
	 * Checks if topics are matched, if matched, returns true.
	 * @return Whether the string is contained in the ArrayList.
	 */
	
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	/**
	 * Returns username of this chatbot instance.
	 * @return Chatbot instance.
	 */
	
	public boolean memeCheckerContent(String currentInput)
	{
		return false;
	}
	
	/**
	 * Returns content area for meme checker instance.
	 * @return meme checker instance.
	 */
	
	public String getUserName()
	{
		return userName;
	}
	
	/** 
	 * Returns content area for this chatbot instance.
	 * @return username instance.
	 */
	
	public String getContent()
	{
		return null;
	}
	
	/**
	 * Getter method for memes list.
	 * @return memelist reference.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * return political list. (getter method)
	 * @return the reference to topic list.
	 */
	
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * updates content for this chatbot instance.
	 * @param content the updated value for the content area.
	 */
	
	public void setContent(String content)
	{
		
	}
}
