async function promiseAll<T>(functions: (() => Promise<T>)[]): Promise<T[]> {
  return new Promise((resolve, reject) => {
    const result: (T | null)[] = [];
    const nunberOfPromiseToResolve = functions.length;
    let numberOfResolvedPromise = 0;

    functions.forEach(async (func, index) => {
      result.push(null);

      try {
        const value = await func();
        result[index] = value;
        numberOfResolvedPromise++;

        if (numberOfResolvedPromise === nunberOfPromiseToResolve) {
          resolve(result as T[]);
        }
      } catch (error) {
        reject(error);
      }
    });
  });
}
