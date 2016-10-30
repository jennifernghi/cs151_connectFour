package application;

import javafx.scene.paint.Color;

public class BoardPresenter {
	BoardGui view;
	BoardModel boardModel;
	AbstractPlayer player1;
	AbstractPlayer player2;
	Integer turn;

	public BoardPresenter(Integer size, Integer winningMove) {
		setTurn(1);
		setBoardModel(new BoardModel(size, winningMove));
			
		setPlayer1(new Players(1, new Chip(1, Color.GREEN)));
		setPlayer2(new Players(2, new Chip(2, Color.RED)));
		
	}
	//attach view
	public void setView(BoardGui view) {
		this.view = view;
	}
	
	public BoardGui getView() {
		return this.view;
	}
	
	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}
	public BoardModel getBoardModel() {
		return this.boardModel;
	}
	
	public void setPlayer1(AbstractPlayer player1) {
		this.player1 = player1;
	}
	
	public AbstractPlayer getPlayer1() {
		return this.player1;
	}
	
	public void setPlayer2(AbstractPlayer player2) {
		this.player2 = player2;
	}
	
	public AbstractPlayer getPlayer2() {
		return this.player2;
	}
	
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	
	public Integer getTurn() {
		return this.turn;
	}
	
	public void setRow(int row) {
		boardModel.setRow(row);
	}
	public void putChip(int column) {
		//boardModel.putChip();
		if(getTurn() ==1){
			boardModel.putChip(player1.getChip(), column);
		    setTurn(2);} 
		else
		{
			boardModel.putChip(player2.getChip(), column);
			setTurn(1); 
		}
		
		int winner = boardModel.checkWinner();
		
		if (winner == 1)
			view.promptWinner(""+player1.getPlayerId());
		else if (winner ==2)
			view.promptWinner(""+player2.getPlayerId());
		else if (winner ==-1)
			view.promptTie(); //when the board is filled
			
		System.out.println(column);
	}


	
	

}
