package chatbot.controller;

import java.util.Scanner;
import chat.model.Chatbot;

public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("boi");
	}
	
	public void start()
	{
		System.out.println(myChatbot);
		System.out.println("What do you want to talk about???");
		
		String userText = input.nextLine();
		
		while (!userText.equals("quit"))
		{
			String response = interactWithChatbot(userText);
			System.out.println(response);
			System.out.println("Keep talking?");
			userText = input.nextLine();
		}
	}
	
	public String interactWithChatbot(String text)
	{
		String response = "";
		
		response += myChatbot.processText(text);
		
		
		return response;
	}
	
}
