package application;

public class BoardModel {
	
	private Integer[][] boardArray; 
	private int winningMove; 
	private int row;
	
	public void setRow(int row){
		this.row= row;
	}
	public int getRow(){
		return this.row;
	}
	
	public BoardModel(int size, int winningMove)
	{
		boardArray = new Integer[size][size]; //no need for setters because it will break encapsulation
		for(int i=0; i<boardArray.length;i++){
			for(int j = 0; j< boardArray[i].length; j++){
				boardArray[i][j] = 0;
				
			}
		}
		this.winningMove = winningMove; 
	}
	
	void putChip(Chip chip, int column)
	{
		boardArray[getRow()][column] = chip.getValue();
		for(int i=0; i<boardArray.length;i++){
			for(int j = 0; j< boardArray[i].length; j++){
				System.out.println("row " +i + "col " + j +" :  " +boardArray[i][j]);
				
			}
		}
	}
	
	int checkWinner()
	{
		//TODO to go over the whole board after every move
		return 0;
	}
	
	

}
