import javax.swing.JApplet;

import chat.view.ChatbotPanel;

import java.awt.*;

public class Run_ChatbotSwing extends JApplet
{
	private ChatbotPanel left;
	private ChatbotPanel right;
	private int num = 0;
	
	public void init() 
	{ // changed from MyFrame
		Container pane = getContentPane();
		}
		public int getNum(){
		return num;
		}
		public void increaseNum(){
		num++;
		left.repaint();
		right.repaint();
		}
		}
	

