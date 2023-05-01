type Fn = (...params: any[]) => Promise<any>;

function timeLimit(fn: Fn, t: number): Fn {
  return async function (...args) {
    return Promise.race([
      fn(...args),
      new Promise((resolve, reject) => {
        setTimeout(() => { reject('Time Limit Exceeded'); }, t);
      })
    ]);
  };
}
