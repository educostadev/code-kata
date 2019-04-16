import java.text.MessageFormat;

public class Stock {

	private int[] stockPrices;

	private int maxProffit = 0;
	private int buyedBy = 0;

	public Stock(int... prices) {
		this.stockPrices = prices;
	}

	public void calculate() {

		for (int i = 0; i < stockPrices.length - 1; i++) {
			if (willPriceIncrease(i)) {
				if (!hasBuyed()) {
					buyedBy = buyStock(i);
				}
			} else {
				if (hasBuyed()) {
					sellStock(i);
				}
			}
		}

		if (hasBuyed()) {
			int lastIndex = stockPrices.length - 1;
			sellStock(lastIndex);
		}
	}

	private void sellStock(final int i) {
		int currentPrice = stockPrices[i];
		int proffit = currentPrice - buyedBy;
		maxProffit += proffit;
		buyedBy = 0;
		print("Vendi por {0} na iteração {1} e obtive lucro de {2} acumulando lucro de {3}",
				currentPrice, i, proffit, maxProffit);
	}

	private int buyStock(final int i) {
		int currentPrice = stockPrices[i];
		print("Comprou por {0} na iteração {1}", currentPrice, i);
		return currentPrice;
	}

	private boolean hasBuyed() {
		return buyedBy > 0;
	}

	private boolean willPriceIncrease(int i) {
		int currentPrice = stockPrices[i];
		int nexPrice = stockPrices[i + 1];
		return currentPrice < nexPrice;
	}

	private void print(final String message, Object... values) {
		System.out.println(MessageFormat.format(message, values));
	}

	public int getMaxProffit() {
		return maxProffit;
	}

}
