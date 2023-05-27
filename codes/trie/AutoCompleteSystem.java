package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AutoCompleteSystem {
  static Trie trie;

  public AutoCompleteSystem(String[] sentences, int[] times) {
    trie = new TrieImpl();
    for (int i = 0; i < sentences.length; i++) {
      trie.insertSentence(sentences[i], times[i]);
    }
  }

  public static List<String> input(char c) {
    if (c == '#') return new ArrayList<>();

    ArrayList<SentenceWithFreq> allSentences = trie.getAllSentences(String.valueOf(c));
    PriorityQueue<SentenceWithFreq> priorityQueue = new PriorityQueue<>(allSentences);

    List<String> result = new ArrayList();
    int count = 3;
    while (!priorityQueue.isEmpty() && count > 0) {
      result.add(priorityQueue.poll().sentence);
      count--;
    }
    return result;
  }

  public static void main(String[] args) {
    String[] sentences = new String[]{"i want to join faang", "ice cream", "i love coding ninjas"};
    int[] times = new int[]{4, 3, 1};
    AutoCompleteSystem autoCompleteSystem = new AutoCompleteSystem(sentences, times);

    List<String> sentencesList = autoCompleteSystem.input('p');
    for(int i = 0; i < sentencesList.size(); i++) {
      System.out.println(sentencesList.get(i));
    }

  }
}
