class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;
  private int score;

  public TrieNode() {
    links = new TrieNode[26];
    isEnd = false;
    score = 0;
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

  public void incrementScore() {
    score++;
  }

  public int getScore() {
    return score;
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
      node.incrementScore();
    }

    node.setEnd();
  }

  public TrieNode getRoot() {
    return root;
  }
}

class Solution {
  public int[] sumPrefixScores(String[] words) {
    int n = words.length;
    Trie trie = new Trie();

    for (String word : words) {
      trie.insert(word);
    }

    int[] result = new int[n];

    for (var i = 0; i < n; ++i) {
      TrieNode currentNode = trie.getRoot();

      for (var c: words[i].toCharArray()) {
        currentNode = currentNode.getNode(c);
        result[i] += currentNode.getScore();
      }
    }

    return result;
  }
}
