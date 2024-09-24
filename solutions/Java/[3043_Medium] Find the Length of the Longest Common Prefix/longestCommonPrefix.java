class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[10];
    isEnd = false;
  }

  public TrieNode getNode(char c) {
    return links[c - '0'];
  }

  public void setNode(char c, TrieNode node) {
    links[c - '0'] = node;
  }

  public boolean containsKey(char c) {
    return links[c - '0'] != null;
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

  public void insert(int num) {
    TrieNode node = root;
    char[] characters = Integer.toString(num).toCharArray();

    for (char c: characters) {
      if (!node.containsKey(c)) {
        node.setNode(c, new TrieNode());
      }

      node = node.getNode(c);
    }

    node.setEnd();
  }

  public int getMaxCommonPrefixLength(int num) {
    TrieNode node = root;
    int length = 0;

    for (char c: Integer.toString(num).toCharArray()) {
      if (!node.containsKey(c)) {
        break;
      }

      length++;
      node = node.getNode(c);
    }

    return length;
  }
}

class Solution {
  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    Trie trie = new Trie();

    for (int num1: arr1) {
      trie.insert(num1);
    }

    int result = 0;

    for (int num2 : arr2) {
      result = Math.max(result, trie.getMaxCommonPrefixLength(num2));
    }

    return result;
  }
}

