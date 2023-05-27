package trie;

public class TrieNode {
  boolean isWord;
  int freq;
  TrieNode[] children;

  public TrieNode(boolean isWord, int freq) {
    this.isWord = isWord;
    this.freq = freq;
    children = new TrieNode[200];
    for(int i = 0; i < 200; i++) {
      children[i] = null;
    }
  }
}