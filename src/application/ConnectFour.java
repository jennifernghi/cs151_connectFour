package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class ConnectFour extends Application{

	private static Integer[] arguments = new Integer[2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
		
			arguments[0] = Integer.parseInt(args[0].trim());
			arguments[1] = Integer.parseInt(args[1].trim());
			if(arguments[1]<arguments[0]){
				launch(args);
			}else
			{
				System.out.println("winner move must smaller than size");
				System.exit(0);
			}
				
		}
		catch (Exception e)
		{
			System.out.println("Invalid argument type. check command line!");
			System.out.println("java application.ConnectFour size winningmove");
			System.out.println("or java -jar ConnectFour size winningmove");
			System.exit(0);
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BoardGui app = new BoardGui(new BoardPresenter(arguments[0], arguments[1]));
		app.start(primaryStage);
		
	}

}
