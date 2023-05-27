package trie;

import java.util.ArrayList;

class TrieImpl implements Trie {
  TrieNode root;

  public TrieImpl() {
    root = new TrieNode(false, 0);
  }

  public void insertSentence(String sentence, int freq) {
    TrieNode node = root;
    int sz = sentence.length();
    for(int i = 0; i < sz; i++) {
      int index = sentence.charAt(i);
//      System.out.print(index + " ");
      if(node.children[index] == null) {
        node.children[index] = new TrieNode(false, 0);
      }
      node = node.children[index];
    }
    node.isWord = true;
    node.freq = freq;
//    System.out.println();
  }

  public ArrayList<SentenceWithFreq> getAllSentences(String prefix) {
    TrieNode node = root;
    int sz = prefix.length();
    StringBuilder str = new StringBuilder();
    for(int i = 0; i < sz; i++) {
      int index = prefix.charAt(i);
      if(node.children[index] != null) {
        str.append(prefix.charAt(i));
        node = node.children[index];
      } else {
        break;
      }
    }
    ArrayList<SentenceWithFreq> allSentences = new ArrayList<>();
    if(str.length() == 0) return allSentences;
    dfs(node, str, allSentences);
    return allSentences;
  }

  public void dfs(TrieNode node, StringBuilder curSentence, ArrayList<SentenceWithFreq> result) {
//    System.out.println("currentSentence " + curSentence.toString());
    if(node.isWord) {
      SentenceWithFreq sentenceWithFreq = new SentenceWithFreq(curSentence.toString(), node.freq);
      result.add(sentenceWithFreq);
      return;
    }
    for(int i = 0; i < 200; i++) {
      if(node.children[i] != null) {
        curSentence.append((char)i);
        dfs(node.children[i], curSentence, result);
        curSentence.deleteCharAt(curSentence.length() - 1);
      }
    }
  }

  public TrieNode getRoot() {
    return this.root;
  }
}