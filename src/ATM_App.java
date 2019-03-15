import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATM_App extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		LoginForm loginform = new LoginForm(primaryStage);
		Home home = new Home(primaryStage);
		EnterTransaction trans = new EnterTransaction(primaryStage);
		
		loginform.prepareScene();
		home.prepareScene();
		trans.prepareScene();
		loginform.setHome(home);
		trans.setHome(home);
		home.setTrans(trans);
		primaryStage.setScene(loginform.getScene());
		primaryStage.show();
		
	}

}
