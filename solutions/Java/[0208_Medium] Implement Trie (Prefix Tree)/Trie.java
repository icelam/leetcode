class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[26];
    isEnd = false;
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

  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}
