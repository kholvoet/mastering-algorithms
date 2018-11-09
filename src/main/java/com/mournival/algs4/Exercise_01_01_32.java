/*
 ****************************************************************************
 *
 * Copyright (c)2018 The Vanguard Group of Investment Companies (VGI)
 * All rights reserved.
 *
 * This source code is CONFIDENTIAL and PROPRIETARY to VGI. Unauthorized
 * distribution, adaptation, or use may be subject to civil and criminal
 * penalties.
 *
 ****************************************************************************
 Module Description:

 $HeadURL:$
 $LastChangedRevision:$
 $Author:$
 $LastChangedDate:$
*/
package com.mournival.algs4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise 1.1.32 Histogram. Suppose that the standard input stream is a sequence double
 * values. Write a program that takes an integer N ans two double values lo and
 * hi from the command line and uses StdDraw to plot a histogram of the count of
 * the numbers in the standard input stream that fall in each of the n intervals
 * defined by dividing (lo, hi) into n equal sized buckets.
 * 
 * @author Kristian Holvoet
 *
 */
public class Exercise_01_01_32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		double lo;
		double hi;

		/*
		 * double[] input = StdIn.readAllDoubles();
		 */
		double[] input = new double[100000];
		for (int i = 0; i < 100000; ++i) {
			input[i] = StdRandom.uniform() ;
		}
		Exercise_01_01_32 ex = new Exercise_01_01_32();
		// ex.plotHistogram(n, lo, hi, input);

		ex.plotHistogram(100, 0, 1, input);
	}

	void plotHistogram(int n, double lo, double hi, double[] input) {

		double a[] = new double[n];
		for (int i = 0; i < input.length; ++i) {
			if (input[i] > lo && input[i] < hi) {
				int j = hash(input[i], n, lo, hi);
				++a[j];
			}
		}
		
		StdDraw.setYscale(0, Arrays.stream(a).max().orElse(n) +1);

		for (int i = 0; i < n; ++i) {
			double x = 1.0 * i / n;
			double y = a[i] / 2.0;
			double rw = 0.5 / n;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}

	}

	private int hash(double d, int n, double lo, double hi) {
		double band = (hi - lo) / n;
		for (int i = 1; i <= n; ++i) {
//			StdOut.println( lo + band * i);
			if (d <= lo + band * i) {
				return i - 1;
			}
		}
		throw new IllegalStateException();
	}

}
