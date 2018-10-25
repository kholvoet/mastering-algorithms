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
		ex1_1_26();

	}

	private static void ex1_1_1() {
		StdOut.println("Ex. 1.1.6");

		System.out.println("( 0 + 15 ) / 2 = " + (0 + 15) / 2);
		System.out.println("2.0E-6 * 100000000.1 = " + 2.0E-6 * 100000000.1);
		System.out.println("true && false || true && true = " + (true && false || true && true));

		StdOut.println();
	}

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

	private static void ex1_1_26() {
		StdOut.println("Ex. 1.1.26");

		count = 0;
		StdOut.printf("binomial(10, 5, 0.25) = %.15f\n", binomial(10, 5, 0.25));
		StdOut.println(count);

//		count = 0;
//		StdOut.printf("binomial(20, 10, 0.25) = %.15f\n", binomial(20, 10, 0.25));
//		StdOut.println(count);
//
//		count = 0;
//		StdOut.printf("binomial(30, 15, 0.25) = %.15f\n", binomial(30, 15, 0.25));
//		StdOut.println(count);
		
		count = 0;
		StdOut.printf("improvedBinomial(10, 5, 0.25) = %.15f\n", improvedBinomial(10, 5, 0.25, new double[11][11]));
		StdOut.println(count);

		count = 0;
//		StdOut.printf("improvedBinomial(20, 10, 0.25) = %.15f\n", improvedBinomial(20, 10, 0.25, new double[21][21]));
//		StdOut.println(count);
//
//		count = 0;
//		StdOut.printf("improvedBinomial(30, 15, 0.25) = %.15f\n", improvedBinomial(30, 15, 0.25, new double[31][31]));
//		StdOut.println(count);
//
//		count = 0;
//		StdOut.printf("improvedBinomial(50, 22, 0.25) = %.15f\n", improvedBinomial(50, 22, 0.25, new double[51][51]));
//		StdOut.println(count);

		count = 0;
		StdOut.printf("improvedBinomial(50, 25, 0.25) = %.15f\n", improvedBinomial(50, 25, 0.25, new double[51][51]));
		StdOut.println(count);
		
//		count = 0;
//		StdOut.printf("improvedBinomial(50, 28, 0.25) = %.15f\n", improvedBinomial(50, 28, 0.25, new double[51][51]));
//		StdOut.println(count);
	}

	public static double binomial(int n, int k, double p) {
		++count;
		if ((n == 0) && (k == 0))
			return 1.0;
		if ((n < 0) || (k < 0))
			return 0.0;
		return (1 - p) * binomial(n - 1, k, p) - p * binomial(n - 1, k - 1, p);
	}

	public static double improvedBinomial(int n, int k, double p, double precalc[][]) {
		++count;

		if ((n == 0) && (k == 0))
			return 1.0;

		if ((n < 0) || (k < 0))
			return 0.0;
		
		if (precalc[n][k] == 0.0) {
			precalc[n][k] = (1 - p) * improvedBinomial(n - 1, k, p, precalc)
					- p * improvedBinomial(n - 1, k - 1, p, precalc);
		}

		return precalc[n][k];
	}

}
