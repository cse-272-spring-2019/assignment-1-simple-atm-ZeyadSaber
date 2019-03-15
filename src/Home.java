import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home {
	private Scene scene;
	private EnterTransaction trans = new EnterTransaction();
	private Stage stage;
	
	public Home(Stage stage) {
		this.stage = stage;
	}
	public void prepareScene() {
		Label transactionLabel = new Label("Enter type of transaction: ");
		Label Balance_History = new Label();
		Label transDone = new Label();
		Button withdrawal = new Button("Withdrawal");
		Button deposit = new Button("Deposit");
		Button next = new Button("Next Transaction");
		Button prev = new Button("Previous Transaction");
		Button balanceInquiry = new Button("Balance Inquiry");
		GridPane grid = new GridPane();

		grid.add(transactionLabel, 0, 1);
		grid.add(withdrawal, 1, 1);
		grid.add(deposit, 2, 1);
		grid.add(transDone, 1, 2);
		grid.add(prev, 0, 3);
		grid.add(next, 2, 3);
		grid.add(balanceInquiry, 1, 3);
		grid.add(Balance_History, 1, 0);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		next.setDisable(true);
		withdrawal.setPrefSize(200, 50);
		deposit.setPrefSize(200, 50);
		next.setPrefSize(200, 50);
		prev.setPrefSize(200, 50);
		balanceInquiry.setPrefSize(200, 50);
		transactionLabel.setFont(Font.font("Verdana",FontWeight.BOLD,14));
		Balance_History.setPrefHeight(60);
		Balance_History.setFont(Font.font("Verdana",FontWeight.BLACK,14));
		withdrawal.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(trans.getScene(true));
				
			}
		});
		
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(trans.getScene(false));
				
			}
		});
		
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Balance_History.setText("Your current balance is: "+trans.getMyATM().getBalance());
			}
		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

					Balance_History.setText(trans.getMyATM().next());
				
			}
		});
		
		prev.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
					next.setDisable(false);
					Balance_History.setText(trans.getMyATM().previous());
				
				
			}
		});
		scene = new Scene(grid, 800, 600);
	}
	
	public void setTrans(EnterTransaction trans) {
		this.trans = trans;
	}
	
	public Scene getScene() {
		return scene;
	}
}
