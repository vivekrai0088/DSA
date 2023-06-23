// https://leetcode.com/problems/alphabet-board-path/description/
public class AlphabeticBoardPath {
  public String alphabetBoardPath(String target) {
    int x = 0, y = 0;
    StringBuilder path = new StringBuilder();

    for(char c : target.toCharArray()) {
      int x1 = (c - 'a') / 5;
      int y1 = (c - 'a') % 5;

      while (x1 < x) {x--; path.append('U');}
      while (y1 > y) {y++; path.append('R');}
      while (y1 < y) {y--; path.append('L');}
      while (x1 > x) {x++; path.append('D');}
      path.append('!');
    }
    return path.toString();
  }
}
