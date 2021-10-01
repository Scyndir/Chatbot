package chatbot.controller;

import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;

public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	private Popup view; 
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("boi");
		this.view = new Popup();
	}
	
	public void start()
	{
		//System.out.println(myChatbot);
		
		view.displayMessage("I need coffee");
		
		String userText = view.askQuestion("What do you want to talk about???");

		//System.out.println("What do you want to talk about???");
		
		//String userText = input.nextLine();
		
		while (!userText.equals("quit"))
		{
			String response = interactWithChatbot(userText);
			//System.out.println(response);
			view.displayMessage(response);
			
			//System.out.println("Keep talking?");
			//userText = input.nextLine();
			
			userText = view.askQuestion("Keep Talking");
		}
		
	}
	
	public String interactWithChatbot(String text)
	{
		String response = "";
		
		response += myChatbot.processText(text);
		
		
		return response;
	}
	
}
