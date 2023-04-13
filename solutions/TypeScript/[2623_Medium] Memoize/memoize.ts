type Fn = (...params: any) => any

function memoize(fn: Fn): Fn {
  const memo = {};

  return function (...args) {
    const cacheKey = args.join(',');

    if (cacheKey in memo) {
      return memo[cacheKey];
    }

    const result = fn(...args);
    memo[cacheKey] = result;
    return result;
  };
}
