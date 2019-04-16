import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StockTest {

	@Test
	void randomValuesA() {
		Stock stock = new Stock(45, 24, 35, 31, 40, 38, 11);

		stock.calculate();

		assertEquals(20, stock.getMaxProffit());

	}

}
