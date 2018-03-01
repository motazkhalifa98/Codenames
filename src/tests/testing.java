package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import code.Board;
import code.Location;
import code.Person;

public class testing
{
	@Test
	public void Test25Locations()
	{
		
		Board test = new Board(5,5);
		Location[][] newBoard = test.getBoard();
		assertEquals("board size",5, newBoard.length);
		assertEquals("board size",5, newBoard[0].length);
	}
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
	@Test
	public void testAssignments() {
		int red=0;
		int blue=0;
		int inn=0;
		int ass=0;
		Board test=new Board(5,5);
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
				else if(((Person) one.getPersonType()).getPersonType()=="Assassin")
					ass++;
			}
		assertTrue(red==9);
		assertTrue(blue==8);
		assertTrue(inn==7);
		assertTrue(ass==1);
	}
	
	@Test
	public void testLocationFilled()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		Location[][] testLocation = test.getBoard();
		assertEquals("Red team goes first","Red", test.getCurrentPlayer());
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[0].length; j++)
			{
				assertFalse(testLocation[i][j].getCodeName().equals(""));
				assertEquals("Person is not revealed",0,testLocation[i][j].getReveal());
				assertNotEquals("Person exists",null,((Person)testLocation[i][j].getPersonType()).getPersonType());
			}
		}
	}
	
	@Test
	public void legalClue()
	{
		Board test2 = new Board(5,5);
		test2.setCodeNames("src/GameWords.txt");
		test2.startGame();
		List<String> r = test2.getAllCodeNames();
		test2.setClue(r.get(0));
		assertEquals("The clue and the codename cannot be the same", true, test2.legalClue());
		test2.setClue("adsfagsd");
		assertEquals("This clue should work.", false, test2.legalClue());
		

	}
	
	@Test
	public void winningState()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		Location[][] testLocation = test.getBoard();
		for(int i = 0; i < testLocation.length; i++)
		{
			for (int j = 0; j < testLocation[i].length; j++)
			{
				if(((Person)testLocation[i][j].getPersonType()).getPersonType() == "Assassin")
				{
					testLocation[i][j].setReveal(1);
				}
			}
		}
		test.setBoard(testLocation);
		test.AssassinFound();
		test.gameState();
		assertEquals("this game is over.", true, test.getWinningState());
	}
	
	@Test
	public void updateBoardState()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		test.setCurrentPlayer("Red");
		Location[][] testLocation = test.getBoard();
		int count = test.getCount(); int row = 0; int column = 0;
		for(int i = 0; i < testLocation.length; i++)
		{
			for(int j = 0; j < testLocation[i].length; j++)
			{
				if(testLocation[i][j].getPersonType() == "RedAgent")
				{
					row = i;
					column = j;
				}
			}
		}
		test.makeMove(row, column);
		test.checkWhoseRevealed();
		assertEquals("count didn't decrease", count - 1, test.getCount());
		assertEquals("Location does not contain current teams Agent.", "Red", test.getCurrentPlayer());
		assertEquals("The Player is not revealed", 1, testLocation[row][column].getReveal());
	}
	
	@Test
	public void whichTeamFound()
	{
		Board test = new Board(5,5);
		test.setCodeNames("src/GameWords.txt");
		test.startGame();
		test.setCurrentPlayer("Red");
		Location[][] testLocation = test.getBoard();
		for(int i = 0; i < testLocation.length; i++)
		{
			for (int j = 0; j < testLocation[i].length; j++)
			{
				if(((Person)testLocation[i][j].getPersonType()).getPersonType() == "Assassin")
				{
					testLocation[i][j].setReveal(1);
				}
			}
		}
		test.setBoard(testLocation);
		test.AssassinFound();
		test.gameState();
		assertEquals("This is the losing team", "Red", test.getCurrentPlayer());
	}
}