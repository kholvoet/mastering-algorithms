package com.mournival.algs4;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Random connections. Write a program that takes as command-line arguments an
 * integer N and a double value p (between 0 and 1), plots N equally spaced dots
 * of size .05 on the circumference of a circle, and then, with probability p
 * for each pair of points, draws a gray line connecting them.
 *
 * @author Kristian Holvoet
 *
 */
public class Exercise_01_31 {

	private static final double DOT_SIZE = 0.05;
	private static final Color LINE_COLOR = Color.gray;
	private static final int CANVAS_SIZE = 1024;
	private static final double LINE_THICKNESS = 0.0002;

	public static void main(String[] args) {
		StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
		StdDraw.setScale(0, CANVAS_SIZE);
		
		int n = Integer.parseInt(args[0]);
		double alpha = 2.0 * Math.PI / n;
		int r = CANVAS_SIZE / 2 - 2;
		double center = CANVAS_SIZE / 2; 
		plotPoints(n, center, r, alpha);
		
		double p = Double.parseDouble(args[1]);
		plotLines(n, center, r, alpha, p);
	}

	private static void plotLines(int n, double center, int r, double alpha, double p) {
		StdDraw.setPenColor(LINE_COLOR);
		StdDraw.setPenRadius(LINE_THICKNESS);
		StdDraw.setPenColor(LINE_COLOR);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; ++j) {
				if (StdRandom.uniform() < p) {
					double theta_0 = alpha * i;
					double theta_1 = alpha * j;
					StdDraw.line(center + r * Math.cos(theta_0), center + r * Math.sin(theta_0),
							center + r * Math.cos(theta_1), center + r * Math.sin(theta_1));
				}
			}
		}
	}

	private static void plotPoints(int n, double center, int r, double alpha) {
		StdDraw.setPenRadius(DOT_SIZE);
		for (int i = 0; i < n; ++i) {
			double theta = alpha * i;
			StdDraw.point(center + r * Math.cos(theta), center + r * Math.sin(theta));
		}
	}
}
