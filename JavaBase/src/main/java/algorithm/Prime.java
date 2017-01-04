package algorithm;

//质数（prime number）又称素数，有无限个,质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数的数称为质数
public class Prime {
	public static void main(String[] args) {
		Prime p = new Prime();
		// p.findPrimes(30);
		p.findPrimes(100);
		System.out.println();
		System.out.println(isPrime(89));
	}

	static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2, half = n / 2; i <= half; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void findPrimes(int n) {
		boolean[] primes = new boolean[n + 1];// 下标最大到n
		primes[0] = primes[1] = false;
		for (int i = 0; i <= n; i++) {
			primes[i] = true;
		}

		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				for (int j = 2; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		System.out.println(n + "之前的素数有:");
		for (int i = 2; i <= n; i++) {
			if (primes[i])
				System.out.print(i + ",");
		}
	}

}
