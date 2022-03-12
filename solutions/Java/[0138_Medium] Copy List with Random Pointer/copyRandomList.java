/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<Node, Node>();
    Node current = head;
    Node clonedHead = new Node(0);
    Node cloned = clonedHead;

    while (current != null) {
      Node newNode = map.containsKey(current) ? map.get(current) : null;
      if (!map.containsKey(current)) {
        newNode = new Node(current.val);
        map.put(current, newNode);
      }
      cloned.next = newNode;

      Node newRandom = map.containsKey(current.random) ? map.get(current.random) : null;
      if (current.random != null && !map.containsKey(current.random)) {
        newRandom = new Node(current.random.val);
        map.put(current.random, newRandom);
      }
      cloned.next.random = newRandom;

      cloned = cloned.next;
      current = current.next;
    }

    return clonedHead.next;
  }
}
