// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator<E> implements Iterator<E> {
  private Iterator<E> iterator;
  private E nextElement;

  public PeekingIterator(Iterator<E> iterator) {
    this.iterator = iterator;
    this.nextElement = iterator.next();
  }

  public E peek() {
    return nextElement;
  }

  @Override
  public E next() {
    E result = nextElement;

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
