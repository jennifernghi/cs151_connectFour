package application;

public class BoardModel {
	
	private Chip[][] boardArray; 
	private int winningMove; 
	
	public BoardModel(int size, int winningMove)
	{
		boardArray = new Chip[size][size]; //no need for setters because it will break encapsulation
		this.winningMove = winningMove; 
	}
	
	int putChip(Chip chip, int column)
	{
		
		
		int  put = -1; //check if the column is full 
		
		for (int row =boardArray.length-1;row>=0; row--)
		{
			if(boardArray[row][column] == null){
				boardArray[row][column] = chip; 
				System.out.println("put chip at "+row+" "+column);
				put = row; 
				break; 
			}	
			
		}
		
		return put; 
	}
	
	int checkWinner()
	{
		//TODO to go over the whole board after every move
		return 0;
	}
	
	

}
