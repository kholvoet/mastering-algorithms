package com.mournival.algs4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_01_31 {

    public Exercise_01_31() {
        super();
    }

    public static void main(String[] args) {

        //        int n = Integer.parseInt(args[0]);
        //        double p = Double.parseDouble(args[1]);
        int n = 64;
        double p = 0.50;

        int dim = 640;
        StdDraw.setCanvasSize(dim, dim);

        double c = dim / 2; // Center is (c,c)

        StdDraw.setScale(0, 2 * (1 + c));
//        StdDraw.circle(c, c, r);
        StdDraw.setPenRadius(0.005);

        int r = dim * 49 / 100;
        double alpha = 2.0 * Math.PI / n;
        for (int i = 0; i < n; ++i) {
            double theta = alpha * i;
            StdDraw.point(c + r * Math.cos(theta), c + r * Math.sin(theta));
        }

        StdDraw.setPenRadius(0.002);
        for (int i = 0; i < n; i++) {
            if (StdRandom.uniform() < p) {
                double theta_0 = alpha * i;
                double theta_1 = alpha * (i + 1);
                StdDraw.line(c + r * Math.cos(theta_0), c + r * Math.sin(theta_0), c + r * Math.cos(theta_1), c + r * Math.sin(theta_1));
            }
        }
    }
}
