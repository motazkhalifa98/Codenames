package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import code.Board;
import code.Location;

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
		Location[][] testing=test.getBoard();
		test.setCodeNames("src/GameWords.txt");
		for(int row=0; row<5; row++)
			for(int col=0; col<5; col++) {
				Person one=testing[row][col];
				if(one.getAssignment==RedAgent)
					red++;
				else if(one.getAssignment==BlueAgent)
					blue++;
				else if(one.getAssignment==Innocent)
					inn++;
				else if(one.getAssignment==Assassin)
					ass++;
			}
		assertTrue(red==9);
		assertTrue(blue==8);
		assertTrue(inn==7);
		assertTrue(ass==1);
	}
	
}