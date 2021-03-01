package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/implement-power-function/

public class ImplementPowerFunction {

    public static void main(String[] args) {
        ImplementPowerFunction obj = new ImplementPowerFunction();
        System.out.println(obj.pow(71045970, 41535484, 64735492));
    }

    public int pow(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        if (A < 0)
            return pow(A + C, B, C);
        long ans;
        long temp = pow(A, B / 2, C);
        long mul = temp % C;
        if (B % 2 == 0)
            ans = (mul * mul) % C;
        else
            ans = (((A * mul) % C) * mul) % C;
        return (int) ans;
    }
}
