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

  public TrieNode getRoot() {
    return root;
  }
}

class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private void dfs(char[][] board, int height, int width, int row, int column, TrieNode trieNode, Set<String> result) {
    if (!isValidPosition(row, column, height, width)) {
      return;
    }

    if (board[row][column] == '.') {
      return;
    }

    char currentChar = board[row][column];
    TrieNode currentTrieNode = trieNode.getNode(currentChar);
    board[row][column] = '.';

    if (currentTrieNode != null) {
      if (currentTrieNode.isEnd()) {
        result.add(currentTrieNode.getWord());
      }

      for (int[] d: directions) {
        dfs(board, height, width, row + d[0], column + d[1], currentTrieNode, result);
      }
    }

    board[row][column] = currentChar;
  }

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    int height = board.length;
    int width = board[0].length;

    for (String w: words) {
      trie.insert(w);
    }

    Set<String> result = new HashSet<>();

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        dfs(board, height, width, row, column, trie.getRoot(), result);
      }
    }

    return new ArrayList<String>(result);
  }
}
