class WordDictionary {
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

  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
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

  private boolean dfs(char[] characters, int index, TrieNode node) {
    if (index == characters.length) {
      return node.isEnd();
    }

    char c = characters[index];

    if (c == '.') {
      for (char wildcard = 'a'; wildcard <= 'z'; wildcard++) {
        if (node.containsKey(wildcard) && dfs(characters, index + 1, node.getNode(wildcard))) {
          return true;
        }
      }
    } else if (node.containsKey(c) && dfs(characters, index + 1, node.getNode(c))) {
      return true;
    }

    return false;
  }

  public boolean search(String word) {
    return dfs(word.toCharArray(), 0, root);
  }
}
