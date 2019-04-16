import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock {

	private List<Integer> stockPrices = new ArrayList<>();

	public Stock(int... prices) {
		Arrays.stream(prices).forEach(price -> stockPrices.add(price));
	}

	public int getMaxProffit(){
		return 0;
	}

}
