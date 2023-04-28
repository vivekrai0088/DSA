import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/description/
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    if(!words.contains(endWord)) return 0;
    Set<String> visited = new HashSet<>();

    Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    visited.add(beginWord);

    int changes = 1;

    while(!queue.isEmpty()) {
      int sz = queue.size();
      for(int i = 0; i < sz; i++) {
        String word = queue.poll();
        if(word.equals(endWord)) return changes;

        for(int j = 0; j < word.length(); j++) {
          for(char ch = 'a'; ch <= 'z'; ch++) {
            char[] wordArray = word.toCharArray();
            wordArray[j] = ch;
            String possibleWord = new String(wordArray);
            if(words.contains(possibleWord) && !visited.contains(possibleWord)) {
              queue.add(possibleWord);
              visited.add(possibleWord);
            }
          }
        }
      }
      changes++;
    }
    return 0;
  }
}
