package com.rubydev.fuzzylogic;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // item x profit[0] - weight[1]
        int[][] tabel = new int[3][2];
        tabel[0][0] = 10;
        tabel[0][1] = 25;
        tabel[1][0] = 9;
        tabel[1][1] = 10;
        tabel[2][0] = 9;
        tabel[2][1] = 10;

        int[][] v = new int[3][31];
        for (int i = 0; i < 3; i++) {
            v[i][0] = 0;
        }

        for (int i = 0; i < 31 ; i++) {
            v[0][i] = 0;
        }


        for (int i = 1; i < 3 ; i++) {
            for (int w = 1; w < 31; w++) {
                if (tabel[i][1] > w){
                    v[i][w] = v[i-1][w];
                } else {
                    int a = v[i-1][w];
                    int b = tabel[i][0] + v[i-1][w- tabel[i][1]];
                    v[i][w] = Math.max(a, b);
                }
            }
        }

        System.out.print("V");
        for (int j = 0; j < 31 ; j++) {
            System.out.format("%6s", j);
        }
        System.out.println();
        for (int i = 0; i < 3 ; i++) {
            System.out.print(i);
            for (int j = 0; j < 31 ; j++) {
                System.out.format("%6s", v[i][j]);
            }
            System.out.println();
        }

        int i = 3;
        int w = 30;
        while (i > 0 && w > 0 ){
            if (v[i][w] != v[i-1][w]){
                w = w - tabel[i][1];
                i = i -1;
            } else {
                i = i -1;
            }
        }
    }
}
