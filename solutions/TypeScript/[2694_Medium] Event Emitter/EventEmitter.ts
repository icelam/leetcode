type Callback = (...args: any[]) => any;

type Subscription = {
    unsubscribe: () => void
}

class EventEmitter {
  private callbackMap: Record<string, (Callback | null)[]>;

  constructor() {
    this.callbackMap = {};
  }

  subscribe(eventName: string, callback: Callback): Subscription {
    if (!this.callbackMap[eventName]) {
      this.callbackMap[eventName] = [];
    }

    const callbackIndex = this.callbackMap[eventName].length;
    this.callbackMap[eventName].push(callback);

    return {
      unsubscribe: () => {
        this.callbackMap[eventName][callbackIndex] = null;
      }
    };
  }

  emit(eventName: string, args: any[] = []): any {
    const result: any[] = [];

    this.callbackMap[eventName]?.forEach((callback) => {
      if (callback) {
        result.push(callback(...args));
      }
    });

    return result;
  }
}
