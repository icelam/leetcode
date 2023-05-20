declare global {
    interface Function {
      callPolyfill(context: Record<any, any>, ...args: any[]): any;
  }
}

Function.prototype.callPolyfill = function(context, ...args): any {
  return this.apply(context, args);
}
