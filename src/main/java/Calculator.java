
public class Calculator {
	public String calculate(Double number1, Double number2, String operator) {
		Double tmp;
		switch (operator) {
		case "+":
			tmp = number1 + number2;
			return tmp.toString();
		case "-":
			tmp = number1 - number2;
			return tmp.toString();
		case "*":
			tmp = number1 * number2;
			return tmp.toString();
		case "÷":
			if (number2 == 0)
			    return "Nie podzielisz przez zero.";
			tmp = number1 / number2;
			return tmp.toString();
		case "=":
			return "";
		default:
			return "Nieznany operator.";
		}
	}
}
