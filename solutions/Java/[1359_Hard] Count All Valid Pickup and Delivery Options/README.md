# 1359. Count All Valid Pickup and Delivery Options

For this problem, it can be solved by simple probability calculation. 

## Examples

```
n = 1

Probablity that P is before D: 
1 / 2 = 0.5

Number of combination: 
(2n)! = 2

Result: 
(2 * 1)! * 0.5 = 2 * 0.5 = 1
```

```
n = 2

Probablity that all 2 P is before all 2 D: 
(1 / 2) ^ 2 = 0.25

Number of combination: 
(2n)! = 24

Result: 
(2 * 2)! * 0.25 = 24 * 0.25 = 6
```

```
n = 3

Probablity that all 3 P is before all 3 D: 
(1 / 2) ^ 3 = 0.125

Number of combination: 
(2n)! = 720

Result: 
(2 * 3)! * 0.125 = 720 * 0.125 = 90
```

## Solution
Above examples can be conclude as `Number of combination / Probablity of all P happens before D` => `(2 * n)! / 2 ^ n`.

The hardest part of this question is that a 32-bit fixed point can only handle maximum factorial `12!`. To have the program able to handle `1 <= n <= 500`, we have to simplify the equation:

```
(n / √2) *  (n - 1 / √2) * (n - 2 / √2) * ... * (1 / √2)
```

Note that √2 means we only divide the value by 2 for n times on 2n number of items. And the final code becomes:

```java
class Solution {
  public int countOrders(int n) {
    double result = 1;
    int mod = (int) Math.pow(10, 9) + 7;

    for (int i = 1; i <= 2 * n; i++) {
      result = (result * i / (i <= n ? 2 : 1)) % mod;
    }

    return (int) (result);
  }
}
```
