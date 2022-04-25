// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  private Iterator<Integer> iterator;
  private Integer nextElement;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    this.nextElement = iterator.next();
  }

  public Integer peek() {
    return nextElement;
  }

  @Override
  public Integer next() {
    int result = nextElement;

    if (iterator.hasNext()) {
      nextElement = iterator.next();
    } else {
      nextElement = null;
    }

    return result;
  }

  @Override
  public boolean hasNext() {
    return nextElement != null;
  }
}
