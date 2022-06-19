class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;
  private String word;

  public TrieNode() {
    links = new TrieNode[26];
    isEnd = false;
    word = "";
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

  public void setWord(String w) {
    word = w;
  }

  public String getWord() {
    return word;
  }
}

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      if (!node.containsKey(c)) {
        node.setNode(c, new TrieNode());
      }

      node = node.getNode(c);
    }

    node.setEnd();
    node.setWord(word);
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

  private void traverseAndGetWords(TrieNode node, List<String> list, int limit) {
    if (node == null || list.size() == limit) {
      return;
    }

    if (node.isEnd()) {
      list.add(node.getWord());
    }

    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      if (node.containsKey(c)) {
        traverseAndGetWords(node.getNode(c), list, limit);
      }
    }
  }

  public List<String> getWordWithPrefix(String prefix, int limit) {
    TrieNode node = searchPrefix(prefix);
    List<String> list = new ArrayList<>();
    traverseAndGetWords(node, list, limit);
    return list;
  }
}

class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    Trie trie = new Trie();
    for (String p: products) {
      trie.insert(p);
    }

    List<List<String>> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    char[] characters = searchWord.toCharArray();

    for (char c: characters) {
      sb.append(c);
      result.add(trie.getWordWithPrefix(sb.toString(), 3));
    }

    return result;
  }
}
