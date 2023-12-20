class Foo {
  private volatile int doneCount = 0;

  public Foo() { }

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    doneCount++;
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (doneCount < 1) {
      Thread.onSpinWait();
    }
    printSecond.run();
    doneCount++;
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (doneCount < 2) {
      Thread.onSpinWait();
    }
    printThird.run();
  }
}
