package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private StringCalculator cal;

	@BeforeEach
	void init() {
		cal = new StringCalculator();
	}

	@Test
	void 아무것도_없는_문자열의_경우_0을_반환한다() {
		assertThat(cal.add("")).isZero();
	}

	@Test
	void null_값의_경우_0을_반환한다() {
		assertThat(cal.add(null)).isZero();
	}

	@Test
	void 숫자_하나만_문자열로_들어오는_경우_해당_숫자를_반환한다() {
		assertThat(cal.add("3")).isEqualTo(3);
	}

	@Test
	void 쉼표를_구분하여_더한다() {
		assertThat(cal.add("3,4")).isEqualTo(7);
		assertThat(cal.add("3,4,5")).isEqualTo(12);
		assertThat(cal.add("23,4,5")).isEqualTo(32);
	}

	@Test
	void 세미콜론을_구분하여_더한다() {
		assertThat(cal.add("3;4")).isEqualTo(7);
		assertThat(cal.add("3;4;5")).isEqualTo(12);
	}

	@Test
	void 쉼표와_세미콜론이_함께_있는_경우에도_구분하여_더한다() {
		assertThat(cal.add("3,4;5")).isEqualTo(12);
		assertThat(cal.add("3;4,5")).isEqualTo(12);
	}

	@Test
	void 커스텀_구분자를_구분하여_더한다() {
		assertThat(cal.add("//!\n3!4!5")).isEqualTo(12);
//		assertThat(cal.add("//!\n")).isZero();
	}

	@Test
	void 음수가_있다면_RuntimeException_예외처리_한다() {
		Assertions.assertThatThrownBy(() -> cal.add("//!\n-3!4!5"))
			.isInstanceOf(RuntimeException.class);
	}
}
