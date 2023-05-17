class TimeLimitedCache {
  private cache: Record<string, number>;

  private cacheTimer: Record<string, NodeJS.Timeout>;

  constructor() {
    this.cache = {};
    this.cacheTimer = {};
  }

  set(key: number, value: number, duration: number): boolean {
    const isCacheExists = !!this.cache[key];

    this.cache[key] = value;

    if (this.cacheTimer[key]) {
      clearTimeout(this.cacheTimer[key]);
    }

    this.cacheTimer[key] = setTimeout(() => {
      delete this.cache[key];
    }, duration);

    return isCacheExists;
  }

  get(key: number): number {
    return this.cache[key] || -1;
  }

  count(): number {
    return Object.keys(this.cache).length;
  }
}
