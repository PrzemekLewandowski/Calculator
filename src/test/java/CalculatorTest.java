import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

	@Test
	public void calculatorTest() {
		Calculator calc = new Calculator();
		Assert.assertEquals("10.0", calc.calculate(5.0, 5.0, "+"));
		Assert.assertEquals("10.1", calc.calculate(5.1, 5.0, "+"));
	}

}
