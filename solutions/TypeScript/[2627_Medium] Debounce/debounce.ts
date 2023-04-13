type F = (...p: any[]) => any

function debounce(fn: F, t: number): F {
  let debounceTimer: ReturnType<typeof setTimeout>;
  return function (...args) {
    const context = this;
    clearTimeout(debounceTimer);
    debounceTimer = setTimeout(() => fn.apply(context, args), t);
  };
}
