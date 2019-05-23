package com.codekata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {

	App app = new App();

	@Test
	void test0() {
		int[] a = new int[] { 2, 1, 3, 5, 3, 2 };

		int result = app.firstDuplicate(a);

		assertEquals(3, result);
	}

	@Test
	void test12() {
		int[] a = new int[] { 1, 1, 2, 2, 1 };

		int result = app.firstDuplicate(a);

		assertEquals(1, result);
	}

}
