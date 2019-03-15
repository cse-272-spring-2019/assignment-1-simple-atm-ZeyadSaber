import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginForm {
	private Scene scene;
	private Stage stage;
	private Home home;
	public LoginForm(Stage stage)
	{
		this.stage = stage;
	}
	public void prepareScene() {
		
		
		Label cardIDLabel = new Label("Enter your card ID: ");
		TextField IDText = new TextField();
		Button enterButton = new Button("Enter");
		Alert alert = new Alert(AlertType.INFORMATION, "Wrong card ID", ButtonType.OK);
		Alert numeric = new Alert(AlertType.ERROR, "Please Enter Numeric Data", ButtonType.CLOSE);
		enterButton.setDefaultButton(true);
		GridPane grid = new GridPane();
		grid.add(cardIDLabel, 0, 1);
		grid.add(IDText, 1, 1);
		grid.add(enterButton, 1, 2);
		grid.setVgap(10);
		grid.setHgap(20);
		grid.setPadding(new Insets(200,200,200,200));
		grid.setAlignment(Pos.CENTER);
		enterButton.setPrefSize(130, 50);
		IDText.setPrefWidth(220);
		cardIDLabel.setFont(new Font(18));
		enterButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(IDText.getText().matches("[0-9]+"))
					if(IDText.getText().equals("5564"))
						stage.setScene(home.getScene());
					else
						alert.showAndWait();
				else
					numeric.showAndWait();
				
			}
		});

		scene = new Scene(grid, 800, 600);
		
	}
	public void setHome(Home home) {
		this.home = home;
	}
	
	public Scene getScene() {
		return scene;
	}

}
