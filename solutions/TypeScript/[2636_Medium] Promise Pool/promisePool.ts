type F = () => Promise<any>;

function promisePool(functions: F[], n: number): Promise<any> {
  return new Promise<void>((resolve) => {
    if (functions.length === 0) {
      return resolve();
    }

    let numberOfFunctionsInPool = 0;
    let numberOfFinishedFunctions = 0;
    let index = 0;

    const executeFunction = () => {
      while (numberOfFunctionsInPool < n && index < functions.length) {
        numberOfFunctionsInPool++;

        functions[index]().then(() => {
          numberOfFinishedFunctions++;
          numberOfFunctionsInPool--;

          if (numberOfFinishedFunctions === functions.length) {
            return resolve();
          }

          executeFunction();
        });

        index++;
      }
    };

    executeFunction();
  });
};
