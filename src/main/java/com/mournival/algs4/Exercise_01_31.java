package com.mournival.algs4;

import edu.princeton.cs.algs4.StdDraw;

public class Exercise_01_31 {
	

   public static void main(String args[]) {

//        int n = Integer.parseInt(args[0]);
        int n = 8;
        int r = 40;
        double x_0 = 50;
        double y_0 = 50;
//            double p = Double.parseDouble(args[1]);
//
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        StdDraw.circle(x_0, y_0, r);


        double alpha = 2.0 * Math.PI / n;
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < n; ++i) {
            double theta = alpha * i;
            StdDraw.point(x_0 + r * Math.cos(theta), y_0 + r * Math.sin(theta));

        }
    }
}
