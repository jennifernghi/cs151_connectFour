package application;

public class BoardPresenter {
	
	private BoardGui view; 
	private Players[] players; 
	private BoardModel boardModel;
	private boolean turn = true; //true = player1 turn; false = player2 turn
	
	public BoardPresenter(int[] arguments){
		
		//create board internally and externally
		boardModel = new BoardModel(arguments[0], arguments[1]);
		view.createGrid(arguments[0]);
		
		players = new Players[2];
		players[0] = new Player(1);
		players[1] = new Player(2);
		
		
	}
	
	void attachView (BoardGui view)
	{
		this.view = view; 
		
	}
	
	void putChip(int column){
		//TODO respond when user press the top of row
		//connect with boardModel
		//need to set call view.promptWinner(String name) if winner exist
		if (turn)
		{
			boardModel.putChip(players[0].getChip(), column);
			turn = false;
		} else{
			boardModel.putChip(players[1].getChip(), column);
			turn = true;
		}
	
	
	}
	
	
	

}
