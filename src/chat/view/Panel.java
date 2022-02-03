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
}
