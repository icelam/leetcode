class StringFormatter {
  public static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}

class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;
  private int index;

  public TrieNode() {
    links = new TrieNode[26];
    isEnd = false;
    index = -1;
  }

  public TrieNode getNode(char c) {
    return links[c - 'a'];
  }

  public void setNode(char c, TrieNode node) {
    links[c - 'a'] = node;
  }

  public boolean containsKey(char c) {
    return links[c - 'a'] != null;
  }

  public void setEnd() {
    isEnd = true;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setIndex(int i) {
    index = i;
  }

  public int getIndex() {
    return index;
  }
}

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word, int index) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      if (!node.containsKey(c)) {
        node.setNode(c, new TrieNode());
      }

      node = node.getNode(c);
    }

    node.setEnd();
    node.setIndex(index);
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      if (node.containsKey(c)) {
        node = node.getNode(c);
      } else {
        return null;
      }
    }

    return node;
  }

  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  private void traverseAndGetIndices(TrieNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    if (node.isEnd()) {
      list.add(node.getIndex());
    }

    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      if (node.containsKey(c)) {
        traverseAndGetIndices(node.getNode(c), list);
      }
    }
  }

  public List<Integer> getWordWithPrefix(String prefix) {
    TrieNode node = searchPrefix(prefix);
    List<Integer> list = new ArrayList<>();
    traverseAndGetIndices(node, list);

    return list;
  }
}

class WordFilter {
  private Trie trie;
  private String[] words;

  public WordFilter(String[] words) {
    this.trie = new Trie();

    for (int i = 0; i < words.length; i++) {
      this.trie.insert(words[i], i);
    }

    this.words = words;
  }

  public int f(String prefix, String suffix) {
    List<Integer> list = trie.getWordWithPrefix(prefix);

    Trie suffixTrie = new Trie();
    for (int index: list) {
      suffixTrie.insert(StringFormatter.reverse(words[index]), index);
    }

    List<Integer> result = suffixTrie.getWordWithPrefix(StringFormatter.reverse(suffix));

    int maxIndex = -1;
    for (int n: result) {
      maxIndex = Math.max(maxIndex, n);
    }

    return maxIndex;
  }
}
