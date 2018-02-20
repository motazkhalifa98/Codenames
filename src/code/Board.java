package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private Location[][] board;
	private List<String> codenames=new ArrayList<String>();
	public Board(int x, int y) {
		Location[][] thisboard = new Location[x][y];
		this.board = thisboard;
		
	}

	public Location[][] getBoard() {
		return board;
	}

	public void setBoard(Location[][] board) {
		this.board = board;
	}
	public static void main(String[] args){
    }

	public void setCodeNames(String filename) {
		try {
			for(String line : Files.readAllLines(Paths.get(filename))){
				System.out.println(line);
			    codenames.add(line);
}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> getCodeNames(){
		return codenames;
	}
	
	
	

}
