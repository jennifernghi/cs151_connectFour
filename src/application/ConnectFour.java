package application;

import javafx.application.Application;

public class ConnectFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardPresenter presenter = new BoardPresenter(Integer.parseInt(args[0].trim()), Integer.parseInt(args[1].trim()));
		Application.launch(BoardGui.class,args);
		
	}

}
