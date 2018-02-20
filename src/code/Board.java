package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Board {
	private Location[][]Board;
	
	public Board(Location[][] theboard) {
		this.Board = theboard;
	}

	public Location[][] getBoard() {
		return Board;
	}

	public void setBoard(Location[][] board) {
		Board = board;
	}
	public static void main(String[] args){
        try{
            String filename = "src/GameWords.txt";
            for(String line : Files.readAllLines(Paths.get(filename))){
                System.out.println(line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
	
	
	

}
