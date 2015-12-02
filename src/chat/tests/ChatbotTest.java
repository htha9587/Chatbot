package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.model.ChatbotModel;

/**
 * Class designed for testing the Chatbot object with JUnit. 
 * We will be developing tests for this as a class.
 * Each additional test will be a version decimal update.
 * @author CodyH
 * @version 1.0
 */
public class ChatbotTest
{
	private ChatbotModel harryBot;
	private String userName;

	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		harryBot = new ChatbotModel(userName);
	}

	@After
	public void tearDown() throws Exception
	{
		userName = null;
		harryBot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("The memesList is not present",harryBot.getMemesList());
		assertNotNull("The politicalTopicsList is not present", harryBot.getPoliticalList());
		assertSame("The username is the same object", userName, harryBot.getUserName());
	}

	@Test
	public void testLengthChecker()
	{
		assertFalse("Correct zero length check",harryBot.lengthChecker(""));
		assertFalse("Correct null check", harryBot.lengthChecker(null));
		assertTrue("Correct length check", harryBot.lengthChecker("       "));
	}

	@Test
	public void testContentChecker()
	{
		String content = "some words";
		harryBot.setContent(content);
		assertFalse("Check blank failed", harryBot.contentChecker(" "));
		assertFalse("Check partial failed", harryBot.contentChecker("words"));
		assertFalse("Check partial failed", harryBot.contentChecker("some"));
		assertTrue("Check match failed", harryBot.contentChecker(content));
		assertTrue("Check match plus failed", harryBot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", harryBot.contentChecker(content + " other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", harryBot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", harryBot.keyboardMashChecker("derf"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("sdf"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("dfg"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("cvb"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker(",./"));
	}

	@Test
	public void testPoliticalTopicChecker()
	{
		assertTrue("Topic check", harryBot.getPoliticalList().contains("Democrat"));
		assertTrue("Topic check", harryBot.getPoliticalList().contains("Republican"));
		assertTrue("Topic check", harryBot.getPoliticalList().contains("11/4/16"));
	}

	@Test
	public void testMemeChecker()
	{
		assertTrue("Topic check", harryBot.getMemesList().contains("doge"));
		assertTrue("Topic check", harryBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testQuitChecker()
	{
		assertFalse("False positive", harryBot.quitChecker("exit"));
		assertTrue("False negative", harryBot.quitChecker("quit"));
	}
	
	@Test
	public void testBuildMemesList()
	{
		assertTrue("Size check", harryBot.getMemesList().size() >= 10);
		assertTrue("Topic check", harryBot.getMemesList().contains("doge"));
		assertTrue("Topic check", harryBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testBuildPoliticalTopicList()
	{
		assertTrue("Size check", harryBot.getPoliticalList().size() >= 10);
		assertTrue("Topic check", harryBot.getPoliticalList().contains("Democrat"));
		assertTrue("Topic check", harryBot.getPoliticalList().contains("Republican"));
		assertTrue("Topic check", harryBot.getPoliticalList().contains("11/4/16"));
	}

	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, harryBot.getUserName());
	}

	@Test
	public void testGetContent()
	{
		String content = "topic area of interest";
		harryBot.setContent(content);
		assertSame("Setters and Getters work", content, harryBot.getContent());
	}

	@Test
	public void testGetMemesList()
	{
		assertNotNull("Getters work again", harryBot.getMemesList());
	}

	@Test
	public void testGetPoliticalTopicList()
	{
		assertNotNull("Getters still work in Java", harryBot.getPoliticalList());
	}
	
	@Test
	public void testSetContent()
	{
		String oldContent = harryBot.getContent();
		String content = "some other content";
		harryBot.setContent(content);
		assertNotSame("Changed values", oldContent, harryBot.getContent());
		assertSame("Setters work", content, harryBot.getContent());
	}

}
