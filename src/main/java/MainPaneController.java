import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPaneController {
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
		if (labelDown.getText().isEmpty() || labelDown.getText().equals("-")) {
			if (value.equals("-"))
				labelDown.setText("-");
			return;
		}
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			if(!isNumeric(labelDown.getText())) {
				labelDown.setText("");
				return;
			}
			operator = value;
			number1 = Double.parseDouble(labelDown.getText());
			String number1AsString = String.valueOf(number1);
			if (checkIfEndsWithPointZero(number1AsString))
				number1AsString = number1AsString.substring(0, number1AsString.length() - 2);
			labelDown.setText("");
			labelUp.setText(number1AsString + " " + operator + " ");
		} else {
			if (operator.isEmpty())
				return;
			String result = calculate.calculate(number1, Double.parseDouble(labelDown.getText()), operator);
			if (checkIfEndsWithPointZero(result))
				result = result.substring(0, result.length() - 2);
			labelDown.setText(result);
			labelUp.setText("");
			operator = "";
		}
	}
	
	private boolean isNumeric(String str){
		  return str.matches("-?\\d+(\\.\\d+)?");
	}

	private boolean checkIfEndsWithPointZero(String str) {
		return str.endsWith(".0");
	}

	@FXML
	private void processNumpad(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		if (checkIfPointFirst(value))
			return;
		else if (checkIfAlreadyDouble(value))
			return;
		else if (checkIfAlreadyZero(value))
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

	private boolean checkIfAlreadyZero(String value) {
		return labelDown.getText().equals("0");
	}

	private boolean checkIfAlreadyDouble(String value) {
		return value.equals(".") && labelDown.getText().contains(".");
	}

	private boolean checkIfPointFirst(String value) {
		return ((labelDown.getText().isEmpty() && value.equals("."))
				|| labelDown.getText().equals("-") && value.equals("."));
	}

}
