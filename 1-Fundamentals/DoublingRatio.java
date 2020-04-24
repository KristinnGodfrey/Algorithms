/******************************************************************************
 *  Compilation:  javac DoublingRatio.java
 *  Execution:    java DoublingRatio
 *  Dependencies: ThreeSum.java Stopwatch.java StdRandom.java StdOut.java
 *
 *
 *  % java DoublingRatio
 *      250     0.0   2.7
 *      500     0.0   4.8
 *     1000     0.1   6.9
 *     2000     0.6   7.7
 *     4000     4.5   8.0
 *     8000    35.7   8.0
 *     4000     3.9   6.6
 *  ...
 *
 ******************************************************************************/

package edu.princeton.cs.algs4;

public class DoublingRatio {
    private static final int MAXIMUM_INTEGER = 1000000;
 
    // This class should not be instantiated.
    private DoublingRatio() { }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; n < 20000; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
            prev = time;
        }         
    }
}