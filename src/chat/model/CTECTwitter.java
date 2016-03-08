package chat.model;

import chat.model.*;
import chat.view.*;
import chat.controller.*;
import java.lang.*;
import java.util.*;
import java.io.*;



import twitter4j.*; // Add core jar to buildpath.

/**
 * Version 1.8
 * 3-8-16
 * @author htha9587
 *
 */


public class CTECTwitter 
{
	private Twitter chatbotTwitter;
	private List<Status> statuses;
	private List<String> tweetTexts;
	private ChatbotController baseController;
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statuses = new ArrayList<Status>();
		tweetTexts = new ArrayList<String>();
	}
	
	/**
	 * Send tweet message of a string type.
	 */
	
	
	
	public void sendTweet(String tweet)
	{
		try {
			chatbotTwitter.updateStatus("Harry just tweeted from my Java Chatbot program! #APCSROCKS @CTECNow Thanks @ cscheerleader & @codyhenrichsen!");
		} catch (twitter4j.TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	

	private void updateStatus(String string) 
	{
		
		
	}

	/**
	 * Makes stats about tweets.
	 * @param wordList.
	 * @return String of username.
	 * most common word + how often it's in their tweets.
	 */
	
	public String topResults(List<String> wordList)
	{
		String tweetResults = "";
		return tweetResults;
	}
	
	/**
	 * Loads 200 tweets from Twitter user to a status list and List.
	 * @oaram twitterHandle user being searched.
	 * @throws twitterException.
	 */
	
	public void loadTweets(String twitterHandle) throws TwitterException 
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word: tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
		
		
	}
	
	/**
	 * Removes empty text entries from list.
	 */
	private void removeEmptyText()
	{
		for(int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if (tweetTexts.get(spot).equals(""))
			{
				tweetTexts.remove(spot);
				spot--;
			}
		}
	}
	
	/**
	 * Removes all words in commonWords.txt from parameter wordlist.
	 * @param wordList
	 * @returm list after common words have been removed.
	 */
	
	@SuppressWarnings("unchecked")
	private List<String> removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordstoArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit inner loop.
				}
			
		}
		//In order to keep usernames in wordlist.
		removeTwitterUsernamesFromList(wordList);
	
		return wordList;
		
	}

	/**
	 * Reads commonWords.txt and imports supplied words to a String.
	 * array to be excluded from the results.
	 * @return array of strings to ignore from the results.
	 */
	private String[] importWordstoArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount ++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount ++;
			}
			wordFile.close();
		}
		catch (FileNotFoundException e)
		{
			return new String[0];
		}
		return boringWords;
		}
	
	/**
	 * Removes usernames from list of String objects.
	 */
	private void removeTwitterUsernamesFromList(List<String> wordList)
	{
		for (int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if (wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
					{
					wordList.remove(wordCount);
					wordCount --;
					}
		}
	}
	
	/**
	 * Removes punctuation marks and symbols from supplied strings.
	 * @param currentString
	 */
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	/**
	 * Searches for a marathon near CTEC since 1-1-16.
	 */
	
	public String sampleInvestigaton()
	{
		String results = "";
		
		Query query = new Query("marathon");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results.concat("Count : " + result.getTweets().size());
			for (Status tweet : result.getTweets())
			{
				results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
			}
		}
		
		catch (TwitterException e)
		{
			e.printStackTrace();
		}
		
		return results;
	}
	
	
	}

