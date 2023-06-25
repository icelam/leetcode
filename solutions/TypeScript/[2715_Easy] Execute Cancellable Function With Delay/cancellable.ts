function cancellable(fn: Function, args: any[], t: number): Function {
  const timer = setTimeout(() => {
    fn(...args);
  }, t);

  return () => {
    clearTimeout(timer);
  };
}
