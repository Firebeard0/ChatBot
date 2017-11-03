package chatbot.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new  ArrayList<Movie>();
		this.shoppingList = new  ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String[10];                             
		this.username = username;
		this.content = ""; 
		this.intro = "";
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
//		buildTopics();
//		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	private void buildMovieList()
	{
		movieList.add(new Movie("Captain America"));
		movieList.add(new Movie("Thor"));
		movieList.add(new Movie("Hulk"));
		movieList.add(new Movie("Ironman"));
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Hidden Figures"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("crab");
		shoppingList.add("salmon");
		shoppingList.add("gold fish");
		shoppingList.add("oreos");
		shoppingList.add("chips");
		shoppingList.add("lasagna");
		shoppingList.add("pizza");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0]="What is your name?";
		questions[1]="What is your favorite color?";
		questions[2]="What is your weight?";
		questions[3]="What is your number?";
		questions[4]="What is your adress?";
		questions[5]="What is your call sign?";
		questions[6]="What is your favorite car?";
		questions[7]="What is your favorite candy?";
		questions[8]="What is your hair color?";
		questions[9]="What is your toothbrush color?";
		
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "you said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		
		random = (int) (Math.random() * topics.length);
		response  += " " + topics[random] + ". \n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	} 
	
	public boolean userNameChecker(String input)
	{
		boolean valid = false;
		if (input.substring(0).equals("@"));
				{
			valid = true;
				}
		for (int i = 1; i > input.length(); i ++)	
		if (input.substring(i).equals("@"))
		{
			valid  = false;
		}
		return valid;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean valid  = false;
		if (shoppingItem != "slug bait")
		{
			valid = true;
		}
        return valid;
	}
	
	public boolean movieTitleChecker(String title)
	{
		boolean valid = false;
		if (title != "")
		{
			valid = true;
		}
		return valid;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		boolean valid = false;
		if (genre != "")
		{
			valid = true;
		}
		
		return valid;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString == null)
		{
			return false;
		}
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
//		String mash = "qwertyuiop[]asdfghjkl;'zxcvbnm,./0;";
//		for (int i=0; i < mash.length() - 2; i ++)
//		{
//			
//		}
	return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
