class TrieNode {
  private TrieNode[] links;
  private boolean isStart;

  public TrieNode() {
    links = new TrieNode[26];
    isStart = false;
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

  public void setStart() {
    isStart = true;
  }

  public boolean isStart() {
    return isStart;
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


    for (int i = characters.length - 1; i >= 0; i--) {
      if (!node.containsKey(characters[i])) {
        node.setNode(characters[i], new TrieNode());
      }

      node = node.getNode(characters[i]);
    }

    node.setStart();
  }

  public TrieNode getSuffix(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    // return the node right after node 0
    for (int i = characters.length - 1; i >= 1; i--) {
      if (node.containsKey(characters[i])) {
        node = node.getNode(characters[i]);
      } else {
        return null;
      }
    }

    return node;
  }
}

class Solution {
  public long distinctNames(String[] ideas) {
    int n = ideas.length;
    long result = 0;
    int[][] dp = new int[26][26];
    Trie trie = new Trie();
    int[] startCount = new int[26];

    for (String idea: ideas) {
      trie.insert(idea);
      startCount[idea.charAt(0) - 'a']++;
    }

    for (int c1 = 0; c1 < 26; ++c1) {
      for (int c2 = 0; c2 < 26; ++c2) {
        dp[c1][c2] = startCount[c1];
      }
    }

    for (String idea : ideas) {
      TrieNode suffixNode = trie.getSuffix(idea);
      char c1 = idea.charAt(0);

      for (char c2 = 'a'; c2 <= 'z'; c2++) {
        TrieNode prefixNode = suffixNode.getNode(c2);

        if (prefixNode != null && prefixNode.isStart()) {
          dp[c1 - 'a'][c2 - 'a']--;
        }
      }
    }

    for (String idea : ideas) {
      TrieNode suffixNode = trie.getSuffix(idea);
      char c1 = idea.charAt(0);

      for (char c2 = 'a'; c2 <= 'z'; c2++) {
        TrieNode prefixNode = suffixNode.getNode(c2);

        if (prefixNode == null || !prefixNode.isStart()) {
          result += dp[c2 - 'a'][c1 - 'a'];
        }
      }
    }

    return result;
  }
}

