package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
	}
	
	public String processText(String text)
	{	
		String response = sayGreeting() + "\nYou said: ";
		
		response += text + "\n";
		
		if (text.toLowerCase().indexOf("date") >= 0)
		{
			response += getDate() + "\n";
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			response += getTime() + "\n";
		}
		
		if (isPolitical(text))
		{
			response += "gross, politics\n";
		}
		
		if (isPolite(text))
		{
			response += "How polite of you\n";
		}
		
		response += getRandomTopic() + "\n";
		
		return response;
	}
	
	public String sayGreeting()
	{
		String greeting = "";
		
		ArrayList<String> greetings = new ArrayList<String>();
		
		greetings.add("Hi there!");
		greetings.add("Hello");
		greetings.add("G'day mate");
		greetings.add("Howdy");
		greetings.add("What's up?");
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		if (greetingCount == greetings.size())
		{
			greetingCount = 0;
		}
		
		return greeting;
	}
	
	public String sayFarewell()
	{
		String farewell = "";
		
		ArrayList<String> farewells = new ArrayList<String>();
		
		farewells.add("Goodbye");
		farewells.add("Au revoir");
		farewells.add("Do svidaniya");
		farewells.add("cya");
		farewells.add("Have a good day!");
		
		farewell = farewells.get(farewellCount);
		farewellCount--;
		if (farewellCount == 0)
		{
			farewellCount = 4;
		}
		
		return farewell;
	}
	
	public boolean isPolitical(String parameter)
	{
		boolean political = false;
		
		ArrayList<String> politics = new ArrayList<String>();
		
		politics.add("politics");
		politics.add("republican");
		politics.add("democrat");
		politics.add("election");
		politics.add("biden");
		
		for (String current : politics)
		{
			if (parameter.toLowerCase().indexOf(current) >= 0)
			{
				political = true;
			}
		}
		
		return political;
	}
	
	public boolean isPolite(String parameter)
	{
		boolean polite = false;
		
		ArrayList<String> politeness = new ArrayList<String>();
		
		politeness.add("please");
		politeness.add("thank you");
		
		for (String current : politeness)
		{
			if (parameter.toLowerCase().indexOf(current) >= 0)
			{
				polite = true;
			}
		}
		return polite;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a Chatbot called: " + name + "\n";
		description += "My favourite topic is: N/A";
		
		return description;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDate()
	{
		String date = "The date is ";
		
		LocalDateTime currentDate = LocalDateTime.now();
		
		String day = currentDate.getDayOfWeek().toString();
		
		date += day + ", ";
		
		day = "the " + currentDate.getDayOfMonth() + " ";
		
		date += day + "of ";
		
		String month = currentDate.getMonth().toString();
		
		date += month + ", " + currentDate.getYear();
		
		return date;
	}
	
	public String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time += currentTime.getHour() + ":";
		time += currentTime.getMinute();
		
		
		
		return time;
	}
	
	public String getRandomTopic()
	{
		String topic = "";
		
		
		ArrayList<String> randomTopics = new ArrayList<String>();
		
		randomTopics.add("Pancakes or waffles?");
		randomTopics.add("Have you read Ready Player One?");
		randomTopics.add("What's your favourite flavour of ice cream?");
		randomTopics.add("I would love some coffee right now");
		randomTopics.add("What is your favourite academic subject?");
		randomTopics.add("What's the largest word you know?");
		randomTopics.add("What is your favourite dinosaur");
		randomTopics.add("Where would you take a first date?");
		randomTopics.add("I love hiking, do you?");
		randomTopics.add("Do you enjoy wakeboarding?");
		
		int randomIndex = (int) (Math.random() * randomTopics.size());
		
		topic = randomTopics.get(randomIndex);
		
		return topic;
	}
}
