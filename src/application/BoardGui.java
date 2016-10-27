package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class BoardGui extends Application {

	BoardPresenter presenter; 
	
	public BoardGui(BoardPresenter presenter)
	{
		this.presenter = presenter; 
		presenter.attachView(this); 
				
	}
	
	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		
	}

	

}
