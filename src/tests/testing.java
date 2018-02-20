package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import code.Board;
import code.Location;

public class testing
{
	@Test
	public void Testlocations()
	{
		
		Board test = new Board(5,5);
		Location[][] newBoard = test.getBoard();
		assertEquals(5, newBoard.length);
		assertEquals(5, newBoard[0].length);
	}
	@Test
	public void TestReadCodenames() {
		Board test=new Board(5,5);
		test.setCodeNames("src/GameWords1.txt");
		List<String> testList=Arrays.asList("AFRICA" , "AGENT" , "AIR" , "ALIEN" , "ALPS" , "AMAZON" , "AMBULANCE" , "AMERICA" , "ANGEL" , "ANTARCTICA" , "APPLE" , "ARM" , "ATLANTIS" , "AUSTRALIA" , "AZTEC" , 
				"BACK" , 
				"BALL" , 
				"BAND" , 
				"BANK" , 
				"BAR" , 
				"BARK" , 
				"BAT" , 
				"BATTERY" , 
				"BEACH" , 
				"BEAR" , 
				"BEAT" , 
				"BED" , 
				"BEIJING" , 
				"BELL" , 
				"BELT");
		
		List<String> response=test.getCodeNames();
			assertEquals("codename files match", testList,response);
		
	}
	
}