class Solution {
  public String simplifyPath(String path) {
    StringBuilder result = new StringBuilder();
    StringBuilder buffer = new StringBuilder();
    Deque<String> deque = new ArrayDeque<String>();

    for (int i = 0; i <= path.length(); i++) {
      if (i == path.length() || path.charAt(i) == '/') {
        if (buffer.toString().equals("..")) {
          deque.poll();
        } else if (buffer.length() > 0 && !buffer.toString().equals(".")) {
          deque.push(buffer.toString());
        }

        buffer.setLength(0);
      } else {
        buffer.append(path.charAt(i));
      }
    }

    while (!deque.isEmpty()) {
      result.append("/" + deque.removeLast());
    }

    return result.length() > 0 ? result.toString() : "/";
  }
}
