package com.chiang.acm;

public class SpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        System.out.println(ints[0][0]);
        int[] a = new int[n];
        boolean key = true;
        int roundBefore = 0;
        int round = 0;
        int i = 0;
        int j = 0;
        int value = 1;
        while (value <= Math.pow(n, 2)) {

            if (round % 4 == 0 && ints[i][j] == 0 && j < n) {
                ints[i][j++] = value++;
                roundBefore = 0;
            } else if (round % 4 == 1 && ints[i][j] == 0 && i < n) {
                ints[i++][j] = value++;
                roundBefore = 1;
            } else if (round % 4 == 2 && ints[i][j] == 0 && j >= 0) {
                ints[i][j--] = value++;
                roundBefore = 2;
            } else if (round % 4 == 3 && ints[i][j] == 0 && i >= 0) {
                ints[i--][j] = value++;
                roundBefore = 3;
            } else {
                round = (++round) % 4;
            }
            if (i < 0 || i >= n || j < 0 || j >= n) {
                if (roundBefore % 4 == 0) {
                    j--;
                    i++;
                } else if (roundBefore % 4 == 1) {
                    i--;
                    j--;
                } else if (roundBefore % 4 == 2) {
                    j++;
                    i--;
                } else if (roundBefore % 4 == 3) {
                    i++;
                    j++;
                }
                round = (++round) % 4;
            }else if (round != roundBefore) {
                if (ints[i][j] != 0) {
                    if (roundBefore % 4 == 0) {
                        j--;
                        i++;
                    } else if (roundBefore % 4 == 1) {
                        i--;
                        j--;
                    } else if (roundBefore % 4 == 2) {
                        j++;
                        i--;
                    } else if (roundBefore % 4 == 3) {
                        i++;
                        j++;
                    }
                }
            }


        }
        return ints;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] m = spiralMatrix.generateMatrix(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
