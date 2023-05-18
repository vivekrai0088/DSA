import java.util.TreeMap;

// https://leetcode.com/problems/stock-price-fluctuation/description/
public class StockPriceFluctuation {
  TreeMap<Integer, Integer> timeseriesMap;
  TreeMap<Integer, Integer> priceCount;

  public StockPriceFluctuation() {
    timeseriesMap = new TreeMap<>();
    priceCount = new TreeMap<>();
  }

  public void update(int timestamp, int price) {
    Integer previousPrice = timeseriesMap.get(timestamp);
    if(previousPrice != null) {
      priceCount.put(previousPrice, priceCount.getOrDefault(previousPrice, 0) - 1);
      if(priceCount.get(previousPrice) == 0) {
        priceCount.remove(previousPrice);
      }
    }

    timeseriesMap.put(timestamp, price);
    priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
  }

  public int current() {
    return timeseriesMap.get(timeseriesMap.lastKey());
  }

  public int maximum() {
    return priceCount.lastKey();
  }

  public int minimum() {
    return priceCount.firstKey();
  }
}
