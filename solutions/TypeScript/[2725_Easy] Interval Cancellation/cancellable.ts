function cancellable(fn: Function, args: any[], t: number): Function {
  fn(...args);

  const timer = setInterval(() => {
    fn(...args);
  }, t);

  return () => {
    clearInterval(timer);
  };
}
