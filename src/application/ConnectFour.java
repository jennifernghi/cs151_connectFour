package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class ConnectFour extends Application{

	private static Integer[] arguments = new Integer[2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
		//presenter = new BoardPresenter(Integer.parseInt(args[0].trim()), Integer.parseInt(args[1].trim()));
		//System.out.println(Integer.parseInt(args[0].trim()));
		arguments[0] = Integer.parseInt(args[0].trim());
		arguments[1] = Integer.parseInt(args[1].trim());
		launch(args);
		//Application.launch(BoardGui.class,args);
		}
		catch (Exception e)
		{
			//System.out.println("Invalid argument type.");
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BoardGui app = new BoardGui(new BoardPresenter(arguments[0], arguments[1]), arguments[0]);
		app.start(primaryStage);
		
	}

}
