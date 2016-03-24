package chat.view;

import java.awt.event.*;
import java.awt.font.OpenType;

import javax.swing.*;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import chat.controller.ChatbotController;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 3-24-16
 * 
 * @author htha9587 Version 2.3
 */
public class ChatbotPanel extends JPanel {
	protected static final User List = null;
	private ChatbotController baseController;
	private JButton firstButton;
	private JButton fileSave;
	private JButton fileLoad;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JScrollPane chatPane;
	private JTextArea chatArea;
	private JTextField searchTweetsTextField;
	Twitter twitter;
	private JLabel label;
	private JButton searchTwitterButton;
	private JButton tweetButton;

	public ChatbotPanel(ChatbotController baseController) {
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Chatbot's button.");
		firstTextField = new JTextField("Please type here",20);
		firstTextArea = new JTextArea("I'm an area!");
		fileSave = new JButton("Save to File ");
		baseLayout.putConstraint(SpringLayout.NORTH, fileSave, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileSave, -1, SpringLayout.WEST, firstButton);
		fileLoad = new JButton("Load from File ");
		baseLayout.putConstraint(SpringLayout.NORTH, fileLoad, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileLoad, -1, SpringLayout.WEST, fileSave);
		chatArea = new JTextArea(10,25);
		
		
		setUpChatPane();
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpListenersTwitter();
		setUpListenersTwitterSearch();
		setUpListenersSave();
		setUpListenersLoad();
		
	}

	private void setUpChatPane() 
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setBackground(Color.RED);
		chatPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, chatPane);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	/**
	 * Loads content into panel.
	 */

	private void setUpPanel() {
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(fileSave);
		this.add(fileLoad);
		this.add(chatPane);
		this.add(firstTextField);
		this.add(firstTextArea);
		
		firstTextArea.setEnabled(false);
		firstTextField.setToolTipText("Logic test");
		firstTextArea.setToolTipText("Mr Test");
		firstTextArea.setToolTipText("Mimick Test");
		
		label = new JLabel("Talk to Chatbot");
		baseLayout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -9, SpringLayout.NORTH, chatPane);
		label.setToolTipText("Testing!");
		add(label);
		
		searchTwitterButton = new JButton("Search Twitter");
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitterButton, 6, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, searchTwitterButton, -46, SpringLayout.EAST, this);
		add(searchTwitterButton);
		
		tweetButton = new JButton("Send to Twitter ");
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -6, SpringLayout.WEST, searchTwitterButton);
		add(tweetButton);
		
		
		
		
		
		/**
		 * Sets up Chatbot panel.
		 */
	}

	private void setUpLayout() {
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, -230,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 30, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 150,
				SpringLayout.WEST, this);
		/**
		 * Sets Layout.
		 */
	}

	private void setUpListeners()
	{
			firstButton.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent click)
					{
						
					    String userText = firstTextField.getText(); //Grab user text.   x
						String response = baseController.fromUserToChatbot(userText); //Displays user text.  x
						chatArea.append("\nUser: " + userText); //Gives Text to model for processing.   x
						chatArea.append("\nChatbot: " + response); //Gets and displays answer.          x
						firstTextField.setText(""); //Clears user field.   
					}
					
	}); }
			
	private void setUpListenersTwitter() 
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = firstTextField.getText();
				String response = baseController.fromChatbottoTwitter(userText);
				chatArea.append("\nUser: " + userText);
				chatArea.append("\nUser: " + response);
				firstTextField.setText("");
			}
		
			
		});	
	}
		
	private void setUpListenersTwitterSearch() 
	{
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = firstTextField.getText();
				String response = baseController.chatbotTwitterSearch(userText);
				chatArea.append("\nUser: " + userText);
				chatArea.append("\nUser: " + response);
				firstTextField.setText("");
			}
		});
		
	}
			
				private void setUpListenersSave() 
				{
					fileSave.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
						{
							String userText = chatArea.getText();
							baseController.bufferedWriter(userText);
							chatArea.append("\nUser: " + userText);
							firstTextField.setText("");
						}
					
					
				});
				}
				
					private void setUpListenersLoad() 
					{
						fileLoad.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent click)
							{
								chatArea.setText(baseController.bufferedReader());
							}
						});
						
						
					
				
		
		/**
		 * Checks for mouse  to change window color.	
		 */
			this.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent clicked)
				{
		changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					
				}
				else if (SwingUtilities.isRightMouseButton(clicked))
				{
					
				}
			
			}
			
			public void mouseReleased(MouseEvent released)
			{
	//			changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			public void mouseEntered(MouseEvent entered)
			{
		//		changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
//				changeRandomColor();
			}
		});
	
	/**
	 * Checks for mouse motion to change color.
	 */
			this.addMouseMotionListener(new MouseMotionListener()
			{
				public void mouseMoved(MouseEvent moved)
				{
					
				}
				
				public void mouseDragged(MouseEvent dragged)
				{
					if(dragged.isAltDown())
					{
						
					}
				}
			});
		}
	/**
	 * Changes color randomly when mouse is clicked.
	 */
			private void changeRandomColor()
			{
				int red, green, blue;
				
				red = (int) (Math.random() * 256);
				green = (int) (Math.random() * 256);
				blue = (int) (Math.random() * 256);
				
				this.setBackground(new Color(red, green, blue));
			}
			
			public JTextField getTextField()
			{
				return firstTextField;
			}
		}