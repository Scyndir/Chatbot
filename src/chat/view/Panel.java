package chat.view;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import javax.swing.JPanel;
import chat.controller.Controller;

public class Panel extends JPanel
{
	private Controller app;
	
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private SpringLayout layout;
	
	private JTextArea chatArea;
	private JTextField chatField;
	
	private JButton chatButton;
	private JButton dateButton;
	private JButton timeButton;
	private JButton questionButton;
	private JButton politeButton;
	private JButton politicsButton;
	private JButton randomChatButton;
	
	private JButton saveButton;
	private JButton loadButton;
	
	public ChatPanel(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout());
		
		
		this.chatButtonPanel = new JPanel(new GridLayout(1, 0));
		this.ioPanel = new JPanel(new GridLayout(1, 0));
		
		this.chatArea = new JTextArea(20, 40);
		this.chatField = new JTextField(50);
		
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		
	}
	private void setupListeners()
	{
		
	}
	private void setupLayout()
	{
		
	}
	
}
