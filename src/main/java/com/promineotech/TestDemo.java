package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}

	public int multiplyNumbers(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		} else if (b > 0) {
			int result = 0;
			for (int i = 0; i < b; i++) {
				result += a;
			}
			return result;
		} else {
			return -multiplyNumbers(a, -b);
		}
	}

	int randomNumberSquared() {
	    int randomInt = getRandomInt(); 
	    int result = randomInt * randomInt; 
	    return result; 
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}