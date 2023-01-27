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
    int numberOfConcatenation = 0;

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

  public TrieNode getRoot() {
    return root;
  }
}

class Solution {
  boolean dfs(TrieNode root, String word, int index, int count) {
    int wordLength = word.length();

    if (index >= wordLength) {
      return count > 1;
    }

    char[] characters = word.toCharArray();
    TrieNode node = root;

    for (int i = index; i < wordLength; i++) {
      char c = characters[i];
      if (!node.containsKey(c)) {
        return false;
      }

      node = node.getNode(c);

      if (node.isEnd()) {
        if (dfs(root, word, i + 1, count + 1)) {
          return true;
        }
      }
    }

    return false;
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> result = new ArrayList<>();
    Trie trie = new Trie();

    for (String w: words) {
      trie.insert(w);
    }

    for (int i = 0; i < words.length; i++) {
      if (dfs(trie.getRoot(), words[i], 0, 0)) {
        result.add(words[i]);
      }
    }

    return result;
  }
}
