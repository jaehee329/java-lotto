package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

	StringValidator stringValidator = new StringValidator();

	@DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
	@Test
	void checkIsNumberTest() {
		assertThatThrownBy(() -> stringValidator.checkIsNumber("힣"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입 금액이 음수라면 예외가 발생한다.")
	@Test
	void checkIsNumberPositiveTest() {
		assertThatThrownBy(() -> stringValidator.checkIsPositiveNumber("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
	@Test
	void checkIsMultipliedBy1000Test() {
		assertThatThrownBy(() -> stringValidator.checkIsMultipliedBy1000("30001"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
