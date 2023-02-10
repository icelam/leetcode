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

    for (String idea : ideas) {
      TrieNode suffixNode = trie.getSuffix(idea);
      char c1 = idea.charAt(0);

      for (char c2 = 'a'; c2 <= 'z'; c2++) {
        TrieNode prefixNode = suffixNode.getNode(c2);

        // If a + b is valid, then b + a is also valid
        // So if any b + a is valid, get count of a + b * 2 will be the result
        // e.g. ["coffee","donuts","time","toffee"]
        // 1. donuts + coffee -> result += 1 * 2, as we add 1 to dp['c']['d'] when checking idea "coffee" with replaced preifx 'd'
        // 2. time + donuts -> result += 1 * 2, as we add 1 to dp['d']['t'] when checking idea "donuts" with replaced preifx 't
        // 3. toffee + donuts -> result += 1 * 2, dp['d']['t'] has been seen before in step 2, it remains at 1, so we will also add result += 1 * 2
        // Final result = 6
        if (prefixNode == null || !prefixNode.isStart()) {
          dp[c1 - 'a'][c2 - 'a']++;
          result += dp[c2 - 'a'][c1 - 'a'] * 2;
        }
      }
    }

    return result;
  }
}
