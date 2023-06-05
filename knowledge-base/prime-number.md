# 素数

## 入门

以下是一个简单的Java程序，用于找到给定数字之间的所有素数：

```java
import java.util.ArrayList;

public class PrimeNumbers {

  public static ArrayList<Integer> findPrimes(int n) {

    ArrayList<Integer> primes = new ArrayList<Integer>();

    for(int i = 2; i <= n; i++) {
        boolean isPrime = true;
        for(int j = 2; j < i; j++) {
            if(i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            primes.add(i);
        }
    }

    return primes;
  }

  public static void main(String[] args) {
    ArrayList<Integer> primes = findPrimes(100);
    System.out.println(primes);
  }
}
```

在这个程序中，我们接受一个数字n作为输入并返回一个ArrayList，其中包含所有小于或等于n的素数。

我们在外层循环中遍历从2到n的所有数字。我们定义一个布尔变量，表示当前数字是否为素数。

在内部循环中，我们遍历从2到i的所有数字，并判断i是否可以被它们整除。如果i可以被任何数字整除，我们将isPrime的值设置为false并退出内循环。

如果isPrime仍然为true，则说明i是素数，我们将其添加到primes ArrayList中。

最后，我们在main函数中调用findPrimes方法，将结果打印到控制台中。

请注意，此方法不是最快或最优秀的算法实现，但它是一个简单的入门级素数查找器。

## 优化

上面的代码虽然能找到小于或等于给定数字n的素数，但效率并不高，因为我们在内层循环中浪费了很多时间去判断不需要的数字。

有几种优化方法可以提高这个算法的效率：

1. 在内层循环中只需要考虑从2到i的平方根，因为如果存在大于i的因子，那么肯定至少有一个小于或等于i的平方根。

2. 对于每个素数p，只需要检查它的倍数，因为大于p的倍数肯定已经被先前的素数标记过了。

基于这些优化，下面是一个更高效的Java程序来找到小于或等于给定数字n的所有素数：

```java
import java.util.ArrayList;

public class PrimeNumbers {

    public static ArrayList<Integer> findPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        // 初始化isPrime数组，将所有元素初始化为true
        for(int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 从2开始，枚举所有素数（从小到大）
        for(int p = 2; p <= n; p++) {
            if(isPrime[p]) {
                primes.add(p);
                
                // 将所有p的倍数标记为非素数
                for(long i = (long)p * p; i <= n; i += p) {
                    isPrime[(int)i] = false;
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = findPrimes(100);
        System.out.println(primes);
    }
}
```

这个算法的主要优化点是：

1. 使用数组isPrime来跟踪每个数字是否为素数。我们首先将所有元素初始化为true。然后，在找到素数p时，我们将所有p的倍数标记为false，这样我们可以避免在内层循环中检查不必要的数字。

2. 在内层循环中，我们只检查p的平方和p的倍数，这样我们就能降低时间复杂度。

## 上述优化的进一步解释

当我们使用素数筛选法来查找小于等于20的所有素数时，我们可以一步步推演这两个优化方法的应用和效果。

首先，我们初始化一个布尔数组isPrime，用于存储每个数字是否为素数。将除1以外的所有数字都设置为true，表示它们是素数（1不是素数）：

```
isPrime = {false, true, true, true, true, true, true, true, true, true,
           true, true, true, true, true, true, true, true, true, true};
```

然后，我们使用2到n的数字来循环查找素数：

```
for (int i = 2; i <= n; i++) {
    ...
}
```

在循环的开始，我们假设当前数字i为素数，并设置一个标记isPrime为true。

然后，我们进入内层循环，用2到i-1的数字来检查i是否为素数：

```
for (int j = 2; j < i; j++) {
    if (i % j == 0) {
        isPrime[i] = false; // 如果i有因子，则将其标记为非素数
        break; // 并退出内层循环
    }
}
```

如果i有因数，则它不是素数，我们将isPrime[i]标记为false，表示它不是素数。然后我们退出内层循环。

有了第一个优化方法，我们需要仅仅考虑从2到i的平方根，而不是从2到i-1：

```
for (int j = 2; j <= Math.sqrt(i); j++) {
    if (i % j == 0) {
        isPrime[i] = false;
        break;
    }
}
```

因为如果i有一个大于它平方根的因子，那么它肯定也有一个小于或等于i平方根的因子。因此，我们只需要检查从2到i的平方根是否为因子，就可以确定i是否为素数。

有了第二个优化方法，我们需要仅仅检查素数的倍数，而不是检查所有数字：

```
for (int i = 2; i <= n; i++) {
    if (isPrime[i]) { // 如果i是素数，则将其所有倍数标记为非素数
        for (int j = i*2; j <= n; j += i) {
            isPrime[j] = false;
        }
    }
}
```

当我们找到一个素数i时，我们可以将它的所有倍数标记为非素数。例如，当我们找到2时，我们可以将4，6，8，10等所有偶数（除2以外）标记为非素数。同样地，当我们找到3时，我们可以将9，12，15，18等所有3的倍数标记为非素数。因为一个合数至少有一个小于或等于它平方根的质因子，所以对于大于i的倍数，它们的最小质因子都小于i。因此，我们只需要检查素数的倍数，而不需要检查所有数字。

经过这两个优化方法的改进，我们可以更高效地查找小于等于n的所有素数。