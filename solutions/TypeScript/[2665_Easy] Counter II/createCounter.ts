type ReturnObj = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): ReturnObj {
  const originalNumber = init;
  let currentNumber = init;

  return {
    increment: () => {
      currentNumber++;
      return currentNumber;
    },
    decrement: () => {
      currentNumber--;
      return currentNumber;
    },
    reset: () => {
      currentNumber = originalNumber;
      return currentNumber;
    }
  };
}
