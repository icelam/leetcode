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

  public TrieNode getRoot(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      if (!node.containsKey(c)) {
        break;
      }

      node = node.getNode(c);

      if (node.isEnd()) {
        return node;
      }
    }

    return null;
  }
}


class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {
    StringBuilder builder = new StringBuilder();
    Trie trie = new Trie();

    for (String key: dictionary) {
      trie.insert(key);
    }

    for (String word: sentence.split(" ")) {
      if (builder.length() > 0) {
        builder.append(' ');
      }

      TrieNode root = trie.getRoot(word);
      builder.append(root != null ? root.getWord() : word);
    }

    return builder.toString();
  }
}
