function* fibGenerator(): Generator<number, any, number> {
  let current = 0;
  let next = 1;

  while (true) {
    yield current;
    const newNext = current + next;
    current = next;
    next = newNext;
  }
}
