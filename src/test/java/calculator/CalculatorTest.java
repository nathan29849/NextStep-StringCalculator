package calculator;
//import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class CalculatorTest {

	private final static Logger LOG = LoggerFactory.getLogger(CalculatorTest.class);
	private Calculator cal;

	@BeforeEach
	void init() {
		cal = new Calculator();
		LOG.info(() -> "Test init");
	}

	@Test
	void add() {
		Assertions.assertThat(cal.add(3, 6)).isEqualTo(9);
	}

	@Test
	void subtract() {
		Assertions.assertThat(cal.subtract(7, 4)).isEqualTo(3);
	}

	@AfterEach
	void after() {
		LOG.info(() -> "after Test");
	}

}
