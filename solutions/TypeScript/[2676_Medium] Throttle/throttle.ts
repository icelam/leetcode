type F = (...args: any[]) => void

function throttle(fn: F, t: number): F {
  let shouldWait = false;
  let waitingArgs: any[] | null = null;

  const timeoutFunc = () => {
    if (!waitingArgs) {
      shouldWait = false;
    } else {
      fn(...waitingArgs);
      waitingArgs = null;
      setTimeout(timeoutFunc, t);
    }
  };

  return (...args) => {
    if (shouldWait) {
      waitingArgs = args;
      return;
    }

    fn(...args);
    shouldWait = true;
    setTimeout(timeoutFunc, t);
  };
}
