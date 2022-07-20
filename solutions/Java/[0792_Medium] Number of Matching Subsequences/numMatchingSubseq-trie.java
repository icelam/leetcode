class TrieNode {
  private TrieNode link;
  private char character;
  private boolean isEnd;

  public TrieNode(char c) {
    character = c;
    isEnd = false;
  }

  public TrieNode getChild() {
    return link;
  }

  public void setChild(TrieNode child) {
    link = child;
  }

  public boolean containsChild(char c) {
    return link != null && link.character == c;
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
  private HashMap<String, Boolean> memo;

  public Trie() {
    root = new TrieNode(' ');
    memo = new HashMap<String, Boolean>();
  }

  public void insert(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      node.setChild(new TrieNode(c));
      node = node.getChild();
    }

    node.setEnd();
  }

  private TrieNode searchSubsequencePrefix(String word) {
    TrieNode node = root;
    char[] characters = word.toCharArray();

    for (char c: characters) {
      while (node != null) {
        boolean isCharacterMatch = node.containsChild(c);
        node = node.getChild();
        if (isCharacterMatch) {
          break;
        }
      }
    }

    return node;
  }

  public boolean containsSubsequencePrefix(String word) {
    if (!memo.containsKey(word)) {
      TrieNode node = searchSubsequencePrefix(word);
      boolean hasSubsequencePrefix = node != null;
      memo.put(word, hasSubsequencePrefix);
      return hasSubsequencePrefix;
    }

    return memo.get(word);
  }
}

class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    Trie trie = new Trie();
    trie.insert(s);

    int result = 0;

    for (String w: words) {
      result += trie.containsSubsequencePrefix(w) ? 1 : 0;
    }

    return result;
  }
}
