// Q1: Sort an array of Strings based on ASCENDING Order of the length of element.
//Input: [“ABCDE”, “ABCD”, “Z”, “A”, “AB”, “AA”, “ABC”]
//Output: [“A”, “Z”, “AA”, “AB”, “ABC”, “ABCD”, “ABCDE”]

import java.util.PriorityQueue;

public class AgodaQuestion {

  class Word implements Comparable<Word> {
    String word;
    Integer length;

    public Word(String word, Integer length) {
      this.word = word;
      this.length = length;
    }

    public int compareTo(Word w1) {
      if(!this.length.equals(w1.length)) {
        return this.length - w1.length;
      } else {
        return this.word.compareTo(w1.word);
      }
    }
  }

  private void run() {
    String[] words = new String[]{"ABCDE", "ABCD", "Z", "A", "AB", "AA", "ABC"};

    PriorityQueue<Word> priorityQueue = new PriorityQueue<>();
    for(int i = 0; i < words.length; i++) {
      priorityQueue.add(new Word(words[i], words[i].length()));
    }

    while(!priorityQueue.isEmpty()) {
      Word word = priorityQueue.poll();
      System.out.println(word.word);
    }
  }

  public static void main(String[] args) {
    new AgodaQuestion().run();
  }
}
