package org.bonn.se.ws15.uebung8.util;

/**
 * Created by Nils on 03.12.2015.
 */
public class Util {
    private final static int fibonacci[] = {0, 1, 2, 3, 5, 8, 13, 20, 40, 100};

    public static boolean isFibonnaci(int n) {
        for (int f : fibonacci) {
            if (n == f) return true;
        }
        return false;
    }

    public static double calcPriority(int v, int e, int r, int p) {
        return (v + p) / (e + r);
    }

    public static boolean checkRange(int v, int r, int p) {
        if (v > Config.VALUE_MAX || v < 1) return false;
        if (r > Config.RISK_MAX || r < 1) return false;
        if (p > Config.PENALTY_MAX || p < 1) return false;
        return true;
    }
}
