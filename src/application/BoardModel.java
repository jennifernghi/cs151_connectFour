package application;

public class BoardModel {
	
	private Chip[][] boardArray; 
	private int winningMove; 
	
	public BoardModel(int size, int winningMove)
	{
		boardArray = new Chip[size][size]; //no need for setters because it will break encapsulation
		this.winningMove = winningMove; 
	}
	
	void putChip(Chip chip, int column)
	{

	}
	
	int checkWinner()
	{
		//TODO to go over the whole board after every move
		return 0;
	}
	
	

}
