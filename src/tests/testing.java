package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;

public class testing
{
	public void locations()
	{
		Board test = new Board();
		double[][] newBoard = test.getBoard();
		assertEquals(5, newBoard.length);
		assertEquals(5, newBoard[0].length);
	}
	
}