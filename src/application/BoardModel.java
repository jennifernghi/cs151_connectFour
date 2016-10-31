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
	
	
	int checkWinner(int size, int winningMove)
	{	//TODO to go over the whole board after every move
		int consecutiveChipValue=0;
		int repeat =1;
		
		//check vertically
		consecutiveChipValue = checkVertically(consecutiveChipValue, repeat, size, winningMove);
	        
		//check horizontally
		consecutiveChipValue = checkHorizontally(consecutiveChipValue, repeat, size, winningMove);
		//check diagonal left - to - right
		
		//check diagonal right - to - left
		 System.out.println("consecutive: "+consecutiveChipValue);
		return consecutiveChipValue;
	}
	
	public int checkVertically(int consecutiveChipValue, int repeat, int size, int winningMove){
		 for (int column = 0; column < size ; column++) {
	            for (int row = 1; row < size; row++) {
	            	//compare with previous row
	                if (boardArray[row][column] != 0 && (boardArray[row][column] == boardArray[row-1][column]))
	                    ++repeat;
	                else
	                    repeat = 1;

	                // Check if there are consecutive chip in a row that = winningMove.
	                if (repeat == winningMove) {
	                    // Return color of the winner
	                	consecutiveChipValue= boardArray[row][column];
	                }
	            }
	        }
		 return consecutiveChipValue;
	}
	
	public int checkHorizontally(int consecutiveChipValue, int repeat, int size, int winningMove){
		 for (int row = 0; row < size ; row++) {
	            for (int column = 1; column < size; column++) {
	            	//compare with previous column
	                if (boardArray[row][column] != 0 && (boardArray[row][column] == boardArray[row][column-1]))
	                    ++repeat;
	                else
	                    repeat = 1;

	                // Check if there are consecutive chip in a row that = winningMove.
	                if (repeat == winningMove) {
	                    // Return color of the winner
	                	consecutiveChipValue= boardArray[row][column];
	                }
	            }
	        }
		 return consecutiveChipValue;
	}
	
	

}
