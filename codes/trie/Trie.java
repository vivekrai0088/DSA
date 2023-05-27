package trie;

import java.util.ArrayList;

interface Trie {
  void insertSentence(String sentence, int freq);

  ArrayList<SentenceWithFreq> getAllSentences(String prefix);
}