import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StockTest {

	@BeforeEach
	void init(TestInfo testInfo) {
		String callingTest = testInfo.getTestMethod().get().getName();
		System.out.println("Call test: "+callingTest);
	}

	@Test
	void randomValuesA() {
		Stock stock = new Stock(45, 24, 35, 31, 40, 38, 11);

		stock.calculate();

		assertEquals(20, stock.getMaxProffit());
	}

	@Test
	void randomValuesB() {
		Stock stock = new Stock(2, 4, 3, 2, 5, 6);

		stock.calculate();

		assertEquals(6, stock.getMaxProffit());
	}

	@Test
	void randomValuesC() {
		Stock stock = new Stock(2, 4, 3, 2, 5, 1);

		stock.calculate();

		assertEquals(5, stock.getMaxProffit());
	}

	@Test
	void randomValuesD() {
		Stock stock = new Stock(2, 4, 2, 2, 2, 5, 1);

		stock.calculate();

		assertEquals(5, stock.getMaxProffit());
	}


}
