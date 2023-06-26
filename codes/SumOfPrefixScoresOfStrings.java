public class SumOfPrefixScoresOfStrings {
  // https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/
  public int[] sumPrefixScores(String[] words) {
    int[] result = new int[words.length];
    Trie trie = new Trie();
    for(int i = 0; i < words.length; i++) {
      trie.insertWord(words[i]);
    }

    for(int i = 0; i < words.length; i++) {
      result[i] = trie.findSumOfPrefixScores(words[i]);
    }
    return result;
  }

  class TrieNode {
    int freq;
    TrieNode[] children;

    public TrieNode() {
      freq = 0;
      children = new TrieNode[26];
    }
  }

  class Trie {
    private TrieNode dummyRoot;

    public Trie() {
      this.dummyRoot = new TrieNode();
    }

    public void insertWord(String word) {
      int sz = word.length();
      TrieNode root = dummyRoot;
      for(int i = 0; i < sz; i++) {
        char c = word.charAt(i);
        if(root.children[c - 'a'] == null) {
          root.children[c - 'a'] = new TrieNode();
        }
        root = root.children[c - 'a'];
        root.freq++;
      }
    }

    public int findSumOfPrefixScores(String word) {
      int sz = word.length();
      int sum = 0;
      TrieNode root = dummyRoot;
      for(int i = 0; i < sz; i++) {
        char c = word.charAt(i);
        if(root.children[c - 'a'] != null) {
          sum += root.children[c - 'a'].freq;
          root = root.children[c - 'a'];
        } else {
          break;
        }
      }
      return sum;
    }
  }
}
