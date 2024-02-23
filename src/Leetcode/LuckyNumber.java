package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int ansCol = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    ansCol = j;
                }
            }
            boolean isAns = true;

            for (int j = 0; j < m; j++) {
                int v1 = matrix[i][ansCol];
                int v2 = matrix[j][ansCol];
                if (v1 < v2) {
                    isAns = false;
                    break;
                }
            }

            if (isAns) {
                list.add(matrix[i][ansCol]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(luckyNumbers(matrix));
    }
}
