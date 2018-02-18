
public class Calculator {
	public Float addition(Float x, Float y) {
		return x + y;
	}

	public Float substraction(Float x, Float y) {
		return x - y;
	}

	public Float multiplication(Float x, Float y) {
		return x * y;
	}

	public Float division(Float x, Float y) {
		if (y == 0)
			throw new ArithmeticException("Nie mo¿na dzieliæ przez 0.");
		else
			return x / y;
	}
}
