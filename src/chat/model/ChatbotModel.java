package chat.model;

import java.util.ArrayList;
/**
 * Makes up the framework for the Chatbot program.
 * @author htha9587
 *version 2.0. 3/18/16 Built and called buildMemesList Method, repaired getContent Method.
 *contentChecker complete.
 */

public class ChatbotModel 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalList;
	private String userName;
	private String content;
	private String politicalContent;
	
	
	/**
	 * Creates instances of Chatbot with included username.
	 * @param username is Chatbot username.
	 */
	
	public ChatbotModel(String userName)
	{
		this.userName = userName;
		this.content = "2007 Memes";
		this.politicalList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.politicalContent = "2016 Election";
		
		
		buildMemesList();
		buildPoliticalList();
		
	}
	
	private void buildMemesList()
	{
		this.memesList.add("doge");
		this.memesList.add("Squadala!");
		this.memesList.add("Mah Boi");
		this.memesList.add("cute animals");
		this.memesList.add("M'Lady!");
		this.memesList.add("Deez Nuts!");
		this.memesList.add("Pingas!");
		this.memesList.add("Dolan and Gooby");
		this.memesList.add("Remember remember the 5th of November.");
		this.memesList.add("Spoderman");
		this.memesList.add("Billy Mays");
	}
	/**
	 * A void method that lists Ten memes.
	 */
	private void buildPoliticalList()
	{
		this.politicalList.add("election");
		this.politicalList.add("Democrat");
		this.politicalList.add("Republican");
		this.politicalList.add("liberal");
		this.politicalList.add("conservative");
		this.politicalList.add("Trump");
		this.politicalList.add("Clinton");
		this.politicalList.add("Scott Walker");
		this.politicalList.add("Biden");
		this.politicalList.add("Carson");
		this.politicalList.add("Rubio");
		this.politicalList.add("Fiorina");
		this.politicalList.add("Sanders");
		this.politicalList.add("vote");
		this.politicalList.add("11/4/16");
	}
	

	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
	
	if(currentInput.equals("quit"))
	{
		hasQuit = true;
	}
	return hasQuit;
	}
	
	

	/**
	 * A void method that lists 14 Election Topics.
	 */
	
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
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if topics are matched, if matched, returns true.
	 * @return Whether the string is contained in the ArrayList.
	 */
	
	public boolean politicalCheckerContent(String currentInput)
	{
		boolean hasPolitical = false;
		
		for(String political: politicalList)
		
		if(currentInput.toLowerCase().contains(political.toLowerCase()))
		{
			hasPolitical = true;
		}
		
		return hasPolitical;
	}
	
	/**
	 * Returns username of this chatbot instance.
	 * @return Chatbot instance.
	 */
	
	public boolean memeCheckerContent(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme: memesList)
		
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
		
			{
				hasMeme = true;
			}
				
		return hasMeme;
	}
	
	/**
	 * Returns content area for meme checker instance.
	 * @return meme checker instance.
	 */
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		
		if(currentInput.equals("sdf")  || currentInput.equals(",./") || currentInput.equals("dfg") || currentInput.equals("cvb"))
				{
					isMash = true;
				}
		return isMash;
	}
	
	/**
	 * Chatbot checks for whether or not you are typing Keyboard mashing.
	 */
	
	
	/**
	 * Processes conversation between end user and Chatbot.
	 * @param currentInput
	 * @return
	 */
	public String processConversation(String currentInput)
	{
		String nextTalk = "Anything else that you like?";
		int randomTopic = (int) (Math.random() * 5); // Generates a random number between 0 and 4.
		
		if(memeCheckerContent(currentInput))
		{
			return "The Dankest of Dank.";
		}
		
		if(politicalCheckerContent(currentInput))
		{
			return "That surely is Interesting! ";
		}
		
		if(keyboardMashChecker(currentInput))
		{
			return "Don't mash my keys!";
		}
		
		/**
		 * Switchcase for topics.
		 */
//		switch (randomTopic)
//		
//		{
//		case 0:
//			if(contentChecker(currentInput))
//			{
//				nextTalk = "You talked about my special topic? Neat! What else?";
//			}
//			break;
//		case 1:
//			if(memeCheckerContent(currentInput))
//			{
//				nextTalk = "What was dank is no longer dank. What else?";
//			}
//			break;
//		case 2:
//			if(politicalCheckerContent(currentInput))
//			{
//				nextTalk = "You know your stuff! What next smart cookie?";
//			}
//			break;
//		case 3:
//			// Chooses own test.
//			if(currentInput.length() > 23)
//			{
//				nextTalk = "Length is old school these days, but nevermind.";
//			}
//			break;
//		case 4:
//			//Random topic.
//			nextTalk = "What about the dankest meme?";
//			break;
//			default:
//				//Never will happen.
//				nextTalk = "How did you get here? You're not supposed to know about default!";
//				break;
//		}
		
		return nextTalk;
	}
	
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
		return content;
	}
	
	/**
	 * Getter method for memes list.
	 * @return memelist reference.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * return political list. (getter method)
	 * @return the reference to topic list.
	 */
	
	public ArrayList<String> getPoliticalList()
	{
		return politicalList;
	}
	
	/**
	 * updates content for this chatbot instance.
	 * @param content the updated value for the content area.
	 */
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	
}

