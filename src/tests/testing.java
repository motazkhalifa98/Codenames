package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import code.Board;
import code.Location;
import code.Person;
import code.threePlayer;
/**
 * This class contains 11 junit tests that cover every aspect of the grading rubric for phase 1
 * 
 * 
 *
 */
public class testing
{
	/**
	 * This method ensures that the Board created has the correct
	 * number of Location instances
	 * 
	 */
	@Test
	public void Test25Locations()
	{
		
		Board test = new Board(5,5);
		Location[][] newBoard = test.getBoard();
		assertEquals("board size",5, newBoard.length);
		assertEquals("board size",5, newBoard[0].length);
	}
	/**
	 * This method tests the programs ability to read a file containing codenames
	 * and put them in a List
	 */
	@Test
	public void TestReadCodenameFile() {
		Board test=new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		List<String> testList=Arrays.asList("area",
				"book",
				"business",
				"case",
				"child",
				"company",
				"country",
				"day",
				"eye",
				"fact",
				"family",
				"government",
				"group",
				"hand",
				"home",
				"job",
				"life",
				"lot",
				"man",
				"money",
				"month",
				"mother",
				"Mr",
				"night",
				"number",
				"part",
				"people",
				"place",
				"point",
				"problem",
				"program",
				"question",
				"right",
				"room",
				"school",
				"state",
				"story",
				"student",
				"study",
				"system",
				"thing",
				"time",
				"water",
				"way",
				"week",
				"woman",
				"word",
				"work",
				"world",
				"year");
		
		List<String> response=test.getAllCodeNames();
		for(int word=0; word<response.size(); word++) {
			assertTrue("codename files match", testList.contains(response.get(word)));
		}
	}
	/**
	 * This method tests the programs ability to select 25 codenames at random and store them in
	 * a list to be used in the game
	 */
	@Test
	public void test25uniqueCodenames() {
		Board test=new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		List<String> actual=test.getGameCodeNames();
		for(int name=0; name<actual.size(); name++) {
			for(int code=name+1; code<actual.size(); code++) {
				assertTrue(actual.get(name)!=actual.get(code));
			}
			
		}
	}
	/**
	 * This method tests that there are randomly generated assignments for
	 * 6 red, 5 blue, 5 green, 7 innocent, and 2 assassins
	 */ 
	@Test
	public void testAssignments() {
		int red=0;
		int blue=0;
		int green=0;
		int inn=0;
		int ass=0;
		threePlayer test=new threePlayer(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		Location[][] testing=test.getBoard();
		for(int row=0; row<5; row++)
			for(int col=0; col<5; col++) {
				Location one = testing[row][col];
				if(((Person)one.getPersonType()).getPersonType() == "RedAgent")
					red++;
				else if(((Person) one.getPersonType()).getPersonType()=="BlueAgent")
					blue++;
				else if(((Person) one.getPersonType()).getPersonType()=="InnocentBystander")
					inn++;
				else if(((Person) one.getPersonType()).getPersonType()=="GreenAgent")
					green++;
				else if(((Person) one.getPersonType()).getPersonType()=="Assassin")
					ass++;
			}
		assertTrue(red==6);
		assertTrue(blue==5);
		assertTrue(green==5);
		assertTrue(inn==7);
		assertTrue(ass==2);
	}
	/**
	 * This method ensures that Red goes first
	 * Every Location has a codename and Person
	 * Nothing is revealed
	 */
	@Test
	public void testLocationFilled()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		Location[][] testLocation = test.getBoard();
		assertEquals("Red team goes first","RedAgent", test.getCurrentPlayer());
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				assertFalse(testLocation[i][j].getCodeName().equals(""));
				assertFalse(testLocation[i][j].getCodeName()==(null));
				assertEquals("Person is not revealed",0,testLocation[i][j].getReveal());
				assertNotEquals("Person exists",null,((Person)testLocation[i][j].getPersonType()).getPersonType());
			}
		}
	}
	/**
	 * This makes sure there is a method that returns if a clue is legal or not
	 * Clues cant equal a current codename unless it was already revealed
	 */
	@Test
	public void legalClue()
	{
		Board test2 = new Board(5,5);
		test2.setCodeNames("src/GameWords.txt");
		test2.startGame();
		for(int loc=0; loc<test2.getBoard().length; loc++)
			for(int loca=0; loca<test2.getBoard()[0].length; loca++)
			if(test2.getBoard()[loc][loca].getReveal()==1) {
				test2.setClue(test2.getBoard()[loc][loca].getCodeName());
				assertEquals("clue is legal b/c person is revealed",true,test2.legalClue());
			}else if(test2.getBoard()[loc][loca].getReveal()==0) {
				test2.setClue(test2.getBoard()[loc][loca].getCodeName());
				assertEquals("clue is illegal b/c person is not revealed",false,test2.legalClue());
			}
		test2.setClue("adsfagsd");
		assertEquals("Legal clue",true, test2.legalClue());
		

	}
	/**
	 * This test sees if the Board is in a winning state because both the assassins were found
	 */
	@Test
	public void winningStateAssassinsFound()
	{
		threePlayer test = new threePlayer(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		for(int i = 0; i < test.getBoard().length; i++)
		{
			for (int j = 0; j < test.getBoard()[i].length; j++)
			{
				if(test.getBoard()[i][j].getPersonType()=="Assassin")
				{
					test.makeMove(i,j);
				}
			}
		}
		test.gameState();
		assertEquals("Board is in winning state", true, test.getWinningState());
	}
	/**
	 * This test sees if the Board is in a winning state because all red persons found
	 */
	@Test
	public void winningStateRedFound()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		test.setRedCount(0);
		test.gameState();
		assertEquals("Board is in winning state", true, test.getWinningState());
	}
	/**
	 * This test sees if the Board is in a winning state because all blue persons found
	 */
	@Test
	public void winningStateBlueFound()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		test.setBlueCount(0);
		test.gameState();
		assertEquals("Board is in winning state", true, test.getWinningState());
	}
	/**
	 * This test sees if the Board is in a winning state because all green persons found
	 */
	@Test
	public void winningStateGreenFound()
	{
		threePlayer test = new threePlayer(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		test.setGreenCount(0);
		test.gameState();
		assertEquals("Board is in winning state", true, test.getWinningState());
	}
	/**
	 * This tests that there is a method which:
	 * decrements the count of agents to be found,
	 * updates a Location when codename selected,
	 * returns if Location contained current teams agent,
	 */
	@Test
	public void updateBoardState()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.setCurrentPlayer("Red");
		test.startGame();
		Location[][] testLocation = test.getBoard();
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "RedAgent")
				{
					test.makeMove(i, j);
					test.gameState();
					assertEquals("count decremented", 8, test.getRedCount());
					assertEquals("Location does not contain current teams Agent.", "Red", test.getCurrentPlayer());
					assertEquals("The Player is revealed", 1, testLocation[i][j].getReveal());
				}
			}
		}

		
		
	}
	/**
	 * Tests that there is a method that correctly determines whose turn is next
	 */
	@Test
	public void nextMove()
	{
		threePlayer test = new threePlayer(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.setCurrentPlayer("Red");
		test.startGame();
		assertEquals("Red should start game","Red",test.getCurrentPlayer());
		Location[][] testLocation = test.getBoard();
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "Assassin")
				{
					if(testLocation[i][j].getReveal()==0)
					{
						test.makeMove(i, j);
						i=testLocation.length;
						assertEquals("Should be blues turn after red finds an assassin","Blue",test.getCurrentPlayer());
					}
				}
			}
		}
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "RedAgent")
				{
					if(testLocation[i][j].getReveal()==1)
					{
						testLocation[i][j].setReveal(0);
						test.makeMove(i, j);
						i=testLocation.length;
						assertEquals("Should be greens turn after blue finds a red  agent","Green",test.getCurrentPlayer());
					}
				}
			}
		}
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "RedAgent")
				{
					if(testLocation[i][j].getReveal()==1)
					{
						testLocation[i][j].setReveal(0);
						test.makeMove(i, j);
						i=testLocation.length;
						assertEquals("Should be blue turn after green finds a red agent","Red",test.getCurrentPlayer());
					}
				}
			}
		}
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "Assassin")
				{
					if(testLocation[i][j].getReveal()==1)
					{
						testLocation[i][j].setReveal(0);
						test.makeMove(i, j);
						i=testLocation.length;
						assertEquals("Should be green wins after  blue finds an assassin","Green",test.getCurrentPlayer());
					}
				}
			}
		}
	}
	/**
	 * Tests that there is a method that returns the winning team when the assassin is revealed
	 */
	@Test
	public void whichTeamFound()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.setCurrentPlayer("Red");
		test.startGame();
		Location[][] testLocation = test.getBoard();
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "Assassin")
				{
					test.makeMove(i, j);
					test.gameState();

				}
			}
		}
		assertEquals("Game in winning state", true, test.getWinningState());
		//assertEquals("Assassin Revealed",1,testLocation[i][j].getReveal());
		assertEquals("Blue should win", "Blue", test.getWinningTeam());
	}
}