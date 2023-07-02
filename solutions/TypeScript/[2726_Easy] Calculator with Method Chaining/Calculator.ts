class Calculator {
  private result: number | Error;

  constructor(value : number) {
    this.result = value;
  }

  add(value : number) : Calculator {
    if (!(this.result instanceof Error)) {
      this.result += value;
    }

    return this;
  }

  subtract(value : number) : Calculator {
    if (!(this.result instanceof Error)) {
      this.result -= value;
    }

    return this;
  }

  multiply(value : number) : Calculator {
    if (!(this.result instanceof Error)) {
      this.result *= value;
    }

    return this;
  }

  divide(value : number) : Calculator {
    if (value === 0) {
      this.result = new Error('Division by zero is not allowed');
    } else if (!(this.result instanceof Error)) {
      this.result /= value;
    }

    return this;
  }

  power(value : number) : Calculator {
    if (!(this.result instanceof Error)) {
      this.result = Math.pow(this.result, value);
    }

    return this;
  }

  getResult() : number {
    if (this.result instanceof Error) {
      throw this.result;
    }

    return this.result;
  }
}
