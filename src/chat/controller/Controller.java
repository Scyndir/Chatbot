package chat.controller;

import java.util.ArrayList;
import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;
import chat.view.ChatFrame;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller
{
	private Chatbot myChatbot;
	private Popup view; 
	private ChatFrame frame;
	
	public Controller()
	{
		this.myChatbot = new Chatbot("boi");
		this.view = new Popup();
		this.frame = new ChatFrame(this);
	}
	
	public void start()
	{

//		ArrayList<String> input = loadTextToList("user input.txt");
//		myChatbot.setUserInputs(input);
//		input = loadTextToList("chat.txt");
//		myChatbot.setChatbotResponses(input);
		
//		view.displayMessage(myChatbot.sayGreeting());
		
//		String userText = view.askQuestion("What do you want to talk about???");
//		while (!userText.equals("quit"))
//		{
//			String response = interactWithChatbot(userText);
//
//			view.displayMessage(response);
//				
//			userText = view.askQuestion("Keep Talking");
//		}
//		view.displayMessage(myChatbot.sayFarewell());
//		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
		
//		view.displayMessage("Let's save some text");
//		saveListAsText(myChatbot.getUserInputs(), "user input.txt");
//		saveListAsText(myChatbot.getChatbotResponses(), "chat output.txt");
		
	}
	
	public String interactWithChatbot(String text)
	{
		String response = "";
		
		response += myChatbot.processText(text);
		
		
		return response;
	}
	
	public String interactWithChatbot(String text, int choice)
	{
		String response = "";
		
		if (choice == 6)
		{
			saveListAsText(myChatbot.getUserInputs(), "user input.txt");
			saveListAsText(myChatbot.getChatbotResponses(), "chat output.txt");
			response+= "\nSaved the text\n";
		}
		else if (choice == 7)
		{
			ArrayList<String> userInput = loadTextToList("user input.txt");
			ArrayList<String> chatbotResponses = loadTextToList("chat ouput.txt");
			myChatbot.setUserInputs(userInput);
			myChatbot.setChatbotResponses(chatbotResponses);
		}
		response += myChatbot.processText(text, choice);
		
		
		return response;
	}
	
	public void handleError(Exception error)
	{
		String details = "Your error is: " + error.getMessage();
		view.displayMessage(details);
	}
	private void saveListAsText(ArrayList<String> responses, String filename)
	{
		File saveFile = new File(filename);
		
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			for (String content : responses)
			{
				saveText.println(content);
			}
		}
		catch (IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch (Exception genericError)
		{
			handleError(genericError);
		}
	}
	
	private ArrayList<String> loadTextToList(String filename)
	{
		ArrayList<String> fileContents = new ArrayList<String>();
		
		File source = new File(filename);
		
		try (Scanner fileScanner = new Scanner(source))
		{
			while (fileScanner.hasNextLine())
			{
					fileContents.add(fileScanner.nextLine());
			}
		}
		catch (IOException fileError)
		{
			handleError(fileError);
		}
		catch (Exception error)
		{
			handleError(error);
		}
		return fileContents;
	}
}
