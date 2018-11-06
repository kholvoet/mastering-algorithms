package com.mournival.algs4;

import edu.princeton.cs.algs4.StdOut;

public class Exercises01_01 {

	private static long count;

    public static void main(String[] args) {
		// Exercises
		ex1_1_1();

		// ex1_1_5(a, 0, 1) && ex1_1_5(b, 0, 1)
		// ...
		ex1_1_6();
		ex1_1_7();
		ex1_1_8();

		// ...
		// Creative Problems
		// ...
		ex1_1_27();

	}

	private static void ex1_1_1() {
		StdOut.println("Ex. 1.1.6");

		System.out.println("( 0 + 15 ) / 2 = " + (0 + 15) / 2);
		System.out.println("2.0E-6 * 100000000.1 = " + 2.0E-6 * 100000000.1);
		System.out.println("true && false || true && true = " + (true && false || true && true));

		StdOut.println();
	}

	@SuppressWarnings("unused")
	private boolean ex1_1_5(double a, double lo, double hi) {
		return lo < a && a < hi;
	}

	private static void ex1_1_6() {
		StdOut.println("Ex. 1.1.6");

		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}

		StdOut.println();
	}

	private static void ex1_1_7() {
		StdOut.println("Ex. 1.1.7");

		// a.
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > 0.001) {
			t = (9.0 / t + t) / 2.0;
		}
		StdOut.printf("%.5f\n", t);

		// b.
		int sum = 0;
		for (int i = 1; i < 1000; i++)
			for (int j = 0; j < i; j++)
				sum++;
		StdOut.println(sum);

		// c.
		sum = 0;
		for (int i = 1; i < 1000; i *= 2)
			for (int j = 0; j < i; j++)
				sum++;
		StdOut.println(sum);

		StdOut.println();
	}

	private static void ex1_1_8() {
		StdOut.println("Ex. 1.1.8");

		System.out.println('b'); // b
		System.out.println('b' + 'c'); // (int)
		System.out.println((char) ('a' + 4)); // e

		StdOut.println();
	}

	private static void ex1_1_27() {
		StdOut.println("Ex. 1.1.27");

		int n = 10;
		double p = 0.5;
		for (int i = 0; i < n + 1; ++i) {
			count = 0;
			double b = binomial(n, i, p);
			StdOut.printf("count = %6d,         binomial(%d, %d, %.2f) = %.15f\n", count, n, i, p, b);

			count = 0;
			b = improvedBinomial(n, i, p);
			StdOut.printf("count = %6d, improvedBinomial(%d, %d, %.2f) = %.15f\n", count, n, i, p, b);

		}
	}

	public static double binomial(int n, int k, double p) {
		++count;
		if ((n == 0) && (k == 0))
			return 1.0;
		if ((n < 0) || (k < 0))
			return 0.0;
		return (1 - p) * binomial(n - 1, k, p) - p * binomial(n - 1, k - 1, p);
	}

	public static double improvedBinomial(int n, int k, double p) {
		double memo[][] = new double[n + 1][k + 1];
		for (int x = 0; x < n + 1; ++x)
			for (int y = 0; y < k + 1; ++y)
				memo[x][y] = -2.0;
		memo[0][0] = 1;
		return memoizedBinomial(n, k, p, memo);
	}

	private static double memoizedBinomial(int n, int k, double p, double memo[][]) {
		++count;

		if ((n < 0) || (k < 0))
			return 0.0;

		if (memo[n][k] < -1.0) {
			memo[n][k] = (1 - p) * memoizedBinomial(n - 1, k, p, memo) - p * memoizedBinomial(n - 1, k - 1, p, memo);
		}

		return memo[n][k];
	}

}
