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

  public TrieNode getRoot() {
    return root;
  }
}

class Solution {
  public int minExtraChar(String s, String[] dictionary) {
    Trie trie = new Trie();

    for (String word: dictionary) {
      trie.insert(word);
    }

    TrieNode root = trie.getRoot();

    char[] characters = s.toCharArray();
    int n = characters.length;
    int[] dp = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
      dp[i] = dp[i + 1] + 1;
      TrieNode node = root;

      for (int j = i; j < n; j++) {
        if (!node.containsKey(characters[j])) {
          break;
        }

        node = node.getNode(characters[j]);

        if (node.isEnd()) {
          dp[i] = Math.min(dp[i], dp[j + 1]);
        }
      }
    }

    return dp[0];
  }
}
