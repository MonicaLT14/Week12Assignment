package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false), arguments(1, 5, 6, false), arguments(-3, 7, 0, true)

		);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyNumbers")
	void assertThatNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.multiplyNumbers(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.multiplyNumbers(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForMultiplyNumbers() {
		return Stream.of(arguments(2, 4, 8, false), arguments(0, 5, 0, false), arguments(-3, 7, -21, false));
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(TestDemo.class);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}
}
