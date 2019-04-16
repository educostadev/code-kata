import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock {

	private List<Integer> stockPrices = new ArrayList<>();

	private int maxProffit = 0;

	public Stock(int... prices) {
		Arrays.stream(prices).forEach(price -> stockPrices.add(price));
	}

	public void calculate() {
		int buyed = 0;
		for (int i = 0; i < stockPrices.size()-1; i++) {
			int currentPrice = stockPrices.get(i);
			int nexPrice = stockPrices.get(i + 1);
			if (currentPrice < nexPrice) {
				//Ação irá subir
				if (buyed == 0) { //se nao comprei ainda devo comprar
					buyed = currentPrice;
					print("Comprou por {0} na iteração {1}", currentPrice, i);
				}
			} else {
				//Ação irá cair ou o preço se manterá
				if (buyed > 0) { //se ja comprei devo vender para lucrar
					int proffit = currentPrice - buyed;
					maxProffit += proffit;
					buyed = 0;
					print("Vendi por {0} na iteração {1} e obtive lucro de {3} acumulando lucro de {4}",
							currentPrice, i, proffit, maxProffit);
				}
			}
		}
	}

	private void print(final String message, Object... values) {
		System.out.println(MessageFormat.format(message, values));
	}

	public int getMaxProffit() {
		return maxProffit;
	}

}
