package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.controller.ChatbotController;
import chat.view.*;




public class ChatControllerTest
{
	private ChatbotController testController;

	@Before
	public void setUp() throws Exception
	{
		testController = new ChatbotController();
	}

	@After
	public void tearDown() throws Exception
	{
		testController = null;
	}

	@Test
	public void testChatController()
	{
		assertNotNull("Data member not initialized", testController.getChatbotModel());
		assertNotNull("Data member not initialized", testController.getChatbotView());
		assertTrue("Wrong display type", (testController.getChatbotView() instanceof ChatbotView));
		assertTrue("Wrong Frame type",(testController.getBaseFrame() instanceof ChatbotFrame));
		assertSame("wrong controller", testController, testController.getBaseFrame().getBaseController());
	}
	
	
	

}
