import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
  String account;
  Integer spentAmount;

  public Pair(String account, Integer spentAmount) {
    this.account = account;
    this.spentAmount = spentAmount;
  }

  public int compareTo(Pair o2) {

    int spentComparison = this.spentAmount.compareTo(o2.spentAmount);
    if(spentComparison != 0) {
      return spentComparison;
    } else {
      return o2.account.compareTo(this.account);
    }
  }
}

public class PracticeTreeMap {

  public void run() {
    Map<Pair, Integer> spentMap = new TreeMap<>();
    spentMap.put(new Pair("accountone", 10), 1);
    spentMap.put(new Pair("accounttwo", 10), 1);
    spentMap.put(new Pair("accountthree", 20), 1);
    spentMap.put(new Pair("accountfour", 30), 1);

    System.out.println(spentMap.size());

    for(Map.Entry<Pair, Integer> entry : spentMap.entrySet()) {
      System.out.println(entry.getKey().account + " " + entry.getKey().spentAmount);
    }

  }

  public static void main(String[] args) {
    new PracticeTreeMap().run();
  }
}
