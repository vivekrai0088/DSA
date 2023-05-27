package trie;

class SentenceWithFreq implements Comparable<SentenceWithFreq> {
  String sentence;
  int freq;

  public SentenceWithFreq(String sentence, int freq) {
    this.sentence = sentence;
    this.freq = freq;
  }

  public int compareTo(SentenceWithFreq obj) {
    if(this.freq != obj.freq) {
      return obj.freq - this.freq;
    }
    return this.sentence.compareTo(obj.sentence);
  }
}