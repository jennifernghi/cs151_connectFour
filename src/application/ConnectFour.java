package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class ConnectFour extends Application {
	private static int[] arguments; 
	
	public void start(Stage primaryStage) {
		BoardGui app = new BoardGui(new BoardPresenter(arguments));
		app.start(primaryStage);
	}
	
	public static void main(String[] args) {
		//TODO get arguments int Size, int Length 
		//need try catch to make sure it's valid arguments
		arguments =new int[2];
		arguments[0] = Integer.parseInt(args[0]);
		arguments[1] = Integer.parseInt(args[1]);
		launch(args);
	}
}
