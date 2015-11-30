package chat.view;

import java.awt.event.*;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;


import javax.swing.*;
import chat.controller.ChatbotController;

import java.awt.Color;

/**
 * 11-23-15
 * @author htha9587
 *Version 1.2
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JLabel firstLabel;
	
	public ChatbotPanel (ChatbotController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Chatbot's button.");
		firstTextField = new JTextField("Please type here");
		firstTextArea = new JTextArea("I'm an area!");
		firstLabel = new JLabel("Talk to Chatbot");
		
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
	}
	
	/**
	 * Loads content into panel.
	 */
	
	private void setUpPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(firstTextArea);
		this.add(firstLabel);
		
		
		firstTextField.setToolTipText("Logic test");
		firstTextArea.setToolTipText("Mr Test");
		firstTextArea.setToolTipText("Mimick Test");
		firstLabel.setToolTipText("Testing!");
	}
	
	private void setUpLayout()
	{
		
	}
	
	private void setUpListeners()
	{
			firstButton.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent click)
					{
						firstTextField.setText("Hi ho!");
					}
					
	});
		
			
			this.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent clicked)
				{
//			changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					firstTextField.setText("You clicked left!");
				}
				else if (SwingUtilities.isRightMouseButton(clicked))
				{
					firstTextField.setText("You clicked right!");
				}
			
			}
			
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			public void mouseEntered(MouseEvent entered)
			{
				changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
//				changeRandomColor();
			}
		});
	
	
			this.addMouseMotionListener(new MouseMotionListener()
			{
				public void mouseMoved(MouseEvent moved)
				{
					firstButton.setText("Mouse X: " + moved.getX() + "Mouse Y: " + moved.getY());
					if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() >50 && moved.getY() < 70))
					{
						changeRandomColor();
						
					}
				}
				
				public void mouseDragged(MouseEvent dragged)
				{
					if(dragged.isAltDown())
					{
						firstTextField.setText("You held alt and dragged!");
					}
				}
			});
		}
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