import java.util.ArrayList;
import java.util.List;

public class PascalTriangleSecond {
  private ArrayList<Integer> generateRow(ArrayList<Integer> row) {
    ArrayList<Integer> result = new ArrayList<>();

    result.add(1);
    for(int i = 0; i < row.size() - 1; i++) {
      result.add(row.get(i) + row.get(i + 1));
    }
    result.add(1);
    return result;
  }

  public List<Integer> getRow(int rowIndex) {
    ArrayList<Integer> row = new ArrayList<>();
    row.add(1);

    if(rowIndex == 0) {
      return row;
    }

    ArrayList<Integer> nextRow = new ArrayList<Integer>();
    for(int i = 1; i <= rowIndex; i++) {
      nextRow = generateRow(row);
      row = nextRow;
    }
    return nextRow;
  }
}
