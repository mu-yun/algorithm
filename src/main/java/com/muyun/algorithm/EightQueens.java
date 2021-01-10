package com.muyun.algorithm;

/**
 * @author muyun
 * @date 2021/1/9
 */
public class EightQueens {

    private int resultAmount = 0;

    private int[] result = new int[8];

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.calculateEightQueens();
    }

    public void calculateEightQueens() {
        calculateEightQueens(0);
        System.out.println(resultAmount);
    }

    private void calculateEightQueens(int row) {
        if (row == 8) {
            print(result);
            resultAmount++;
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (valid(row, column)) {
                result[row] = column;
                calculateEightQueens(row + 1);
            }
        }
    }

    private boolean valid(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;

        for (row = row - 1; row >= 0; row--) {
            if (result[row] == column) {
                return false;
            }
            if (leftUp >= 0 && result[row] == leftUp) {
                return false;
            }
            if (rightUp < 8 && result[row] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private static void print(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q  ");
                } else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

