class BrowserHistory{
  class History{
    private String val;
    private History previous;
    private History next;

    public History(String val) {
      this.val = val;
    }
  }

  private History head;
  private History tail;
  private History pointer;

  public BrowserHistory(String homepage) {
    History newHistory = new History(homepage);
    head = newHistory;
    tail = newHistory;
    pointer = newHistory;
    head.previous = null;
    tail.next = null;
  }

  public void visit(String url) {
    History newHistory = new History(url);

    pointer.next = newHistory;
    newHistory.previous = pointer;
    tail = newHistory;
    tail.next = null;
    pointer = pointer.next;
  }

  public String back(int steps) {
    while (steps > 0 && pointer.previous != null) {
      pointer = pointer.previous;
      steps--;
    }

    return pointer.val;
  }

  public String forward(int steps) {
    while (steps > 0 && pointer.next != null) {
      pointer = pointer.next;
      steps--;
    }

    return pointer.val;
  }
}
