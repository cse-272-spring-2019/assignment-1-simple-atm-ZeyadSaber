import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EnterTransaction {
	
	private Scene scene;
	private boolean TransType;
	private Home home;
	private Stage stage;
	private boolean check;
	private MyATM atm = new MyATM();
	
	public MyATM getMyATM() {
		return atm;
	}
	public EnterTransaction(Stage stage) {
		this.stage = stage;
	}
	
	public EnterTransaction() {}

	public void prepareScene() {
		
	Label amountText = new Label("Enter amount of money: ");
	Label confirmation = new Label();
	TextField amountField = new TextField();
	Button enter = new Button("Enter");
	Button back = new Button("Back");
	Alert numeric = new Alert(AlertType.ERROR, "Please Enter Numeric Data", ButtonType.CLOSE);

	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.add(amountText, 0, 0);
	grid.add(amountField, 1, 0);
	grid.add(enter, 1, 1);
	grid.add(confirmation, 1, 2);
	grid.add(back, 0, 1);
	grid.setVgap(20);
	grid.setHgap(10);
	
	amountField.setPrefWidth(400);
	enter.setDefaultButton(true);
	enter.setPrefWidth(100);
	back.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(home.getScene());
			confirmation.setText(null);
			
		}
	});
	enter.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			if(amountField.getText().matches("[0-9]+")) {
				
				if(TransType) {
					check = atm.checkWithdraw(amountField.getText());
					if(check) {
						atm.setWithdraw(amountField.getText());
						amountField.setText(null);
						confirmation.setText("Withdrawal process done successfully");
					}else {
						amountField.setText(null);
						confirmation.setText("You don't have enough balance for this process");
					}
				}else{
					atm.setDeposit(amountField.getText());
					amountField.setText(null);
					confirmation.setText("Deposit process done successfully");
				}
			}else {
				numeric.showAndWait();
			}
		}
	});
	scene = new Scene(grid, 800, 600);
	}
	
	public void setHome(Home home) {
		this.home = home;
	}
	
	public Scene getScene(boolean TransType) {
		this.TransType = TransType;
		return scene;
	}
}
