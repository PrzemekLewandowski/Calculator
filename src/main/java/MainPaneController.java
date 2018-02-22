import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPaneController {
	private boolean start = true;
	private String operator = "";
	private Double number1;
	private Calculator calculate = new Calculator();
	@FXML
	private Label labelUp;
	@FXML
	private Label labelDown;

	@FXML
	void initialize() {

	}

	@FXML
	private void processOperator(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			operator = value;
			number1 = Double.parseDouble(labelDown.getText());
			labelDown.setText("");
			labelUp.setText(number1 + operator);
		} else {
			if (operator.isEmpty())
				return;
			if (number1 != null) {
				labelDown.setText(calculate.calculate(number1, Double.parseDouble(labelDown.getText()), operator));
				labelUp.setText("");
			}
			operator = "";
			start = true;
		}
	}

	@FXML
	private void processNumpad(ActionEvent event) {
		if (start) {
			labelDown.setText("");
			start = false;
		}

		String value = ((Button) event.getSource()).getText();
		if (checkIfPointFirst(value))
			return;
		else if (checkIfAlreadyDouble(value))
			return;
		else if (checkIfZeroFirst(value))
			if (value.equals("."))
				labelDown.setText(labelDown.getText() + value);
			else
				labelDown.setText(value);

		else
			labelDown.setText(labelDown.getText() + value);

	}

	@FXML
	private void processClear(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		if (value.equals("C")) {
			labelDown.setText("");
			labelUp.setText("");
		} else if (value.equals("DEL")) {
			labelDown.setText(cutString(labelDown.getText()));
		}
	}

	private String cutString(String str) {
		if (str != null && str.length() > 1)
			return str.substring(0, str.length() - 1);
		else
			return "";
	}

	private boolean checkIfZeroFirst(String value) {
		if (labelDown.getText().equals("0"))
			return true;
		else
			return false;
	}

	private boolean checkIfAlreadyDouble(String value) {
		if (value.equals(".") && labelDown.getText().contains("."))
			return true;
		else
			return false;
	}

	private boolean checkIfPointFirst(String value) {
		if (labelDown.getText().isEmpty() && value.equals("."))
			return true;
		else
			return false;
	}

}
