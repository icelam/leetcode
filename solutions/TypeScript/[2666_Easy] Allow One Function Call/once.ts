function once<T extends (...args: any[]) => any>(fn: T):
 ((...args: Parameters<T>) => ReturnType<T> | undefined) {
  let calls = 0;

  return function (...args) {
    if (calls < 1) {
      calls++;
      return fn(...args);
    }

    return undefined;
  };
}
